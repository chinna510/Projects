package com.akka.udp;

import java.net.InetSocketAddress;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.io.Udp;
import akka.io.UdpMessage;
import akka.japi.Procedure;
import akka.util.ByteString;

public class SimpleSender extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	final InetSocketAddress remote;

	public SimpleSender(InetSocketAddress remote) {
		this.remote = remote;

		// request creation of a SimpleSender
		final ActorRef mgr = Udp.get(getContext().system()).getManager();
		mgr.tell(UdpMessage.simpleSender(), getSelf());

	}

	public static Props props(InetSocketAddress inet) {
		return Props.create(SimpleSender.class, inet);
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof Udp.SimpleSenderReady) {
			log.info("" + msg);

			getContext().become(ready(getSender()));
		} else
			unhandled(msg);
	}

	private Procedure<Object> ready(final ActorRef send) {
		return new Procedure<Object>() {
			@Override
			public void apply(Object msg) throws Exception {
				if (msg instanceof String) {
					log.info("" + msg);
					final String str = (String) msg;
					send.tell(UdpMessage.send(ByteString.fromString(str), remote), getSelf());

				} else
					unhandled(msg);
			}
		};
	}

}
