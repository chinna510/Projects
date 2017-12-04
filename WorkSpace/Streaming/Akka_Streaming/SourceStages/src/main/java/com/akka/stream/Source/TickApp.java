package com.akka.stream.Source;

import java.util.Arrays;
import java.util.List;

import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import scala.concurrent.duration.FiniteDuration;

public class TickApp {

	ActorSystem system = ActorSystem.create("Pipelining");
	Materializer mat = ActorMaterializer.create(system);

	LoggingAdapter log = Logging.getLogger(system, this);

	public void tick() {

		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		Source.tick(FiniteDuration.create(2, "seconds"), FiniteDuration.create(1, "seconds"), input)
				.runWith(Sink.foreach(i -> log.debug("" + i)), mat);
	}

	public static void main(String[] args) {

		TickApp app = new TickApp();
		app.tick();
	}

}
