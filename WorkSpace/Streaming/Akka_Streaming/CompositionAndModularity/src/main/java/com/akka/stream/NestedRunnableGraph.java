package com.akka.stream;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class NestedRunnableGraph {

	ActorSystem system = ActorSystem.create("BiDirectionalFlows");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	public void nesting() {

		Source<Integer, NotUsed> source = Source.single(0).map(f -> f + 1).named("NestedSource");

		Flow<Integer, Integer, NotUsed> nestedFlow = Flow.of(Integer.class).filter(f -> f != 1).map(f -> f - 1)
				.map(f -> {

					System.out.println(f);
					return f;
				}).named("NestedFlow");

		Sink<Integer, NotUsed> nestedSink = nestedFlow.to(Sink.fold(0, (acc, i) -> acc + i));

		RunnableGraph<NotUsed> result = source.to(nestedSink);

		result.run(mat);

	}

	public static void main(String[] args) {

		NestedRunnableGraph graph = new NestedRunnableGraph();
		graph.nesting();
	}
}
