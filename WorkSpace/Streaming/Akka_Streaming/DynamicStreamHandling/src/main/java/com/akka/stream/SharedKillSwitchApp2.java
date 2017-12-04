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
import akka.stream.ActorMaterializer;
import akka.stream.DelayOverflowStrategy;
import akka.stream.KillSwitches;
import akka.stream.Materializer;
import akka.stream.SharedKillSwitch;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import scala.concurrent.duration.FiniteDuration;

public class SharedKillSwitchApp2 implements Serializable {

	private static final long serialVersionUID = 1L;
	ActorSystem system = ActorSystem.create("SharedKillSwitchApp2");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	private void killswitch() throws InterruptedException, ExecutionException, TimeoutException {

		final Source<Integer, NotUsed> countingSrc = Source.from(new ArrayList<>(Arrays.asList(0,1, 2, 3, 4)))
				.delay(FiniteDuration.apply(1, TimeUnit.SECONDS), DelayOverflowStrategy.backpressure());
		final Sink<Integer, CompletionStage<Integer>> lastSnk = Sink.last();
		final SharedKillSwitch killSwitch = KillSwitches.shared("my-kill-switch");

		final CompletionStage<Integer> completionStage1 = countingSrc.viaMat(killSwitch.flow(), Keep.right())
				.toMat(lastSnk, Keep.right()).run(mat);
		final CompletionStage<Integer> completionStage2 = countingSrc.viaMat(killSwitch.flow(), Keep.right())
				.toMat(lastSnk, Keep.right()).run(mat);

		final int result1 = completionStage1.toCompletableFuture().exceptionally(e -> -1).get(2, TimeUnit.SECONDS);
		final int result2 = completionStage2.toCompletableFuture().exceptionally(e -> -1).get(2, TimeUnit.SECONDS);

		final Exception error = new Exception("boom!");
		killSwitch.abort(error);
		
		log.info("" + result1);
		log.info("" + result2);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		SharedKillSwitchApp2 app = new SharedKillSwitchApp2();
		app.killswitch();
	}

}
