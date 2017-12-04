package com.akka;

import akka.actor.UntypedActor;

import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Actor2 extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) throws Exception {

		if (msg instanceof String) {
			
			log.info("Recieved Message From Actor1 Is : " + msg);
			
		}

	}

}