package com.akka.stream.Source;

import java.util.Arrays;
import java.util.List;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class ZipNApp {

	ActorSystem system = ActorSystem.create("ZipWithNApp");
	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void iterate() {

		final Source<Integer, NotUsed> source1 = Source.from(Arrays.asList(0, 1));
		final Source<Integer, NotUsed> source2 = Source.from(Arrays.asList(2, 3));
		final List<Source<Integer, ?>> sources = Arrays.asList(source1, source2);

		final Source<List<Integer>, NotUsed> source = Source.zipN(sources);

		source.runWith(Sink.foreach(i -> log.info("" + i)), mat);

	}

	public static void main(String[] args) {

		ZipNApp app = new ZipNApp();
		app.iterate();
	}

}