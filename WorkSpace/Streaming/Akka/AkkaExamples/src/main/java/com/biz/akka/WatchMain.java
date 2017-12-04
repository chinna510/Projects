package com.biz.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Terminated;

public class WatchMain {
	public void test() {
		final ActorSystem system = ActorSystem.create("akkaSystem");
		final ActorRef ref = system.actorOf(Props.create(WatchActor.class), "WatchActor");
		System.out.println("path "+ref.path());
		ref.tell("Terminated", ActorRef.noSender());
	}

	public static void main(String[] args) {
		WatchMain main = new WatchMain();
		main.test();
	}
}
