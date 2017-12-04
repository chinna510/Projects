package com.akka.faulttolerance;

import static akka.actor.SupervisorStrategy.escalate;
import static com.akka.faulttolerance.CounterServiceApi.GetCurrentCount;

import java.util.ArrayList;
import java.util.List;

import com.akka.faulttolerance.CounterApi.UseStorage;
import com.akka.faulttolerance.CounterServiceApi.Increment;
import com.akka.faulttolerance.CounterServiceApi.ServiceUnavailable;
import com.akka.faulttolerance.StorageApi.Entry;
import com.akka.faulttolerance.StorageApi.Get;
import com.akka.faulttolerance.StorageApi.StorageException;
import static akka.actor.SupervisorStrategy.restart;

import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Function;
import scala.concurrent.duration.Duration;

public class CounterService extends UntypedActor {
	static final Object Reconnect = "Reconnect";

	private static class SenderMsgPair {
		final ActorRef sender;
		final Object msg;

		SenderMsgPair(ActorRef sender, Object msg) {
			this.msg = msg;
			this.sender = sender;
		}
	}

	final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	final String key = getSelf().path().name();
	ActorRef storage;
	ActorRef counter;
	final List<SenderMsgPair> backlog = new ArrayList<SenderMsgPair>();
	final int MAX_BACKLOG = 10000;

	// Restart the storage child when StorageException is thrown.
	// After 3 restarts within 5 seconds it will be stopped.
	private static SupervisorStrategy strategy = new OneForOneStrategy(3, Duration.create("5 seconds"),
			new Function<Throwable, Directive>() {

				public Directive apply(Throwable t) {
					if (t instanceof StorageException) {
						return restart();
					} else {
						return escalate();
					}
				}
			});

	@Override
	public SupervisorStrategy supervisorStrategy() {
		return strategy;
	}

	@Override
	public void preStart() {
		initStorage();
	}

	void initStorage() {
		storage = getContext().watch(getContext().actorOf(Props.create(Storage.class), "storage"));
		// Tell the counter, if any, to use the new storage
		if (counter != null)
			counter.tell(new UseStorage(storage), getSelf());
		// We need the initial value to be able to operate
		storage.tell(new Get(key), getSelf());
	}

	@Override
	public void onReceive(Object msg) {
		log.debug("received message {}", msg);
		if (msg instanceof Entry && ((Entry) msg).key.equals(key) && counter == null) {
			// Reply from Storage of the initial value, now we can create the
			// Counter
			final long value = ((Entry) msg).value;
			counter = getContext().actorOf(Props.create(Counter.class, key, value));
			// Tell the counter to use current storage
			counter.tell(new UseStorage(storage), getSelf());
			// and send the buffered backlog to the counter
			for (SenderMsgPair each : backlog) {
				counter.tell(each.msg, each.sender);
			}
			backlog.clear();
		} else if (msg instanceof Increment) {
			forwardOrPlaceInBacklog(msg);
		} else if (msg.equals(GetCurrentCount)) {
			forwardOrPlaceInBacklog(msg);
		} else if (msg instanceof Terminated) {
			// After 3 restarts the storage child is stopped.
			// We receive Terminated because we watch the child, see
			// initStorage.
			storage = null;
			// Tell the counter that there is no storage for the moment
			counter.tell(new UseStorage(null), getSelf());
			// Try to re-establish storage after while
			getContext().system().scheduler().scheduleOnce(Duration.create(10, "seconds"), getSelf(), Reconnect,
					getContext().dispatcher(), null);
		} else if (msg.equals(Reconnect)) {
			// Re-establish storage after the scheduled delay
			initStorage();
		} else {
			unhandled(msg);
		}
	}

	void forwardOrPlaceInBacklog(Object msg) {
		// We need the initial value from storage before we can start delegate
		// to
		// the counter. Before that we place the messages in a backlog, to be
		// sent
		// to the counter when it is initialized.
		if (counter == null) {
			if (backlog.size() >= MAX_BACKLOG)
				throw new ServiceUnavailable("CounterService not available," + " lack of initial value");
			backlog.add(new SenderMsgPair(getSender(), msg));
		} else {
			counter.forward(msg, getContext());
		}
	}
}
