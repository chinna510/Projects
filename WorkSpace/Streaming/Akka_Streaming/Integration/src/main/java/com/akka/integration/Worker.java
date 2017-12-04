package com.akka.integration;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class Worker extends AbstractActor {

	public Worker() {

		receive(ReceiveBuilder.match(Work.class, work -> {

			sender().tell(WorkerPoolProtocol.reply(work.id), self());
		}).build());
	}

}
