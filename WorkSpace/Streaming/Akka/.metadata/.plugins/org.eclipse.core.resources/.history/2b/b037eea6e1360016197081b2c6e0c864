package com.akka.transformation;

import static akka.pattern.Patterns.ask;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.OnSuccess;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.util.Timeout;
import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;

public class TransformationFrontendMain implements TransformMessages {

	public void test(String port) {
		Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + port)
				.withFallback(ConfigFactory.parseString("akka.cluster.roles = [backend]"))
				.withFallback(ConfigFactory.load());

		ActorSystem system = ActorSystem.create("ClusterSystem", config);
		ActorRef ref = system.actorOf(Props.create(TransformationBackend.class));
		LoggingAdapter log = Logging.getLogger(system, this);

		final FiniteDuration interval = Duration.create(2, TimeUnit.SECONDS);
		final Timeout timeout = new Timeout(Duration.create(5, TimeUnit.SECONDS));
		final ExecutionContext ec = system.dispatcher();
		final AtomicInteger counter = new AtomicInteger();
		system.scheduler().schedule(interval, interval, new Runnable() {

			@Override
			public void run() {
				ask(ref, new TransformationJob("hello-" + counter.incrementAndGet()), timeout)
						.onSuccess(new OnSuccess<Object>() {

							@Override
							public void onSuccess(Object result) throws Throwable {
								log.info("Result : " + result);
							}
						}, ec);
			}
		}, ec);
	}

	public static void main(String[] args) {
		TransformationFrontendMain main = new TransformationFrontendMain();
		main.test(args[0]);
	}

}
