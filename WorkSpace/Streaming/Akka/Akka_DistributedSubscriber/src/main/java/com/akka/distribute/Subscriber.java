package com.akka.distribute;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.pubsub.DistributedPubSub;
import akka.cluster.pubsub.DistributedPubSubMediator;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.Option;

public class Subscriber extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	Cluster cluster = Cluster.get(getContext().system());

	@Override
	public void preRestart(Throwable reason, Option<Object> message) throws Exception {

		cluster.subscribe(getSelf(), MemberUp.class);

	}

	@Override
	public void postStop() throws Exception {
		cluster.unsubscribe(getSelf());
	}

	public Subscriber() {

		ActorRef mediater = DistributedPubSub.get(getContext().system()).mediator();

		mediater.tell(new DistributedPubSubMediator.Subscribe("content", getSelf()), getSelf());

	}

	@Override
	public void onReceive(Object msg) throws Exception {

		if (msg instanceof String) {
	
			log.info("Recieved Message is : " + msg);

		} else if (msg instanceof DistributedPubSubMediator.SubscribeAck) {
			log.info("Subscribing .....");
		} else {
			unhandled(msg);
		}
	}

}