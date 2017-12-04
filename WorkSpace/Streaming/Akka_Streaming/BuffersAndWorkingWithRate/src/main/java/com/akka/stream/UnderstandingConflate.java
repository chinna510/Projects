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
import java.util.stream.DoubleStream;
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
import scala.Tuple3;

public class UnderstandingConflate implements Serializable {

	private static final long serialVersionUID = 1L;
	ActorSystem system = ActorSystem.create("UnderstandingConflate");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	final Random r = new Random();

	private void calculate() throws InterruptedException, ExecutionException, TimeoutException {

		final Flow<Double, Tuple3<Double, Double, Integer>, NotUsed> statsFlow = Flow.of(Double.class)
				.conflateWithSeed(elem -> Collections.singletonList(elem), (acc, elem) -> {
					return Stream.concat(acc.stream(), Collections.singletonList(elem).stream())
							.collect(Collectors.toList());
				}).map(s -> {
					final Double mean = s.stream().mapToDouble(d -> d).sum() / s.size();
					final DoubleStream se = s.stream().mapToDouble(x -> Math.pow(x - mean, 2));
					final Double stdDev = Math.sqrt(se.sum() / s.size());
					return new Tuple3<>(stdDev, mean, s.size());
				});

		final CompletionStage<List<Tuple3<Double, Double, Integer>>> result = Source.repeat(0)
				.map(i -> r.nextGaussian()).via(statsFlow).grouped(10).runWith(Sink.head(), mat);
		result.toCompletableFuture().get(1, TimeUnit.SECONDS);
		result.thenAcceptAsync(f -> {

			log.info("" + f);
		});
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		UnderstandingConflate con = new UnderstandingConflate();
		con.calculate();
	}
}
