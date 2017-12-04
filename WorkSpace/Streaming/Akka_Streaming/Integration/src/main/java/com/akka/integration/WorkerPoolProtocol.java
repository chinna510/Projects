package com.akka.integration;

import com.akka.publisher.Done;
import com.akka.publisher.Msg;
import com.akka.publisher.Reply;

import akka.actor.ActorRef;

public class WorkerPoolProtocol {

	public static Msg msg(int id, ActorRef replyTo) {
		return new Msg(id, replyTo);
	}

	public static Work work(int id) {
		return new Work(id);
	}

	public static Reply reply(int id) {
		return new Reply(id);
	}

	public static Done done(int id) {
		return new Done(id);
	}

}
