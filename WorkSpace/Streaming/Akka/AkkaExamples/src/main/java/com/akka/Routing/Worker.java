package com.akka.Routing;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Worker extends UntypedActor {
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) throws Exception {

		log.info("Recieved Message in Worker "+ msg +" With Actor "+ getSelf().path());
	}

}
