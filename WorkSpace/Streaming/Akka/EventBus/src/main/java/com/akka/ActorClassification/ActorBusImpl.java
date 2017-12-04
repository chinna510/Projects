package com.akka.ActorClassification;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.event.japi.ManagedActorEventBus;

public class ActorBusImpl extends ManagedActorEventBus<Notification> {

	public ActorBusImpl(ActorSystem system) {
		super(system);
	}

	@Override
	public ActorRef classify(Notification event) {
		System.out.println(event.ref);
		return event.ref;
	}

	@Override
	public int mapSize() {
		return 128;
	}

}