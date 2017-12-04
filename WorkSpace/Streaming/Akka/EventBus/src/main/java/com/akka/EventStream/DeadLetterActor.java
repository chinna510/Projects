package com.akka.EventStream;

import akka.actor.DeadLetter;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class DeadLetterActor extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) throws Exception {

		if (msg instanceof DeadLetter) {

			log.info("DeadLetter Message : " + msg);

		}

	}

}
