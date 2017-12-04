package com.akka.stream;

import java.math.BigInteger;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.ThrottleMode;
import akka.stream.javadsl.Source;
import scala.concurrent.duration.Duration;

public class TimeBasedProcessing {

	final ActorSystem system = ActorSystem.create("QuickStart");
	Materializer materializer = ActorMaterializer.create(system);

	@SuppressWarnings("unused")
	public void getStream() {

		final Source<Integer, NotUsed> source = Source.range(1, 100);

		source.runForeach(i -> System.out.println(i), materializer);

		final Source<BigInteger, NotUsed> factorials = source.scan(BigInteger.ONE,
				(acc, next) -> acc.multiply(BigInteger.valueOf(next)));
		final CompletionStage<Done> result = factorials
				.zipWith(Source.range(0, 99), (num, idx) -> String.format("%d!=%s", idx, num))
				.throttle(1, Duration.create(1, TimeUnit.SECONDS), 1, ThrottleMode.shaping())
				.runForeach(s -> System.out.println(s), materializer);

	}

	public static void main(String[] args) {
		TimeBasedProcessing stream = new TimeBasedProcessing();
		stream.getStream();
	}
}
