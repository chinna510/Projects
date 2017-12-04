package com.akka.extension;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ExtensionTest {

	public void test() {

		ActorSystem system = ActorSystem.create("AkkaExtensions");
		ActorRef exActor = system.actorOf(Props.create(MyActor.class));

		exActor.tell("Hi", null);
		
	}

	public static void main(String[] args) {
		ExtensionTest test = new ExtensionTest();
		test.test();
	}

}
