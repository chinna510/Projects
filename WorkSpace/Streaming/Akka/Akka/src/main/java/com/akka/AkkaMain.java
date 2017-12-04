package com.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaMain {

	@SuppressWarnings("unused")
	public void notifier() {

		ActorSystem system = ActorSystem.create("Notifier");

		ActorRef actor1 = system.actorOf(Props.create(Actor1.class), "Actor1");

		ActorRef actor2 = system.actorOf(Props.create(Actor2.class), "Actor2");

		actor1.tell("hi", ActorRef.noSender());

	}

	public static void main(String[] args) {

		AkkaMain main = new AkkaMain();
		main.notifier();
	}

}