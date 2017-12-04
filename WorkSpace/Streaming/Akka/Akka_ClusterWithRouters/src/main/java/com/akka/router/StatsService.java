package com.akka.router;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.FromConfig;

public class StatsService extends UntypedActor implements StatsMessages {
	ActorRef workerRouter = getContext().actorOf(FromConfig.getInstance().props(Props.create(StatsWorker.class)),
			"workerRouter");

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof StatsJob) {
			StatsJob job = (StatsJob) message;
			if (job.getText().equals("")) {
				unhandled(message);
			} else {
				final String[] words = job.getText().split(" ");
				final ActorRef replyTo = getSender();

				// create actor that collects replies from workers
				ActorRef aggregator = getContext().actorOf(Props.create(StatsAggregator.class, words.length, replyTo));

				// send each word to a worker
				for (String word : words) {
					// workerRouter.tell(new ConsistentHashableEnvelope(word,
					// word), aggregator);
				}
			}

		} else {
			unhandled(message);
		}
	}
}
