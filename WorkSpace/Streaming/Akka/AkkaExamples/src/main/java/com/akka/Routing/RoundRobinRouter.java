package com.akka.Routing;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class RoundRobinRouter {
	public void test() throws InterruptedException {

		final ActorSystem system = ActorSystem.create("RoundRobin");
		final ActorRef ref = system.actorOf(Props.create(MsgEchoActor.class),
				"routerExample");
		
		ref.tell("hi", null);

	}

	public static void main(String[] args) throws InterruptedException {
		RoundRobinRouter ex = new RoundRobinRouter();
		ex.test();
	}
}
