package com.akka.stream;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
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

public class UnderstandingExpand implements Serializable {

	private static final long serialVersionUID = 1L;
	ActorSystem system = ActorSystem.create("UnderstandingConflate");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	final Random r = new Random();

	private void calculate() throws InterruptedException, ExecutionException, TimeoutException {

		final Flow<Double, Double, NotUsed> lastFlow = Flow.of(Double.class)
				.expand(in -> Stream.iterate(in, i -> i).iterator());

		final CompletionStage<List<Double>> result = Source.repeat(0).map(i -> r.nextGaussian()).via(lastFlow)
				.grouped(10).runWith(Sink.head(), mat);

		result.toCompletableFuture().get(1, TimeUnit.SECONDS);

		result.thenAcceptAsync(f -> {

			log.info("" + f);
		});
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		UnderstandingExpand con = new UnderstandingExpand();
		con.calculate();
	}
}
