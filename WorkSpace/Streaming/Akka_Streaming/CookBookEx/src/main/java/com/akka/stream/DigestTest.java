package com.akka.stream;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.ByteString;

public class DigestTest {

	ActorSystem system = ActorSystem.create("Pipelining");
	Materializer materializer = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void test() {

		Source<ByteString, NotUsed> data = Source.from(Arrays.asList(ByteString.fromString("abcdbcdecdef"),
				ByteString.fromString("defgefghfghighijhijkijkljklmklmnlmnomnopnopq")));

		Source<ByteString, NotUsed> mysource = data.via(new DigestCalculator("SHA-256"));

		CompletionStage<ByteString> result = mysource.runWith(Sink.head(), materializer);

		result.thenAcceptAsync(f -> {
			log.info("" + f);
		});
	}

	public static void main(String[] args) {

		DigestTest test = new DigestTest();
		test.test();

	}
}