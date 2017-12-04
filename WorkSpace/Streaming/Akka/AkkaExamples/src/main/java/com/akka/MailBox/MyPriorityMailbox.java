package com.akka.MailBox;

import com.typesafe.config.Config;

import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedStablePriorityMailbox;

public class MyPriorityMailbox extends UnboundedStablePriorityMailbox {

	public MyPriorityMailbox(ActorSystem.Settings settings, Config config) {
		super(new PriorityGenerator() {

			@Override
			public int gen(Object message) {
				if (message.equals("highpriority"))
					return 0;
				else if (message.equals("lowpriority"))
					return 2;
				else if (message.equals(PoisonPill.getInstance()))
					return 3;
				else
					return 1;
			}
		});

	}

}
