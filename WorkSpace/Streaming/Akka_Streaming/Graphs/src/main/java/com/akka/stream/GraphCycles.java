package com.akka.stream;

import java.util.Arrays;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.ClosedShape;
import akka.stream.FlowShape;
import akka.stream.Materializer;
import akka.stream.Outlet;
import akka.stream.SinkShape;
import akka.stream.UniformFanInShape;
import akka.stream.UniformFanOutShape;
import akka.stream.javadsl.Broadcast;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.Merge;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class GraphCycles {

	ActorSystem system = ActorSystem.create("BiDirectionalFlows");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	private void cycle() {

		final Source<Integer, NotUsed> in = Source.from(Arrays.asList(1, 2, 3, 4, 5));

		final Flow<Integer, Integer, NotUsed> printFlow = Flow.of(Integer.class).map(s -> {
			System.out.println(s);
			return s;
		});

		RunnableGraph<NotUsed> result = RunnableGraph.fromGraph(GraphDSL.create(b -> {
			final UniformFanInShape<Integer, Integer> merge = b.add(Merge.create(2));
			final UniformFanOutShape<Integer, Integer> bcast = b.add(Broadcast.create(2));

			final Outlet<Integer> src = b.add(in).out();
			final FlowShape<Integer, Integer> printer = b.add(printFlow);
			final SinkShape<Integer> ignore = b.add(Sink.ignore());

			b.from(src).viaFanIn(merge).via(printer).viaFanOut(bcast).to(ignore);
			b.to(merge).fromFanOut(bcast);
			return ClosedShape.getInstance();

		}));

		result.run(mat);
	}

	public static void main(String[] args) {
		GraphCycles gc = new GraphCycles();
		gc.cycle();
	}

}
