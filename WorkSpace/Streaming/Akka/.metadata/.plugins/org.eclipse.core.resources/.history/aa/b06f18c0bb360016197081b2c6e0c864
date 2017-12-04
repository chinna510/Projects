package com.akka.subchannel;

import akka.actor.ActorRef;
import akka.event.japi.SubchannelEventBus;
import akka.util.Subclassification;

public class SubChannelBusImpl extends SubchannelEventBus<MsgEnvelope, ActorRef, String> {

	@Override
	public String classify(MsgEnvelope event) {
		return event.topic;
	}

	@Override
	public void publish(MsgEnvelope event, ActorRef subscribers) {

		subscribers.tell(event.payload, ActorRef.noSender());

	}

	@Override
	public Subclassification<String> subclassification() {
		return new StartsWithSubclassification();
	}

}
