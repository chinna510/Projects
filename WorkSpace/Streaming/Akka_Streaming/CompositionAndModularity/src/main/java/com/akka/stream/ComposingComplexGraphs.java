package com.akka.stream;

import java.util.Arrays;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.ClosedShape;
import akka.stream.FlowShape;
import akka.stream.Graph;
import akka.stream.Materializer;
import akka.stream.SourceShape;
import akka.stream.UniformFanInShape;
import akka.stream.UniformFanOutShape;
import akka.stream.javadsl.Balance;
import akka.stream.javadsl.Broadcast;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.Merge;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class ComposingComplexGraphs {

	ActorSystem system = ActorSystem.create("BiDirectionalFlows");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	public void nesting() {

		Graph<FlowShape<Integer, Integer>, NotUsed> partial = GraphDSL.create(builder -> {
			final UniformFanOutShape<Integer, Integer> B = builder.add(Broadcast.create(2));
			final UniformFanInShape<Integer, Integer> C = builder.add(Merge.create(2));
			final FlowShape<Integer, Integer> D = builder.add(Flow.of(Integer.class).map(i -> {
				System.out.println(i);
				return i + 1;
			}));
			final UniformFanOutShape<Integer, Integer> E = builder.add(Balance.create(2));
			final UniformFanInShape<Integer, Integer> F = builder.add(Merge.create(2));

			builder.from(F.out()).toInlet(C.in(0));
			builder.from(B).viaFanIn(C).toFanIn(F);
			builder.from(B).via(D).viaFanOut(E).toFanIn(F);

			return new FlowShape<>(B.in(), E.out(1));
		});
		final Flow<Integer, Integer, NotUsed> flow = Flow.fromGraph(partial);
		final Source<Integer, NotUsed> source = Source.fromGraph(GraphDSL.create(builder -> {

			final UniformFanInShape<Integer, Integer> merge = builder.add(Merge.create(2));

			builder.from(builder.add(Source.single(0))).toFanIn(merge);

			builder.from(builder.add(Source.from(Arrays.asList(8, 3, 4, 5)))).toFanIn(merge);

			return new SourceShape<>(merge.out());

		}));

		final Sink<Integer, NotUsed> sink = Flow.of(Integer.class).map(i -> i + 2).drop(10).named("NestedFlow")
				.to(Sink.head());

		final RunnableGraph<NotUsed> closed = source.via(flow.filter(i -> i > 1)).to(sink);
		closed.run(mat);

	}

	public void embeddedGraph() {

		RunnableGraph<NotUsed> closedGraph1 = Source.single(0).to(Sink.foreach(System.out::println));

		RunnableGraph<NotUsed> closedGraph2 = RunnableGraph.fromGraph(GraphDSL.create(builder -> {

			final ClosedShape embedded = builder.add(closedGraph1);
			return embedded;

		}));
		closedGraph2.run(mat);
	}

	public static void main(String[] args) {

		ComposingComplexGraphs graph = new ComposingComplexGraphs();
		graph.nesting();
		graph.embeddedGraph();
	}
}
