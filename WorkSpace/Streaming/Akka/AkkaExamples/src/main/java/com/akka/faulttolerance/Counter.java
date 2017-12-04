package com.akka.faulttolerance;

import com.akka.faulttolerance.CounterApi.UseStorage;
import com.akka.faulttolerance.CounterServiceApi.CurrentCount;
import com.akka.faulttolerance.CounterServiceApi.*;

import com.akka.faulttolerance.StorageApi.Entry;
import com.akka.faulttolerance.StorageApi.Store;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Counter extends UntypedActor {
	final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	final String key;
	long count;
	ActorRef storage;

	public Counter(String key, long initialValue) {
		this.key = key;
		this.count = initialValue;
	}

	@Override
	public void onReceive(Object msg) {
		log.debug("received message {}", msg);
		if (msg instanceof UseStorage) {
			storage = ((UseStorage) msg).storage;
			storeCount();
		} else if (msg instanceof Increment) {
			count += ((Increment) msg).n;
			storeCount();
		} else if (msg.equals("GetCurrentCount")) {
			getSender().tell(new CurrentCount(key, count), getSelf());
		} else {
			unhandled(msg);
		}
	}

	void storeCount() {
		// Delegate dangerous work, to protect our valuable state.
		// We can continue without storage.
		if (storage != null) {
			storage.tell(new Store(new Entry(key, count)), getSelf());
		}
	}
}
