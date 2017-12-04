package com.akka.Routing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class SmallestMailboxPoolEx {
	public void test() throws InterruptedException {

		final ActorSystem system = ActorSystem.create("SmallestMailboxPool");
		final ActorRef ref = system.actorOf(Props.create(MsgEchoActor4.class), "SmallestMailboxPoolRouter");

		ref.tell("hi", null);

	}

	public static void main(String[] args) throws InterruptedException {
		SmallestMailboxPoolEx ex = new SmallestMailboxPoolEx();
		ex.test();
	}
}
