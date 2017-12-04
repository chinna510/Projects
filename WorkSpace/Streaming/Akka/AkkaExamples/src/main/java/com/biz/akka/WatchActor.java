package com.biz.akka;

import java.util.logging.Logger;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class WatchActor extends UntypedActor {
LoggingAdapter log=Logging.getLogger(getContext().system(), this);
	final ActorRef ref = this.getContext().actorOf(Props.empty(), "child");
	{
		this.getContext().watch(ref);
	}
	ActorRef lastSender = getContext().system().deadLetters();

	@Override
	public void onReceive(Object message) throws Exception {
		if (message.equals("kill")) {
			log.info("Recieved String Message "+ message);

			getContext().stop(ref);
			lastSender = getSender();
			log.info("LastSender : "+ lastSender);
			log.info("Actor Killed");
		} else if (message instanceof Terminated) {
			final Terminated t = (Terminated) message;
			if (t.getActor() == ref) {
				lastSender.tell("Finished", getSelf());
			}
		}else if(message instanceof String){
			log.info("Recieved String IS "+ message);
			getSender().tell(message, getSelf());

		}
			else {
		}
			unhandled(message);
		}

	}

