package com.akka.stream;

import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.FlowShape;
import akka.stream.Materializer;
import akka.stream.SourceShape;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class AccessingMaterializedValues {

	ActorSystem system = ActorSystem.create("BiDirectionalFlows");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	public void access() {

		Sink<Integer, CompletionStage<Integer>> foldSink = Sink.fold(0, (a, b) -> {

			return a + b;
		});
		final Flow<CompletionStage<Integer>, Integer, NotUsed> flatten = Flow.<CompletionStage<Integer>>create()
				.mapAsync(4, x -> x);

		final Flow<Integer, Integer, CompletionStage<Integer>> foldingFlow = Flow
				.fromGraph(GraphDSL.create(foldSink, (b, fold) -> {
					return FlowShape.of(fold.in(), b.from(b.materializedValue()).via(b.add(flatten)).out());
				}));

		final Source<Integer, CompletionStage<Integer>> cyclicSource = Source
				.fromGraph(GraphDSL.create(foldSink, (b, fold) -> {

					b.from(b.materializedValue()).via(b.add(flatten)).to(fold);
					return SourceShape.of(b.from(b.materializedValue()).via(b.add(flatten)).out());
				}));

		System.out.println(foldingFlow.runWith(cyclicSource, foldSink, mat));

		cyclicSource.runForeach(f -> {
			System.out.println(f.intValue());
		}, mat);
	}

	public static void main(String[] args) {

		AccessingMaterializedValues values = new AccessingMaterializedValues();
		values.access();
	}
}
