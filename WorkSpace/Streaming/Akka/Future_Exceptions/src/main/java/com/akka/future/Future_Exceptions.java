package com.akka.future;

import static akka.dispatch.Futures.future;

import java.util.concurrent.Callable;

import akka.actor.ActorSystem;
import akka.dispatch.Recover;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

public class Future_Exceptions {
	ActorSystem system = ActorSystem.create("ActorSystem");

	public void test() {
		final ExecutionContext ec = system.dispatcher();
		Future<Integer> f1 = future(new Callable<Integer>() {

			@Override
			public Integer call() {

				return 1 / 0;
			}
		}, ec).recover(new Recover<Integer>() {

			@Override
			public Integer recover(Throwable problem) throws Throwable {
				if (problem instanceof ArithmeticException)
					return 0;
				else
					throw problem;

			}
		}, ec);

		f1.onSuccess(new PrintResult<Integer>(), system.dispatcher());
		f1.onFailure(new PrintResult<Throwable>(), system.dispatcher());

	}

	public static void main(String[] args) {
		Future_Exceptions fm = new Future_Exceptions();
		fm.test();
	}

}
