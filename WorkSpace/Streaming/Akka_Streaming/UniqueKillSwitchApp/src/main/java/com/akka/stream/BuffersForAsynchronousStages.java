package com.akka.stream;

import java.io.Serializable;
import java.util.Arrays;

import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class BuffersForAsynchronousStages implements Serializable {

	private static final long serialVersionUID = 1L;
	ActorSystem system = ActorSystem.create("MaterializedValuesApp");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	public void async() {

		Source.from(Arrays.asList(1, 2, 3, 4)).map(a -> {

			System.out.println("A :" + a);
			return a;
		}).async().map(b -> {

			System.out.println("B :" + b);
			return b;
		}).async().map(c -> {

			System.out.println("C :" + c);
			return c;
		}).async().runWith(Sink.ignore(), mat);

	}

	public static void main(String[] args) {

		BuffersForAsynchronousStages buff = new BuffersForAsynchronousStages();
		buff.async();
	}

}
