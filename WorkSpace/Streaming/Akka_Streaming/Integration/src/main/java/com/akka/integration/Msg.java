package com.akka.integration;

import akka.actor.ActorRef;

public class Msg {

	final int id;
	final ActorRef replyTo;

	public Msg(int id, ActorRef replyTo) {

		this.id = id;
		this.replyTo = replyTo;
	}

	@Override
	public String toString() {

		return String.format("Msg(%s, %s)", id, replyTo);
	}

	public Msg msg(int id, ActorRef replyTo) {

		return new Msg(id, replyTo);

	}
}