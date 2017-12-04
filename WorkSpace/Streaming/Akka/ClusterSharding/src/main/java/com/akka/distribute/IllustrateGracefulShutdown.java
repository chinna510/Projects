package com.akka.distribute;

import java.util.concurrent.TimeUnit;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Terminated;
import akka.cluster.Cluster;
import akka.cluster.sharding.ClusterSharding;
import akka.cluster.sharding.ShardRegion;
import akka.japi.pf.ReceiveBuilder;
import scala.concurrent.duration.Duration;

public class IllustrateGracefulShutdown extends AbstractActor {

	public IllustrateGracefulShutdown() {

		final ActorSystem system = context().system();
		final Cluster cluster = Cluster.get(system);
		final ActorRef region = ClusterSharding.get(system).shardRegion("Entity");

		receive(ReceiveBuilder.match(String.class, s -> s.equals("leave"), s -> {
			context().watch(region);
			region.tell(ShardRegion.gracefulShutdownInstance(), self());
		}).match(Terminated.class, t -> t.actor().equals(region), t -> {
			cluster.registerOnMemberRemoved(() -> self().tell("member-removed", self()));
			cluster.leave(cluster.selfAddress());
		}).match(String.class, s -> s.equals("member-removed"), s -> {
			// Let singletons hand over gracefully before stopping the system
			context().system().scheduler().scheduleOnce(Duration.create(10, TimeUnit.SECONDS), self(), "stop-system",
					context().dispatcher(), self());
		}).match(String.class, s -> s.equals("stop-system"), s -> {
			system.terminate();
		}).build());
	}
}
