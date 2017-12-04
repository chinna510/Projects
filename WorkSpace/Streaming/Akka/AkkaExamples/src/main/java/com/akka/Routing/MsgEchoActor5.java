package com.akka.Routing;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.FromConfig;

public class MsgEchoActor5 extends UntypedActor {
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	ActorRef ref = null;

	@Override
	public void preStart() throws Exception {
		this.ref = getContext().actorOf(FromConfig.getInstance().props(Props.create(Worker.class)), "router5");
		super.preStart();
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		for (int i = 1; i <= 10; i++) {

			ref.tell(i, ref.noSender());
			if (i == 5) {
				TimeUnit.MILLISECONDS.sleep(1000);
				System.out.println("\n");
			}
		}

	}

}
