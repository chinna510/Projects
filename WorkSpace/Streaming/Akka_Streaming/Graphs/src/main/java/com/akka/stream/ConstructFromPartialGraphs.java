package com.akka.stream;

import java.util.Iterator;
import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Pair;
import akka.stream.ActorMaterializer;
import akka.stream.FanInShape2;
import akka.stream.Materializer;
import akka.stream.SourceShape;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.Zip;

public class ConstructFromPartialGraphs {

	ActorSystem system = ActorSystem.create("PartialGraphs");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	private void construct() {

		final Source<Integer, NotUsed> ints = Source.fromIterator(() -> new Ints());

		final Source<Pair<Integer, Integer>, NotUsed> pairs = Source.fromGraph(GraphDSL.create(builder -> {
			final FanInShape2<Integer, Integer, Pair<Integer, Integer>> zip = builder.add(Zip.create());

			builder.from(builder.add(ints.filter(i -> i % 2 == 0))).toInlet(zip.in0());
			builder.from(builder.add(ints.filter(i -> i % 2 == 1))).toInlet(zip.in1());

			return SourceShape.of(zip.out());
		}));

		final CompletionStage<Pair<Integer, Integer>> firstPair = pairs.runWith(Sink.<Pair<Integer, Integer>>head(),
				mat);
		firstPair.thenAcceptAsync(f -> {

			log.info("" + f);
		});

	}

	public static void main(String[] args) {

		ConstructFromPartialGraphs con = new ConstructFromPartialGraphs();
		con.construct();
	}

}

class Ints implements Iterator<Integer> {
	private int next = 0;

	@Override
	public boolean hasNext() {

		return true;
	}

	@Override
	public Integer next() {

		return next++;
	}

}
