package com.akka.stream;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class UnderstandingConflate2 implements Serializable {

	private static final long serialVersionUID = 1L;
	ActorSystem system = ActorSystem.create("UnderstandingConflate");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	final Random r = new Random();

	private void calculate() throws InterruptedException, ExecutionException, TimeoutException {

		final Double p = 0.01;
		final Flow<Double, Double, NotUsed> sampleFlow = Flow.of(Double.class)
				.conflateWithSeed(elem -> Collections.singletonList(elem), (acc, elem) -> {
					if (r.nextDouble() < p) {
						return Stream.concat(acc.stream(), Collections.singletonList(elem).stream())
								.collect(Collectors.toList());
					}
					return acc;
				}).mapConcat(d -> d);

		final CompletionStage<List<Double>> result = Source.repeat(0).map(i -> r.nextGaussian()).via(sampleFlow)
				.grouped(10).runWith(Sink.head(), mat);
		result.toCompletableFuture().get(1, TimeUnit.SECONDS);

		result.thenAcceptAsync(f -> {

			log.info("" + f);
		});
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		UnderstandingConflate2 con = new UnderstandingConflate2();
		con.calculate();
	}
}
