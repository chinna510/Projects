package com.akka.stream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Pair;
import akka.stream.ActorMaterializer;
import akka.stream.DelayOverflowStrategy;
import akka.stream.KillSwitches;
import akka.stream.Materializer;
import akka.stream.UniqueKillSwitch;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import scala.concurrent.duration.FiniteDuration;

public class UniqueKillSwitchApp2 implements Serializable {

	private static final long serialVersionUID = 1L;
	ActorSystem system = ActorSystem.create("UnderstandingConflate");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	private void killswitch() throws InterruptedException, ExecutionException, TimeoutException {

		final Source<Integer, NotUsed> countingSrc = Source.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4)))
				.delay(FiniteDuration.apply(1, TimeUnit.SECONDS), DelayOverflowStrategy.backpressure());

		final Sink<Integer, CompletionStage<Integer>> lastSnk = Sink.last();

		final Pair<UniqueKillSwitch, CompletionStage<Integer>> stream = countingSrc
				.viaMat(KillSwitches.single(), Keep.right()).toMat(lastSnk, Keep.both()).run(mat);

		final UniqueKillSwitch killSwitch = stream.first();

		final CompletionStage<Integer> completionStage = stream.second();

		doSomethingElse();
		killSwitch.shutdown();

		final Exception error = new Exception("boom!");
		killSwitch.abort(error);
		final int result = completionStage.toCompletableFuture().exceptionally(e -> -1).get(1, TimeUnit.SECONDS);

		log.info("" + result);

	}

	private void doSomethingElse() {

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		UniqueKillSwitchApp2 app = new UniqueKillSwitchApp2();
		app.killswitch();
	}

}
