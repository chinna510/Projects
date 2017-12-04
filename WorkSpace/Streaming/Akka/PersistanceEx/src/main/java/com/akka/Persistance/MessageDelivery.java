package com.akka.Persistance;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class MessageDelivery {

	public void test() {
		final ActorSystem system = ActorSystem.create("Message");
		final ActorRef ref1 = system.actorOf(Props.create(MyDestination.class));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		final ActorRef ref = system.actorOf(Props.create(MyPersistentActor3.class, system.actorSelection(ref1.path())));

		ref.tell("Hi", ref1);
	}

	public static void main(String[] args) {
		MessageDelivery del = new MessageDelivery();
		del.test();
	}
}
