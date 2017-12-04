package com.akka.Persistance;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Test {

	public void test() {
		final ActorSystem system = ActorSystem.create("ActorSystem");
		final ActorRef ref = system.actorOf(Props.create(MyPersistentActor.class));
		// ref.tell("Hi", null);
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}
}
