package com.akka.distribute;

import java.util.concurrent.TimeUnit;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Cancellable;
import akka.cluster.Cluster;
import akka.cluster.ddata.DistributedData;
import akka.cluster.ddata.Key;
import akka.cluster.ddata.ORSet;
import akka.cluster.ddata.ORSetKey;
import akka.cluster.ddata.Replicator;
import akka.cluster.ddata.Replicator.Changed;
import akka.cluster.ddata.Replicator.Subscribe;
import akka.cluster.ddata.Replicator.Update;
import akka.cluster.ddata.Replicator.UpdateResponse;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import scala.concurrent.duration.Duration;
import scala.concurrent.forkjoin.ThreadLocalRandom;

public class DataBot extends AbstractActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	private static final String TICK = "tick";

	private final ActorRef replicator = DistributedData.get(getContext().system()).replicator();
	private final Cluster node = Cluster.get(context().system());

	private final Cancellable tickTask = context().system().scheduler().schedule(Duration.create(5, TimeUnit.SECONDS),
			Duration.create(5, TimeUnit.SECONDS), self(), TICK, context().dispatcher(), self());

	private final Key<ORSet<String>> dataKey = ORSetKey.create("key");

	public DataBot() {
		receive(ReceiveBuilder.match(String.class, a -> a.equals(TICK), a -> receiveTick())
				.match(Changed.class, c -> c.key().equals(dataKey), c -> receiveChanged((Changed<ORSet<String>>) c))
				.match(UpdateResponse.class, r -> receiveUpdateResoponse()).build());
	}

	private void receiveTick() {
		String s = String.valueOf((char) ThreadLocalRandom.current().nextInt(97, 123));
		if (ThreadLocalRandom.current().nextBoolean()) {
			// add
			log.info("Adding: {}", s);
			Update<ORSet<String>> update = new Update<>(dataKey, ORSet.create(), Replicator.writeLocal(),
					curr -> curr.add(node, s));
			replicator.tell(update, self());
		} else {
			// remove
			log.info("Removing: {}", s);
			Update<ORSet<String>> update = new Update<>(dataKey, ORSet.create(), Replicator.writeLocal(),
					curr -> curr.remove(node, s));
			replicator.tell(update, self());
		}
	}

	private void receiveChanged(Changed<ORSet<String>> c) {
		ORSet<String> data = c.dataValue();
		log.info("Current elements: {}", data.getElements());
	}

	private void receiveUpdateResoponse() {
	}

	@Override
	public void preStart() {
		Subscribe<ORSet<String>> subscribe = new Subscribe<>(dataKey, self());
		replicator.tell(subscribe, ActorRef.noSender());
	}

	@Override
	public void postStop() {
		tickTask.cancel();
	}

}