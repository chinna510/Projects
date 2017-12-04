package com.akka.udp;

import java.net.InetSocketAddress;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.io.Udp;
import akka.io.UdpMessage;
import akka.japi.Procedure;
import akka.util.ByteString;

public class Listener extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	final ActorRef nextActor;

	public Listener(ActorRef nextActor) {
		this.nextActor = nextActor;

		// request creation of a bound listen socket
		final ActorRef mgr = Udp.get(getContext().system()).getManager();
		mgr.tell(UdpMessage.bind(getSelf(), new InetSocketAddress("localhost", 8082)), getSelf());
	}

	@Override
	public void onReceive(Object msg) {
		if (msg instanceof Udp.Bound) {
			log.debug("LIstner bounded " + msg);
			final Udp.Bound b = (Udp.Bound) msg;
			getContext().become(ready(getSender()));
		} else
			unhandled(msg);
	}

	private Procedure<Object> ready(final ActorRef socket) {
		return new Procedure<Object>() {
			@Override
			public void apply(Object msg) throws Exception {
				System.out.println("Listener- >" + msg);
				if (msg instanceof Udp.Received) {
					final Udp.Received r = (Udp.Received) msg;
					// echo server example: send back the data
					socket.tell(UdpMessage.send(r.data(), r.sender()), getSelf());
					// or do some processing and forward it on
					final ByteString processed = r.data();

					log.debug(processed.decodeString("UTF-8"));

					nextActor.tell(processed, getSelf());

				} else if (msg.equals(UdpMessage.unbind())) {
					socket.tell(msg, getSelf());

				} else if (msg instanceof Udp.Unbound) {
					getContext().stop(getSelf());

				} else
					unhandled(msg);
			}
		};
	}

}
