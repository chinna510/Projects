package com.akka.distribute;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Replication_Update_Test {

	public void run() {

		Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + 2552)
				.withFallback(ConfigFactory.load());

		ActorSystem system = ActorSystem.create("ClusterSystem", config);

		ActorRef ref = system.actorOf(Props.create(Data_Update.class), "Listener");

	}

	public static void main(String[] args) {
		Replication_Update_Test test = new Replication_Update_Test();
		test.run();
	}

}
