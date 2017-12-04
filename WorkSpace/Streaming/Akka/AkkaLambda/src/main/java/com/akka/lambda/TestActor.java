package com.akka.lambda;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class TestActor {

	public void test() {
		ActorSystem system = ActorSystem.create("Demo");
		ActorRef ref = system.actorOf(Props.create(SomeOtherActor.class));
		ref.tell(42, ActorRef.noSender());

	}

	public static void main(String[] args) {
		TestActor test = new TestActor();
		test.test();
	}

}
