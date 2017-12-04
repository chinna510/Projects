package com.akka.lambda;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class SomeOtherActor extends AbstractActor {
	LoggingAdapter log = Logging.getLogger(context().system(), this);

	public SomeOtherActor() {
		receive(ReceiveBuilder.match(Integer.class, s -> {
			log.info("Recieved Message Is " + s);
			ref.tell(s, self());
			ref = context().system().deadLetters();
		}).build());

	};

	ActorRef ref = context().actorOf(DemoActor.props(10), "Demo");
}
