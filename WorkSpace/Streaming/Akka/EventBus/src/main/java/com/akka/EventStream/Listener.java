package com.akka.EventStream;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Listener extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof Jazz) {
			log.info(getSelf().path().name() + " is listening to: " + ((Jazz) msg).getArtist());

		} else if (msg instanceof Electronic) {
			log.info(getSelf().path().name() + " is listening to: " + ((Electronic) msg).getArtist());
		}
	}

}