package com.akka.AkkaLambda;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class MyActor extends AbstractActor {

	LoggingAdapter log = Logging.getLogger(context().system(), this);

	private MyActor() {
		receive(ReceiveBuilder.match(String.class, s -> {
			log.info("Recieved Message Is :"+ s);
		}).matchAny(o -> log.info("REcieved Unknown Message")).build());

	}

}
