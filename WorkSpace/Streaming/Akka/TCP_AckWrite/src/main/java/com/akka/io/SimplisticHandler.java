package com.akka.io;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.io.Tcp.ConnectionClosed;
import akka.io.Tcp.Received;
import akka.io.TcpMessage;
import akka.util.ByteString;

public class SimplisticHandler extends UntypedActor {

	LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void onReceive(Object msg) throws Exception {

		if (msg instanceof Received) {
			final ByteString data = ((Received) msg).data();
			log.info("" + data);
			getSender().tell(TcpMessage.write(data), getSelf());
		} else if (msg instanceof ConnectionClosed) {

			getContext().stop(getSelf());
		}

	}

}
