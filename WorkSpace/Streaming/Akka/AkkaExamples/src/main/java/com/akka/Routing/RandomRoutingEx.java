package com.akka.Routing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class RandomRoutingEx {
	public void test() throws InterruptedException {

		final ActorSystem system = ActorSystem.create("Random");
		final ActorRef ref = system.actorOf(Props.create(MsgEchoActor2.class), "randomExample");

		ref.tell("hi", null);

	}

	public static void main(String[] args) throws InterruptedException {
		RandomRoutingEx ex = new RandomRoutingEx();
		ex.test();
	}
}
