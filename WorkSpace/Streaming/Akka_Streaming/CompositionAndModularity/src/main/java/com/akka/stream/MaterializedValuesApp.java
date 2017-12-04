package com.akka.stream;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Pair;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.Tcp;
import akka.stream.javadsl.Tcp.OutgoingConnection;
import akka.util.ByteString;

public class MaterializedValuesApp {

	ActorSystem system = ActorSystem.create("MaterializedValuesApp");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	public void materialisze() {

		// Sources
		final Source<Integer, CompletableFuture<Optional<Integer>>> source = Source.<Integer>maybe();

		final Flow<Integer, Integer, NotUsed> flow1 = Flow.of(Integer.class).take(100);

		final Source<Integer, CompletableFuture<Optional<Integer>>> nestedSource = source.viaMat(flow1, Keep.left())
				.named("nestedSource");

		// flows

		final Flow<Integer, ByteString, NotUsed> flow2 = Flow.of(Integer.class)
				.map(i -> ByteString.fromString(i.toString()));

		final Flow<ByteString, ByteString, CompletionStage<OutgoingConnection>> flow3 = Tcp.get(system)
				.outgoingConnection("localhost", 8081);

		final Flow<Integer, ByteString, CompletionStage<OutgoingConnection>> nestedFlow = flow2
				.viaMat(flow3, Keep.right()).named("nestedFlow");
		// SInks

		final Sink<ByteString, CompletionStage<String>> sink = Sink.<String, ByteString>fold("",
				(acc, i) -> acc + i.utf8String());

		final Sink<Integer, Pair<CompletionStage<OutgoingConnection>, CompletionStage<String>>> nestedSink = nestedFlow
				.toMat(sink, Keep.both());

		final RunnableGraph<CompletionStage<MyClass>> runnableGraph = nestedSource.toMat(nestedSink, Combiner::f);

		CompletionStage<MyClass> result = runnableGraph.run(mat);

		result.thenAcceptAsync(c -> {

			log.info("Recieced Message : " + c);
		});

	}

	public static void main(String[] args) {

		MaterializedValuesApp graph = new MaterializedValuesApp();
		graph.materialisze();
	}
}
