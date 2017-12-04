package com.akka.MailBox;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Test {
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("ActorSystem");
		ActorRef ref = system.actorOf(Props.create(MailBoxDemo.class).withMailbox("prio-mailbox"));
	}

}
