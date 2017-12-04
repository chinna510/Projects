package com.akka.stream;

import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Pair;
import akka.stream.ActorMaterializer;
import akka.stream.ClosedShape;
import akka.stream.Materializer;
import akka.stream.UniformFanOutShape;
import akka.stream.javadsl.Broadcast;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class ParellelStreams {

	final ActorSystem system = ActorSystem.create("ConstructingGraphs");

	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void construct() {

	//	Source<Integer, NotUsed> in = Source.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

		final Sink<Integer, CompletionStage<Integer>> topSink = Sink.head();

		final Sink<Integer, CompletionStage<Integer>> bottomSink = Sink.head();

		Flow<Integer, Integer, NotUsed> sharedDoubler = Flow.of(Integer.class).map(a -> a * 2);

		final RunnableGraph<Pair<CompletionStage<Integer>, CompletionStage<Integer>>> result = RunnableGraph
				.<Pair<CompletionStage<Integer>, CompletionStage<Integer>>>fromGraph(
						GraphDSL.create(topSink, bottomSink, Keep.both(), (b, top, bottom) -> {
							final UniformFanOutShape<Integer, Integer> bcast = b.add(Broadcast.create(2));

							b.from(b.add(Source.single(1))).viaFanOut(bcast).via(b.add(sharedDoubler)).to(top);
							b.from(bcast).via(b.add(sharedDoubler)).to(bottom);
							return ClosedShape.getInstance();
						}));

		 result.run(mat);

	
	}

	public static void main(String[] args) {

		ParellelStreams graph = new ParellelStreams();
		graph.construct();
	}
}
