package com.akka.stream;

import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.ClosedShape;
import akka.stream.FanInShape2;
import akka.stream.Graph;
import akka.stream.Inlet;
import akka.stream.Materializer;
import akka.stream.UniformFanInShape;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.ZipWith;

public class ConstructAndCombineGraphs {

	final ActorSystem system = ActorSystem.create("ConstructingGraphs");

	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	@SuppressWarnings("unchecked")
	public void construct() {

		Graph<FanInShape2<Integer, Integer, Integer>, NotUsed> zip = ZipWith
				.create((Integer left, Integer right) -> Math.max(left, right));

		Graph<UniformFanInShape<Integer, Integer>, NotUsed> maxOfThree = GraphDSL.create(

				builder -> {
					final FanInShape2<Integer, Integer, Integer> zip1 = builder.add(zip);
					final FanInShape2<Integer, Integer, Integer> zip2 = builder.add(zip);

					builder.from(zip1.out()).toInlet(zip2.in0());

					return new UniformFanInShape<Integer, Integer>(zip2.out(),
							new Inlet[] { zip1.in0(), zip1.in1(), zip2.in1() });

				}

		);

		final Sink<Integer, CompletionStage<Integer>> resultSink = Sink.<Integer>head();

		final RunnableGraph<CompletionStage<Integer>> g = RunnableGraph
				.<CompletionStage<Integer>>fromGraph(GraphDSL.create(resultSink, (builder, sink) -> {

					final UniformFanInShape<Integer, Integer> pm = builder.add(maxOfThree);

					builder.from(builder.add(Source.single(1))).toInlet(pm.in(0));
					builder.from(builder.add(Source.single(2))).toInlet(pm.in(1));
					builder.from(builder.add(Source.single(3))).toInlet(pm.in(2));
					builder.from(pm.out()).to(sink);
					return ClosedShape.getInstance();
				}));

		CompletionStage<Integer> result = g.run(mat);

		result.thenAcceptAsync(f -> {
			log.info("--> " + f);
		});
	}

	public static void main(String[] args) {
		ConstructAndCombineGraphs graph = new ConstructAndCombineGraphs();
		graph.construct();
	}
}
