package com.akka.io;

import java.net.InetSocketAddress;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.io.Tcp;

public class PullMode {
	ActorSystem system = ActorSystem.create("ActorSystem");
	private final LoggingAdapter log = Logging.getLogger(system, this);

	public void getTcpConnection() throws InterruptedException {

		ActorRef server = system.actorOf(Server.props(Tcp.get(system).manager()));
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8081);

		Thread.sleep(1000);
		ActorRef ref = system.actorOf(Props.create(Client.class, address, server));

	}

	public static void main(String[] args) throws InterruptedException {
		PullMode app = new PullMode();
		app.getTcpConnection();
	}

}
