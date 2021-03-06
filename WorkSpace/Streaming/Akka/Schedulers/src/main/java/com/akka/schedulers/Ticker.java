package com.akka.schedulers;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Ticker extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg.equals("Tick")) {
			log.info("Recieved Message is : " + msg);
		} else {
			unhandled(msg);
		}
	}

}
