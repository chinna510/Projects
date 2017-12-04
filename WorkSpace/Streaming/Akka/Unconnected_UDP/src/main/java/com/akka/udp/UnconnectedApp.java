package com.akka.udp;

import java.net.InetSocketAddress;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class UnconnectedApp {

	public void getUdpManager() throws InterruptedException {

		ActorSystem system = ActorSystem.create("UDPExample");
		InetSocketAddress address = new InetSocketAddress("localhost", 8082);
		ActorRef sender = system.actorOf(SimpleSender.props(address), "Sender");
		Thread.sleep(1000);
		ActorRef listener = system.actorOf(Props.create(Listener.class, sender), "Listener");

		Thread.sleep(1000);
		sender.tell("Msg from sender... ", null);
	}

	public static void main(String[] args) throws InterruptedException {
		UnconnectedApp app = new UnconnectedApp();
		app.getUdpManager();
	}
}