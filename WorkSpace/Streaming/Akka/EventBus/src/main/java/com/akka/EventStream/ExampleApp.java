package com.akka.EventStream;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.DeadLetter;
import akka.actor.Props;
import akka.event.Logging;

public class ExampleApp {

	ActorSystem system = ActorSystem.create("StreamEvent");

	public void test() {

		ActorRef actor = system.actorOf(Props.create(DeadLetterActor.class));
		system.eventStream().subscribe(actor, DeadLetter.class);

		final ActorRef jazzListener = system.actorOf(Props.create(Listener.class));
		final ActorRef musicListener = system.actorOf(Props.create(Listener.class));
		system.eventStream().setLogLevel(Logging.DebugLevel());

		system.eventStream().subscribe(jazzListener, Jazz.class);
		system.eventStream().subscribe(musicListener, AllKindsOfMusic.class);

		// system.eventStream().publish(new Electronic("Parov Stelar"));

		system.eventStream().publish(new Jazz("Sonny Rollins"));

	}

	public static void main(String[] args) {
		ExampleApp app = new ExampleApp();
		app.test();
	}

}
