package com.akka.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletionStage;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Broadcast;
import akka.stream.javadsl.Merge;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.testkit.JavaTestKit;

public class CombiningSourceAndSinks {

	ActorSystem system = ActorSystem.create("PartialGraphs");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	private void CombineSources() {

		Source<Integer, NotUsed> source1 = Source.single(1);
		Source<Integer, NotUsed> source2 = Source.single(2);

		final Source<Integer, NotUsed> sources = Source.combine(source1, source2, new ArrayList<>(),
				i -> Merge.create(i));

		CompletionStage<Integer> result = sources.runWith(Sink.fold(0, (a, b) -> a + b), mat);

		result.thenAcceptAsync(f -> {
			log.info("Source : " + f.intValue());
		});
	}

	private void combineSinks() {

		final JavaTestKit probe = new JavaTestKit(system);
		ActorRef actorRef = probe.getRef();

		Sink<Integer, NotUsed> sendRemotely = Sink.actorRef(actorRef, "Done");
		Sink<Integer, CompletionStage<Done>> localProcessing = Sink.<Integer>foreach(a -> {
			log.info("Combined Sources : " + a);
		});
		Sink<Integer, NotUsed> sinks = Sink.combine(sendRemotely, localProcessing, new ArrayList<>(),
				a -> Broadcast.create(a));
		Source.from(Arrays.asList(new Integer[] { 0, 1, 2, 3 })).runWith(sinks, mat);
		probe.expectMsgEquals(0);
		probe.expectMsgEquals(1);
		probe.expectMsgEquals(2);
	}

	public static void main(String[] args) {
		CombiningSourceAndSinks com = new CombiningSourceAndSinks();
		com.CombineSources();
		com.combineSinks();
	}

}
