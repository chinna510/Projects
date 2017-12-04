package com.akka.future;

import akka.actor.ActorSystem;
import akka.dispatch.OnSuccess;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public final class PrintResult<T> extends OnSuccess<T> {
	ActorSystem system = ActorSystem.create("ActorSystem");

	LoggingAdapter log = Logging.getLogger(system, this);
	@Override
	public final void onSuccess(T t) throws Throwable {

		log.info("" + t);

	}

}
