package com.akka.subchannel;

import akka.actor.ActorSystem;
import akka.actor.Props;

public class SubChannelTest {

	ActorSystem system = ActorSystem.create("SubChannel");

	public void test() {

		SubChannelBusImpl subchannelBus = new SubChannelBusImpl();
		subchannelBus.subscribe(system.actorOf(Props.create(TestActor.class)), "a");
		subchannelBus.publish(new MsgEnvelope("ayzabc", "x"));
		subchannelBus.publish(new MsgEnvelope("bcdef", "b"));
		subchannelBus.publish(new MsgEnvelope("abc", "c"));
		subchannelBus.publish(new MsgEnvelope("abcdef", "d"));

	}

	public static void main(String[] args) {
		SubChannelTest test = new SubChannelTest();
		test.test();
	}

}
