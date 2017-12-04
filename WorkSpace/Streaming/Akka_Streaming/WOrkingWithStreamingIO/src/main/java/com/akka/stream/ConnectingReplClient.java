package com.akka.stream;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentLinkedQueue;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Framing;
import akka.stream.javadsl.FramingTruncation;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.Tcp;
import akka.stream.javadsl.Tcp.OutgoingConnection;
import akka.util.ByteString;

public class ConnectingReplClient {

	ActorSystem system = ActorSystem.create("ConnectingReplClient");

	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void accept() {
		final Flow<ByteString, ByteString, CompletionStage<OutgoingConnection>> connection = Tcp.get(system)
				.outgoingConnection("127.0.0.1", 8889);
		final Flow<String, ByteString, NotUsed> replParser = Flow.<String>create().takeWhile(elem -> !elem.equals("q"))
				.concat(Source.single("BYE")) // will run after the original
												// flow completes
				.map(elem -> ByteString.fromString(elem + "\n"));

		final Flow<ByteString, ByteString, NotUsed> repl = Flow.of(ByteString.class)
				.via(Framing.delimiter(ByteString.fromString("\n"), 256, FramingTruncation.ALLOW))
				.map(ByteString::utf8String).map(text -> {
					System.out.println("Server: " + text);
					return "next";
				}).map(elem -> readLine("> ")).via(replParser);

		CompletionStage<OutgoingConnection> result = connection.join(repl).run(mat);
		result.thenAcceptAsync(f -> {

			log.info("" + f);

		});

	}

	private final ConcurrentLinkedQueue<String> input = new ConcurrentLinkedQueue<String>();
	{
		input.add("Hello world");
		input.add("What a lovely day");
		input.add("Hello world");
		input.add("What a lovely day");

	}

	private String readLine(String prompt) {
		String s = input.poll();
		return (s == null ? "q" : s);
	}

	public static void main(String[] args) {
		ConnectingReplClient con = new ConnectingReplClient();
		con.accept();

	}

}