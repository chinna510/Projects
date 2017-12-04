package com.akka.ScanningBus;

public class MsgEnvelope {

	final String topic;
	final Object payload;

	public MsgEnvelope(final String topic, final Object payload) {

		this.topic = topic;
		this.payload = payload;

	}

}
