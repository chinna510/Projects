package com.akka.flows;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class RunningFlow {

	ActorSystem system = ActorSystem.create("Flows");
	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void getFlow() {

		Source<Integer, NotUsed> source = Source.from(Arrays.asList(1, 2, 5, 2, 6, 8, 10));

		Sink<Integer, CompletionStage<Integer>> sink = Sink.<Integer, Integer>fold(0, (aggr, next) -> aggr + next);

		RunnableGraph<CompletionStage<Integer>> runnable = source.toMat(sink, Keep.right());

		CompletionStage<Integer> stage = runnable.run(mat);
		CompletionStage<Integer> stage1 = runnable.run(mat);

		source.runForeach(i -> System.out.println(i), mat);

		stage.thenAcceptAsync(c -> log.debug("-> " + c), system.dispatcher());
		stage1.thenAcceptAsync(c -> log.debug("-> " + c), system.dispatcher());


	}

	public static void main(String[] args) {

		RunningFlow flow = new RunningFlow();
		flow.getFlow();
	}

}
