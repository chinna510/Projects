package com.akka.Persistance;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyDestination extends UntypedActor {
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	public void onReceive(Object message) throws Exception {
		log.info("Delivered Message : " + message);
		if (message instanceof Msg) {
			Msg msg = (Msg) message;

			getSender().tell(new Confirm(msg.deliveryId), getSelf());
		} else {
			unhandled(message);
		}
	}
}
