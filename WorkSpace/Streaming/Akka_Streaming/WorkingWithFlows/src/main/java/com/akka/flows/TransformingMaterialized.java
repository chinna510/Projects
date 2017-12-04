package com.akka.flows;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorSystem;
import akka.actor.Cancellable;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.FanInShape2;
import akka.stream.FlowShape;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.ZipWith;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;

public class TransformingMaterialized {

	ActorSystem system = ActorSystem.create("Flows");
	Materializer mat = ActorMaterializer.create(system);
	final FiniteDuration oneSecond = Duration.create(1, TimeUnit.SECONDS);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void transform() {

		Source<Integer, CompletableFuture<Optional<Integer>>> source = Source.maybe();

		Flow<Integer, Integer, Cancellable> throttler = Flow
				.fromGraph(GraphDSL.create(Source.tick(oneSecond, oneSecond, ""), (b, tickSource) -> {
					FanInShape2<String, Integer, Integer> zip = b.add(ZipWith.create(Keep.right()));
					b.from(tickSource).toInlet(zip.in0());
					return FlowShape.of(zip.in1(), zip.out());
				}));

		Sink<Integer, CompletionStage<Integer>> sink = Sink.head();

		RunnableGraph<CompletableFuture<Optional<Integer>>> r1 = source.via(throttler).to(sink);

		CompletionStage<Optional<Integer>> sum = r1.run(mat);

		sum.thenAcceptAsync(s -> log.debug("SUM : " + s), system.dispatcher());

		

	}

	public static void main(String[] args) {

		TransformingMaterialized tr = new TransformingMaterialized();
		tr.transform();

	}

}
