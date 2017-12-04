package com.akka.stream;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.actor.Cancellable;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.ClosedShape;
import akka.stream.FanInShape2;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.ZipWith;
import scala.concurrent.duration.FiniteDuration;

public class InternalBuffers implements Serializable {

	private static final long serialVersionUID = 1L;
	ActorSystem system = ActorSystem.create("InternalBuffers");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	public void getBuffer() {

		final FiniteDuration oneSecond = FiniteDuration.create(1, TimeUnit.SECONDS);

		final Source<String, Cancellable> msgSource = Source.tick(oneSecond, oneSecond, "message!");

		final Source<String, Cancellable> tickSource = Source.tick(oneSecond.mul(3), oneSecond.mul(3), "tick");

		final Flow<String, Integer, NotUsed> conflate = Flow.of(String.class).conflateWithSeed(first -> 1,
				(count, elem) -> count + 1);

		RunnableGraph.fromGraph(GraphDSL.create(b -> {

			final FanInShape2<String, Integer, Integer> zipper = b
					.add(ZipWith.create((String tick, Integer count) -> count).async());

			b.from(b.add(msgSource)).via(b.add(conflate)).toInlet(zipper.in1());

			b.from(b.add(tickSource)).toInlet(zipper.in0());

			b.from(zipper.out()).to(b.add(Sink.foreach(elem -> System.out.println(elem))));

			return ClosedShape.getInstance();

		})).run(mat);

	}

	public static void main(String[] args) {

		InternalBuffers buff = new InternalBuffers();
		buff.getBuffer();
	}

}
