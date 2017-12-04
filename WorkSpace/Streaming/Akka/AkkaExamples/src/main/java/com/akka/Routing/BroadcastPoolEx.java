package com.akka.Routing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class BroadcastPoolEx {
	public void test() throws InterruptedException {

		final ActorSystem system = ActorSystem.create("BroadcastPool");
		final ActorRef ref = system.actorOf(Props.create(MsgEchoActor5.class), "BroadcastPoolRouter");

		ref.tell("hi", null);

	}

	public static void main(String[] args) throws InterruptedException {
		BroadcastPoolEx ex = new BroadcastPoolEx();
		ex.test();
	}
}
