package com.akka.FSM;

import akka.actor.ActorRef;

public final class SetTarget {
	final ActorRef ref;

	public SetTarget(ActorRef ref) {
		this.ref = ref;
	}
}
