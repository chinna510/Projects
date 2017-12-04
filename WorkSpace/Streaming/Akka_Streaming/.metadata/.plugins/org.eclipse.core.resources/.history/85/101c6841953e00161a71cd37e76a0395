package com.akka.stream.Source;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;

import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class FromCompletionStageApp {

	ActorSystem system = ActorSystem.create("Pipelining");
	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void fromCompletionStage() {

		Iterable<Integer> input = Arrays.asList(1, 1, 3, 4, 5);

		CompletionStage<Integer> stage = Source.from(input).runWith(Sink.head(), mat);

		Source.fromCompletionStage(stage).runWith(Sink.foreach(i -> log.debug("" + i)), mat);
	}

	public static void main(String[] args) {

		FromCompletionStageApp app = new FromCompletionStageApp();
		app.fromCompletionStage();
	}

}
