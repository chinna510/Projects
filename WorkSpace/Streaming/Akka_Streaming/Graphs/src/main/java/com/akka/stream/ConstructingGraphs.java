package com.akka.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.ClosedShape;
import akka.stream.Materializer;
import akka.stream.Outlet;
import akka.stream.UniformFanInShape;
import akka.stream.UniformFanOutShape;
import akka.stream.javadsl.Broadcast;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.Merge;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class ConstructingGraphs {

	final ActorSystem system = ActorSystem.create("ConstructingGraphs");

	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void construct() {

		

		Source<Integer, NotUsed> in = Source.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

		final Sink<List<String>, CompletionStage<List<String>>> sink = Sink.head();

		Flow<Integer, Integer, NotUsed> f1 = Flow.of(Integer.class).map(a -> a + 10);
		Flow<Integer, Integer, NotUsed> f2 = Flow.of(Integer.class).map(a -> a + 20);
		Flow<Integer, String, NotUsed> f3 = Flow.of(Integer.class).map(a -> a.toString());
		Flow<Integer, Integer, NotUsed> f4 = Flow.of(Integer.class).map(a -> a + 30);

		RunnableGraph<CompletionStage<List<String>>> result = RunnableGraph
				.fromGraph(GraphDSL.create(sink, (builder, out) -> {

					final UniformFanOutShape<Integer, Integer> bcast = builder.add(Broadcast.create(2));

					final UniformFanInShape<Integer, Integer> merge = builder.add(Merge.create(2));
					final Outlet<Integer> source = builder.add(in).out();

					builder.from(source).via(builder.add(f1)).viaFanOut(bcast).via(builder.add(f2)).viaFanIn(merge)
							.via(builder.add(f3.grouped(1000))).to(out);

					builder.from(bcast).via(builder.add(f4)).toFanIn(merge);

				//	Output : 31, 41, 32, 42, 33, 43, 34, 44, 35, 45, 36, 46, 37, 47, 38, 48, 39,49
					
					
					return ClosedShape.getInstance();

				}));

		CompletionStage<List<String>> sum = result.run(mat);

		sum.thenAcceptAsync(f -> log.info("---->" + f));

	}

	public static void main(String[] args) {

		ConstructingGraphs graph = new ConstructingGraphs();
		graph.construct();
	}
}
