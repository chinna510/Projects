package com.akka.udp;

import java.net.InetSocketAddress;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.io.Udp;
import akka.io.UdpConnected;
import akka.io.UdpConnectedMessage;
import akka.io.UdpMessage;
import akka.japi.Procedure;
import akka.util.ByteString;

public class Connected extends UntypedActor {

	final InetSocketAddress remote;

	public static Props props(InetSocketAddress inet) {
		return Props.create(Connected.class, inet);
	}

	public Connected(InetSocketAddress remote) {
		this.remote = remote;

		// create a restricted a.k.a. “connected” socket
		final ActorRef mgr = UdpConnected.get(getContext().system()).getManager();
		mgr.tell(UdpConnectedMessage.connect(getSelf(), remote), getSelf());
	}

	@Override
	public void onReceive(Object msg) {
		if (msg instanceof UdpConnected.Connected) {
			getContext().become(ready(getSender()));
		} else
			unhandled(msg);
	}

	private Procedure<Object> ready(final ActorRef connection) {
		return new Procedure<Object>() {
			@Override
			public void apply(Object msg) throws Exception {
				if (msg instanceof UdpConnected.Received) {
					final UdpConnected.Received r = (UdpConnected.Received) msg;
					// #connected
					if (r.data().utf8String().equals("hello")) {
						connection.tell(UdpConnectedMessage.send(ByteString.fromString("world")), getSelf());
					}
					// #connected

				} else if (msg instanceof String) {
					System.out.println(msg);
					final String str = (String) msg;

					connection.tell(UdpConnectedMessage.send(ByteString.fromString(str)), getSelf());

				} else if (msg.equals(UdpConnectedMessage.disconnect())) {
					connection.tell(msg, getSelf());

				} else if (msg instanceof UdpConnected.Disconnected) {
					getContext().stop(getSelf());

				} else
					unhandled(msg);
			}
		};
	}
}
