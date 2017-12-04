package com.akka.stream;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Attributes;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class AttributesApp {

	ActorSystem system = ActorSystem.create("MaterializedValuesApp");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	public void materialisze() {

		final Source<Integer, NotUsed> nestedSource = Source.single(0).map(i -> i + 1).named("nestedSource");

		final Flow<Integer, Integer, NotUsed> nestedFlow = Flow.of(Integer.class).filter(i -> i != 0)
				.via(Flow.of(Integer.class).map(i -> i - 2).withAttributes(Attributes.inputBuffer(4, 4)))
				.named("nestedFlow");

		final Sink<Integer, NotUsed> nestedSink = nestedFlow.to(Sink.fold(0, (acc, i) -> acc + i))
				.withAttributes(Attributes.name("nestedSink").and(Attributes.inputBuffer(3, 3)));

		RunnableGraph<NotUsed> graph = nestedSource.via(nestedFlow).to(nestedSink);
		graph.run(mat);
		
		
	}

	public static void main(String[] args) {

		AttributesApp graph = new AttributesApp();
		graph.materialisze();
	}
}
