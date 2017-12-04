package com.akka.logging;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class LoggingActorTest {

	public void test() {

		ActorSystem system = ActorSystem.create("Logging");
		ActorRef logref = system.actorOf(Props.create(MyActor.class));

		logref.tell("test1", ActorRef.noSender());
	}

	public static void main(String[] args) {
		LoggingActorTest test = new LoggingActorTest();
		test.test();
	}
}