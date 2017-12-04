package com.akka.Routing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class TailChoppingPoolEx {
	public void test() throws InterruptedException {

		final ActorSystem system = ActorSystem.create("TailChoppingPoolEx");
		final ActorRef ref = system.actorOf(Props.create(MsgEchoActor7.class), "TailChoppingPoolExExample");

		ref.tell("hi", null);

	}

	public static void main(String[] args) throws InterruptedException {
		TailChoppingPoolEx ex = new TailChoppingPoolEx();
		ex.test();
	}
}
