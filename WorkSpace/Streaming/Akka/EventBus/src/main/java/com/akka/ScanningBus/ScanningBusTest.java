package com.akka.ScanningBus;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

public class ScanningBusTest {

	ActorSystem system = ActorSystem.create("ScanningBus");
	JavaTestKit probe1 = new JavaTestKit(system);

	public void test() {

		new JavaTestKit(system) {
			{
				ScanningBusImpl scanningBus = new ScanningBusImpl();
				scanningBus.publish("xyzabc");
				scanningBus.subscribe(system.actorOf(Props.create(TestActor.class)), 3);

				scanningBus.publish("ab");
				expectMsgEquals("ab");
				scanningBus.publish("abc");
				expectMsgEquals("abc");
			}
		};

	}

	public static void main(String[] args) {
		ScanningBusTest test = new ScanningBusTest();
		test.test();
	}
}
