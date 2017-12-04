package com.akka.ActorClassification;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.JavaTestKit;
import scala.concurrent.duration.FiniteDuration;

public class ActorClassifierTest {

	ActorSystem system = ActorSystem.create("ActorClassifier");

	public void test() {
		ActorRef observer1 = new JavaTestKit(system).getRef();
		ActorRef observer2 = new JavaTestKit(system).getRef();

		JavaTestKit probe1 = new JavaTestKit(system);
		JavaTestKit probe2 = new JavaTestKit(system);

		ActorRef subscriber1 = probe1.getRef();
		ActorRef subscriber2 = probe2.getRef();

		ActorBusImpl actorBus = new ActorBusImpl(system);
		actorBus.subscribe(subscriber1, observer1);
		actorBus.subscribe(subscriber2, observer1);
		actorBus.subscribe(subscriber2, observer2);

		Notification n1 = new Notification(observer1, 100);
		actorBus.publish(n1);
		probe1.expectMsgEquals(n1);
		probe2.expectMsgEquals(n1);

		Notification n2 = new Notification(observer2, 101);
		actorBus.publish(n2);
		probe2.expectMsgEquals(n2);

		probe1.expectNoMsg(FiniteDuration.create(500, TimeUnit.MILLISECONDS));
	}

	public static void main(String[] args) {
		
		ActorClassifierTest test = new ActorClassifierTest();
		test.test();
	}
}
