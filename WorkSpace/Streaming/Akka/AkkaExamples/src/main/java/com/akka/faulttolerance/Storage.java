package com.akka.faulttolerance;

import com.akka.faulttolerance.StorageApi.Entry;
import com.akka.faulttolerance.StorageApi.Get;
import com.akka.faulttolerance.StorageApi.Store;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Storage extends UntypedActor {
	final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	final DummyDB db = DummyDB.instance;

	@Override
	public void onReceive(Object msg) {
		log.debug("received message {}", msg);
		if (msg instanceof Store) {
			Store store = (Store) msg;
			db.save(store.entry.key, store.entry.value);
		} else if (msg instanceof Get) {
			Get get = (Get) msg;
			Long value = db.load(get.key);
			getSender().tell(new Entry(get.key, value == null ? Long.valueOf(0L) : value), getSelf());
		} else {
			unhandled(msg);
		}
	}
}
