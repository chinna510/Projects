package com.akka.AkkaLambda;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ActorTest {

	public void test() {
		ActorSystem system = ActorSystem.create("LambdaSupport");
		ActorRef ref = system.actorOf(Props.create(MyActor.class));
		ref.tell("Hi", ActorRef.noSender());
	}

	public static void main(String[] args) {
		ActorTest test = new ActorTest();
		test.test();
	}

}
