package com.akka.persistance;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class PersistentActorFailureExample {
	public void test() {
		final ActorSystem system = ActorSystem.create("ExamplePersistentActor1");
		final ActorRef persistentActor = system.actorOf(Props.create(ExamplePersistentActor1.class),
				"persistentActor-2");
		persistentActor.tell("a", null);
	    persistentActor.tell("print", null);
	    persistentActor.tell("boom", null);
	    persistentActor.tell("print", null);
	    persistentActor.tell("b", null);
	    persistentActor.tell("print", null);
	    persistentActor.tell("c", null);
	    persistentActor.tell("print", null);
	}

	public static void main(String[] args) {
		PersistentActorFailureExample ex = new PersistentActorFailureExample();
		ex.test();
	}
}
