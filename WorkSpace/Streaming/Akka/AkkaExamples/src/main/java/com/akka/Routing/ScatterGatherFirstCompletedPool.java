package com.akka.Routing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ScatterGatherFirstCompletedPool {
	public void test() throws InterruptedException {

		final ActorSystem system = ActorSystem.create("ScatterGatherFirstCompletedPool");
		final ActorRef ref = system.actorOf(Props.create(MsgEchoActor6.class),
				"ScatterGatherFirstCompletedPoolExample");

		ref.tell("hi", null);

	}

	public static void main(String[] args) throws InterruptedException {
		ScatterGatherFirstCompletedPool ex = new ScatterGatherFirstCompletedPool();
		ex.test();
	}
}
