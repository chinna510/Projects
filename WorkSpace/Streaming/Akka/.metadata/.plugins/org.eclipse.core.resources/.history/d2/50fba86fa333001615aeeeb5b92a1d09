package com.akka.distribute;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class SenderTest {

	public void test() throws InterruptedException {
		Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + 2553)
				.withFallback(ConfigFactory.load());
		ActorSystem system = ActorSystem.create("ActorSystem", config);
		ActorRef ref = system.actorOf(Props.create(Sender.class), "sender");

		for (int i = 1; i <= 1000000; i++) {
			Thread.sleep(1000);
			ref.tell("hello" + i, null);
		}

	}

	public static void main(String[] args) throws InterruptedException {
		SenderTest test = new SenderTest();
		test.test();
	}

}
