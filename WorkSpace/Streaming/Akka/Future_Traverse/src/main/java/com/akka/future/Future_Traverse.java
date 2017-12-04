package com.akka.future;

import java.util.Arrays;

import java.util.concurrent.Callable;
import static akka.dispatch.Futures.traverse;
import static akka.dispatch.Futures.future;
import akka.actor.ActorSystem;
import akka.dispatch.Mapper;
import akka.japi.Function;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

public class Future_Traverse {
	ActorSystem system = ActorSystem.create("ActorSystem");

	public void test() {
		final ExecutionContext ec = system.dispatcher();
		Iterable<String> listStrings = Arrays.asList("a", "b", "c");

		Future<Iterable<String>> futureResult = traverse(listStrings, new Function<String, Future<String>>() {
			public Future<String> apply(final String r) {
				return future(new Callable<String>() {
					public String call() {
						return r.toUpperCase();
					}
				}, ec);
			}
		}, ec);
		futureResult.onSuccess(new PrintResult<Iterable<String>>(), system.dispatcher());

	}

	public static void main(String[] args) {
		Future_Traverse fm = new Future_Traverse();
		fm.test();
	}

}
