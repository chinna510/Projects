package com.akka.ScanningBus;

import akka.actor.ActorRef;
import akka.event.japi.ScanningEventBus;

public class ScanningBusImpl extends ScanningEventBus<String, ActorRef, Integer> {

	@Override
	public int compareClassifiers(Integer a, Integer b) {
		return a.compareTo(b);
	}

	@Override
	public int compareSubscribers(ActorRef a, ActorRef b) {
		return a.compareTo(b);
	}

	@Override
	public void publish(String event, ActorRef subscriber) {

		subscriber.tell(event, ActorRef.noSender());
	}

	@Override
	public boolean matches(Integer classifier, String event) {
		return event.length() <= classifier;
	}

}
