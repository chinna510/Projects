package com.akka.io;

import java.net.InetSocketAddress;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.io.Tcp;
import akka.io.TcpMessage;
import akka.remote.Ack;
import akka.util.ByteString;

public class PullHandler extends UntypedActor {
	final LoggingAdapter log = Logging.getLogger(getContext().system(), getSelf());

	final ActorRef connection;
	final InetSocketAddress remote;

	public PullHandler(ActorRef connection, InetSocketAddress remote) {
		this.connection = connection;
		this.remote = remote;
	}

	@Override
	public void preStart() throws Exception {
		connection.tell(TcpMessage.resumeReading(), getSelf());
	}

	@Override
	public void onReceive(Object message) throws Exception {

		if (message instanceof Tcp.Received) {
			ByteString data = ((Tcp.Received) message).data();
			connection.tell(TcpMessage.write(data), getSelf());
		} else if (message instanceof Ack) {
			connection.tell(TcpMessage.resumeReading(), getSelf());
		}

	}

}
