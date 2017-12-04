package com.akka.schedulers;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Cancellable;
import akka.actor.Props;
import scala.concurrent.duration.Duration;

public class TickerTest {

	public void test() {

		ActorSystem system = ActorSystem.create("Schedulers");
		ActorRef tickActor = system.actorOf(Props.create(Ticker.class));
		Cancellable cancel = system.scheduler().schedule(Duration.Zero(), Duration.create(2, TimeUnit.SECONDS),
				tickActor, "Tick", system.dispatcher(), null);
		// cancel.cancel();
	}

	public static void main(String[] args) {
		TickerTest test = new TickerTest();
		test.test();
	}

}