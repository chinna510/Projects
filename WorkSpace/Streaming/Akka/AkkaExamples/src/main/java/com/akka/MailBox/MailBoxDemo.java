package com.akka.MailBox;

import akka.actor.PoisonPill;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MailBoxDemo extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	{
		for (Object msg : new Object[] { "lowpriority", "lowpriority", "highpriority", "pigdog", "pigdog2", "pigdog3",
				"highpriority", PoisonPill.getInstance() }) {
			getSelf().tell(msg, getSelf());
		}
	}

	@Override
	public void onReceive(Object message) throws Exception {
		log.info(message.toString());

	}

}
