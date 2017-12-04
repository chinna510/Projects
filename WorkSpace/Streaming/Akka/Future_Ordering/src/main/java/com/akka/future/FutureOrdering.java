package com.akka.future;

import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import akka.dispatch.OnComplete;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

public class FutureOrdering {
	ActorSystem system = ActorSystem.create("ActorSystem");

	@SuppressWarnings({ "unchecked" })
	public void test() {
		final ExecutionContext ec = system.dispatcher();

		Future fs = Futures.successful("value").andThen(new OnComplete() {

			@Override
			public void onComplete(Throwable fail, Object arg1) throws Throwable {
				if (fail != null)
					sendIssueTracker(fail);
			}

		}, ec).andThen(new OnComplete<String>() {

			@Override
			public void onComplete(Throwable fail, String result) throws Throwable {
				if (result != null)
					sendToTheInternetz(result);
			}

		}, ec);
	}

	private void sendIssueTracker(Throwable fail) {
		System.out.println(fail);
	}

	private void sendToTheInternetz(String result) {
		System.out.println(result);
	}

	public static void main(String[] args) {
		FutureOrdering fm = new FutureOrdering();
		fm.test();
	}

}
