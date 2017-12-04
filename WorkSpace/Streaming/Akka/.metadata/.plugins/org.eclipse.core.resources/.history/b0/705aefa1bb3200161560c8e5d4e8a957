package com.akka.Networking;

import java.util.ArrayList;
import java.util.List;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.Props;
import akka.cluster.Cluster;

public class NetworkTest {

	public void test(String port) {
		Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
				.withFallback(ConfigFactory.load());
		final ActorSystem system = ActorSystem.create("ClusterSystem", config);
		final ActorRef ref = system.actorOf(Props.create(SimpleClusterListener.class));
		ref.tell("Up", null);
		List<Address> list = new ArrayList<Address>();
		list.add(new Address("akka.tcp", "ClusterSystem", "localhost", 2551));
		Cluster.get(system).joinSeedNodes(list);
	}

	public static void main(String[] args) {

		NetworkTest test = new NetworkTest();

		test.test(args[0]);
	}

}
