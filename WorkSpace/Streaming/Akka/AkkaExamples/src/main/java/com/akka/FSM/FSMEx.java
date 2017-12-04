package com.akka.FSM;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class FSMEx {

	public void test() {
		ActorSystem system = ActorSystem.create("FSM");
		ActorRef ref = system.actorOf(Props.create(MyFSM.class));
		ref.tell("HI..", ref.noSender());
	}

	public static void main(String[] args) {
		FSMEx ex = new FSMEx();
		ex.test();
	}

}
