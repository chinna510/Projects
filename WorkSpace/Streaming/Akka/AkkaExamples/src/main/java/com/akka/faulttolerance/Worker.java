package com.akka.faulttolerance;

import static akka.actor.SupervisorStrategy.escalate;
import static akka.actor.SupervisorStrategy.stop;
import static akka.japi.Util.classTag;
import static akka.pattern.Patterns.ask;
import static akka.pattern.Patterns.pipe;
import static com.akka.faulttolerance.CounterServiceApi.GetCurrentCount;
import static com.akka.faulttolerance.WorkerApi.Do;

import com.akka.faulttolerance.CounterServiceApi.CurrentCount;
import com.akka.faulttolerance.CounterServiceApi.Increment;
import com.akka.faulttolerance.CounterServiceApi.ServiceUnavailable;
import com.akka.faulttolerance.WorkerApi.Progress;

import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.actor.UntypedActor;
import akka.dispatch.Mapper;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Function;
import akka.util.Timeout;
import scala.concurrent.duration.Duration;

public class Worker extends UntypedActor {
	final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	final Timeout askTimeout = new Timeout(Duration.create(5, "seconds"));

	ActorRef progressListener;
	final ActorRef counterService = getContext().actorOf(Props.create(CounterService.class), "counter");
	final int totalCount = 51;

	// Stop the CounterService child if it throws ServiceUnavailable
	private static SupervisorStrategy strategy = new OneForOneStrategy(-1, Duration.Inf(),
			new Function<Throwable, Directive>() {
				public Directive apply(Throwable t) {
					if (t instanceof ServiceUnavailable) {
						return stop();
					} else {
						return escalate();
					}
				}
			});

	@Override
	public SupervisorStrategy supervisorStrategy() {
		return strategy;
	}

	public void onReceive(Object msg) {
		log.debug("received message {}", msg);
		if (msg.equals("Start") && progressListener == null) {
			progressListener = getSender();
			getContext().system().scheduler().schedule(Duration.Zero(), Duration.create(1, "second"), getSelf(), Do,
					getContext().dispatcher(), null);
		} else if (msg.equals("Do")) {
			counterService.tell(new Increment(1), getSelf());
			counterService.tell(new Increment(1), getSelf());
			counterService.tell(new Increment(1), getSelf());

			// Send current progress to the initial sender
			pipe(ask(counterService, GetCurrentCount, askTimeout).mapTo(classTag(CurrentCount.class))
					.map(new Mapper<CurrentCount, Progress>() {
						public Progress apply(CurrentCount c) {
							return new Progress(100.0 * c.count / totalCount);
						}
					}, getContext().dispatcher()), getContext().dispatcher()).to(progressListener);
		} else {
			unhandled(msg);
		}
	}

}
