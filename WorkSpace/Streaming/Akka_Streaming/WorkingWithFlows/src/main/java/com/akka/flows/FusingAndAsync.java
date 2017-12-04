package com.akka.flows;

import java.util.stream.Stream;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.FlowShape;
import akka.stream.Graph;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class FusingAndAsync {

	ActorSystem system = ActorSystem.create("Flows");
	Materializer mat = ActorMaterializer.create(system);

	
	
	LoggingAdapter log = Logging.getLogger(system, this);

	void getFuse() {

		Flow<Integer, Integer, NotUsed> flow = Flow.of(Integer.class).map(x -> x * 2).filter(x -> x < 500);

		Graph<FlowShape<Integer, Integer>, NotUsed> fuseFlow = akka.stream.Fusing.aggressive(flow);

		log.info("Flow " + fuseFlow);

		Source<Integer, NotUsed> source = Source.fromIterator(() -> Stream.iterate(0, x -> x + 1).iterator())
				.via(fuseFlow).take(1000);

		source.runForeach(f -> System.out.println(f), mat);

		RunnableGraph<NotUsed> source1 = Source.range(1, 3).map(x -> x + 1).async().map(x -> x * 2).to(Sink.ignore());

		System.out.println("Runnable Graph : " + source1);
	}

	public static void main(String[] args) {
		FusingAndAsync fs = new FusingAndAsync();
		fs.getFuse();
	}
}
