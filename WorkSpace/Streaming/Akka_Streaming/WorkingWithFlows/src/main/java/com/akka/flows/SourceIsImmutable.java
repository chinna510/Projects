package com.akka.flows;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class SourceIsImmutable {

	ActorSystem system = ActorSystem.create("Flows");
	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void getFlow() throws InterruptedException, ExecutionException, TimeoutException {

		Source<Integer, NotUsed> source = Source.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		source.map(f -> 0);

		Sink<Integer, CompletionStage<Integer>> sink = Sink.<Integer, Integer>fold(0, (next, aggr) -> next + aggr);

		CompletionStage<Integer> sum = source.runWith(sink, mat); // 55

		Source<Integer, NotUsed> zeros = source.map(x -> 0);
		Sink<Integer, CompletionStage<Integer>> zeroSink = Sink.<Integer, Integer>fold(0, (next, aggr) -> next + aggr);

		CompletionStage<Integer> sum1 = zeros.runWith(zeroSink, mat); // 0

		int result = zeros.runWith(zeroSink, mat).toCompletableFuture().get(3, TimeUnit.SECONDS);

		sum.thenAcceptAsync(s -> {
			log.info("SUM :" + s);
		});

		sum1.thenAcceptAsync(s -> {
			log.info("SUM :" + s);
		});

		log.info("New SUM : " + result);

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		SourceIsImmutable imm = new SourceIsImmutable();
		imm.getFlow();
	}

}
