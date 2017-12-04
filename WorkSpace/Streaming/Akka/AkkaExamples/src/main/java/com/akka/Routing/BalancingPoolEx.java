package com.akka.Routing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class BalancingPoolEx {
	public void test() throws InterruptedException {

		final ActorSystem system = ActorSystem.create("BalancingPool");
		final ActorRef ref = system.actorOf(Props.create(MsgEchoActor3.class), "balancePoolExample");

		ref.tell("hi", null);

	}

	public static void main(String[] args) throws InterruptedException {
		BalancingPoolEx ex = new BalancingPoolEx();
		ex.test();
	}
}
