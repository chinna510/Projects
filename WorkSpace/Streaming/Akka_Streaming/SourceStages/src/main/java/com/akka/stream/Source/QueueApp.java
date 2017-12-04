package com.akka.stream.Source;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Pair;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.OverflowStrategy;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.SourceQueueWithComplete;

public class QueueApp {

	ActorSystem system = ActorSystem.create("Pipelining");
	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void cycle() {
		final Pair<SourceQueueWithComplete<String>, CompletionStage<List<String>>> x = Flow.of(String.class).runWith(
				// buffer size and strategy
				Source.queue(5, OverflowStrategy.dropHead()), Sink.seq(), mat);

		final SourceQueueWithComplete<String> source = x.first();
		final CompletionStage<List<String>> result = x.second();
		// send messsage with source.offer
		source.offer("hello");
		source.offer("world");
		source.complete();

		List<String> list;

		try {
			list = result.toCompletableFuture().get(3, TimeUnit.SECONDS);
			log.debug("" + list);

		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		QueueApp app = new QueueApp();
		app.cycle();
	}

}