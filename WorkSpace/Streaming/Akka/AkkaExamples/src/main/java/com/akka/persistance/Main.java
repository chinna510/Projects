package com.akka.persistance;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {

	public void test() {
		ActorSystem system = ActorSystem.create("AkkaPersistance");
		ActorRef ref = system.actorOf(Props.create(ExamplePersistentActor.class));
		Evt evt = new Evt("HI");
		ref.tell(new Cmd("hi1"), ref.noSender());
		ref.tell(new Cmd("hi2"), ref.noSender());
		ref.tell(new Cmd("hi3"), ref.noSender());

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.test();
	}
}
