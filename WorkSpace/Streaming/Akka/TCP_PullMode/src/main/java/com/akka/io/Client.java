package com.akka.io;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.io.Inet;
import akka.io.Tcp;
import akka.io.Tcp.Bound;
import akka.io.Tcp.CommandFailed;
import akka.io.Tcp.Connected;
import akka.io.Tcp.ConnectionClosed;
import akka.io.Tcp.Received;
import akka.io.TcpMessage;
import akka.japi.Procedure;
import akka.util.ByteString;

public class Client extends UntypedActor {

	final InetSocketAddress remote;
	final ActorRef listener;
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	final List<Inet.SocketOption> options = new ArrayList<Inet.SocketOption>();

	public static Props props(InetSocketAddress remote, ActorRef listener) {
		return Props.create(Client.class, remote, listener);
	}

	public Client(InetSocketAddress remote, ActorRef listener) {
		this.remote = remote;
		this.listener = listener;

		final ActorRef tcp = Tcp.get(getContext().system()).manager();
		tcp.tell(TcpMessage.connect(new InetSocketAddress("localhost", 8081), null, options, null, true), getSelf());
	}

	@Override
	public void onReceive(Object message) throws Exception {

		if (message instanceof CommandFailed) {

			listener.tell("Failed", getSelf());
			getContext().stop(getSelf());
		} else if (message instanceof Connected) {

			log.info("Connection Created Successfully" + message);
			listener.tell(message, getSelf());
			getSender().tell(TcpMessage.register(getSelf()), getSelf());
			getContext().become(connected(getSender()));

		}
	}

	private Procedure<Object> connected(final ActorRef connection) {

		return new Procedure<Object>() {
			@Override
			public void apply(Object msg) throws Exception {

				if (msg instanceof ByteString) {
					connection.tell(TcpMessage.write((ByteString) msg), getSelf());

				} else if (msg instanceof CommandFailed) {
					// OS kernel socket buffer was full

				} else if (msg instanceof Received) {
					listener.tell(((Received) msg).data(), getSelf());

				} else if (msg.equals("close")) {
					connection.tell(TcpMessage.close(), getSelf());

				} else if (msg instanceof ConnectionClosed) {
					getContext().stop(getSelf());
				}
			}
		};

	}

}
