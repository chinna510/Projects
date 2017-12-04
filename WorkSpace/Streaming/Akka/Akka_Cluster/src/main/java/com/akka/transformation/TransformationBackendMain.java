package com.akka.transformation;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;
import akka.actor.Props;

public class TransformationBackendMain {

	public void test(String port) {
		final Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
				.withFallback(ConfigFactory.parseString("akka.cluster.roles = [backend]"))
				.withFallback(ConfigFactory.load());

		ActorSystem system = ActorSystem.create("ClusterSystem", config);

		system.actorOf(Props.create(TransformationBackend.class), "backend");

	}

	public static void main(String[] args) {
		TransformationBackendMain main = new TransformationBackendMain();
		main.test(args[0]);
	}

}
