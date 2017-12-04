package com.akka.future;

import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

public class Future_FallBackTo {
	ActorSystem system = ActorSystem.create("ActorSystem");

	public void test() {
		final ExecutionContext ec = system.dispatcher();
		Future<String> f1 = Futures.failed(new IllegalStateException("OHONEX1"));
		Future<String> f2 = Futures.failed(new IllegalStateException("OHONEX1"));
		Future<String> f3 = Futures.successful("Bar");
		Future<String> f4 = f1.fallbackTo(f2).fallbackTo(f3);
		f4.onSuccess(new PrintResult<String>(), system.dispatcher());

	}

	public static void main(String[] args) {
		Future_FallBackTo fm = new Future_FallBackTo();
		fm.test();
	}

}
