package com.akka.stream;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Framing;
import akka.stream.javadsl.FramingTruncation;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.ByteString;

public class RecipeParseLines {

	ActorSystem system = ActorSystem.create("Pipelining");
	Materializer materializer = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	private void parse() {

		Source<ByteString, NotUsed> rawData = Source.from(Arrays.asList(ByteString.fromString("Hello World"),
				ByteString.fromString("\r"), ByteString.fromString("!\r"),
				ByteString.fromString("\nHello Akka!\r\nHello Streams!"), ByteString.fromString("\r\n\r\n")));

		Source<String, NotUsed> source = rawData.via(Framing
				.delimiter(ByteString.fromString("\r\n"), 100, FramingTruncation.ALLOW).map(b -> b.utf8String()));

		CompletionStage<String> result = source.runWith(Sink.head(), materializer);

		result.thenAcceptAsync(f -> {
			log.info("" + f);
		});

	}

	public static void main(String[] args) {

		RecipeParseLines line = new RecipeParseLines();
		line.parse();
	}

}