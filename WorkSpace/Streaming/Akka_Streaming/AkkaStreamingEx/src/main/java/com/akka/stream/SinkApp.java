package com.akka.stream;

import java.math.BigInteger;
import java.nio.file.Paths;
import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.IOResult;
import akka.stream.Materializer;
import akka.stream.javadsl.FileIO;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.ByteString;

public class SinkApp {

	final ActorSystem system = ActorSystem.create("QuickStart");
	Materializer materializer = ActorMaterializer.create(system);

	public void getStream() {

		final Source<Integer, NotUsed> source = Source.range(1, 100);

		source.runForeach(i -> System.out.println(i), materializer);

		final Source<BigInteger, NotUsed> factorials = source.scan(BigInteger.ONE,
				(acc, next) -> acc.multiply(BigInteger.valueOf(next)));

		factorials.map(BigInteger::toString).runWith(linesink("src/main/resources/Sink.txt"), materializer);

	}

	public Sink<String, CompletionStage<IOResult>> linesink(String filename) {

		return Flow.of(String.class).map(s -> ByteString.fromString(s.toString() + "\n"))
				.toMat(FileIO.toPath(Paths.get(filename)), Keep.right());

	}

	public static void main(String[] args) {
		SinkApp app = new SinkApp();
		app.getStream();
	}

}
