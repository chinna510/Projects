package com.akka.Networking;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.ClusterEvent.MemberEvent;
import akka.cluster.ClusterEvent.MemberRemoved;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.ClusterEvent.UnreachableMember;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class SimpleClusterListener extends UntypedActor {
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	Cluster cluster = Cluster.get(getContext().system());

	@SuppressWarnings("static-access")
	public void preRestart() {
		cluster.subscribe(getSelf(), ClusterEvent.initialStateAsEvents(), MemberEvent.class, UnreachableMember.class);
		
	}

	@Override
	public void postStop() throws Exception {
		cluster.unsubscribe(getSelf());
	}

	@Override
	public void onReceive(Object message) throws Exception {

		if (message instanceof MemberUp) {
			MemberUp mup = (MemberUp) message;

			log.info("Member Up is :" + mup.member());

		} else if (message instanceof UnreachableMember) {

			UnreachableMember unMem = (UnreachableMember) message;

			log.info("Member detected as unreachable: " + unMem.member());

		} else if (message instanceof MemberRemoved) {

			MemberRemoved mremove = (MemberRemoved) message;

			log.info("Member is Removed: {}", mremove.member());

		} else if (message instanceof MemberEvent) {

		} else {
			unhandled(message);
		}
	}

}
