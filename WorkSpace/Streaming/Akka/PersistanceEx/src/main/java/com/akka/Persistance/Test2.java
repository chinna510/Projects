package com.akka.Persistance;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Test2 {

	public void test() {
		final ActorSystem system = ActorSystem.create("ActorSystem");
		final ActorRef ref = system.actorOf(Props.create(MyPersistentActor1.class));
		ref.tell("Hi", null);
		ref.tell("Hi1", null);
		ref.tell("Hiiiiiiii", null);
		ref.tell("Hi111111", null);
		ref.tell("Hifffffff", null);
		ref.tell("Hi1hhhhhhhhhh", null);
	}

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.test();
	}
}
