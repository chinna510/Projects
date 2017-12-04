package com.akka.ActorClassification;

import akka.actor.ActorRef;

public class Notification {

	public final ActorRef ref;
	public final int id;

	public Notification(ActorRef ref, int id) {
		this.ref = ref;
		this.id = id;
	}

}
