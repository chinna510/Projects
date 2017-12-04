package com.akka.stream.Source;

import java.util.Arrays;

import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class FromApp {

	ActorSystem system = ActorSystem.create("Pipelining");
	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void from() {

		Iterable<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		Source.from(input).runWith(Sink.foreach(i -> log.debug("" + i)), mat);

	}

	public static void main(String[] args) {

		FromApp app = new FromApp();
		app.from();
	}

}
