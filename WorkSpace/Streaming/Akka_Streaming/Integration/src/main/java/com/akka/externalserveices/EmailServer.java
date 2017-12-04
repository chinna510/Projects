package com.akka.externalserveices;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import akka.actor.ActorRef;

public class EmailServer {

	public final ActorRef probe;

	public EmailServer(ActorRef probe) {
		this.probe = probe;
	}

	public CompletionStage<Email> send(Email email) {

		probe.tell(email.to, ActorRef.noSender());
		return CompletableFuture.completedFuture(email);
	}
}
