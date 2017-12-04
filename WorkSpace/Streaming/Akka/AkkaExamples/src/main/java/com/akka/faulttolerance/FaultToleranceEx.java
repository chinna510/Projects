package com.akka.faulttolerance;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class FaultToleranceEx {
	public void test() {

		Config config = ConfigFactory.parseString("akka.loglevel = DEBUG \n" + "akka.actor.debug.lifecycle = on");

		ActorSystem system = ActorSystem.create("ActorSystem", config);
		ActorRef worker = system.actorOf(Props.create(Worker.class), "worker");
		ActorRef listener = system.actorOf(Props.create(Listener.class), "listener");
		worker.tell("Start", listener);

	}

	public static void main(String[] args) {
		FaultToleranceEx fault = new FaultToleranceEx();
		fault.test();
	}
}
