package com.akka.future;

import static akka.dispatch.Futures.fold;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import akka.japi.Function2;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

public class Future_Fold {
	ActorSystem system = ActorSystem.create("ActorSystem");

	public void test() {
		final ExecutionContext ec = system.dispatcher();
		List<Future<String>> source = new ArrayList<Future<String>>();

		source.add(Futures.successful("Chinna"));
		source.add(Futures.successful("Rao"));
		source.add(Futures.successful(".P"));

		Iterable<Future<String>> futures = source;

		Future<String> resultFuture = fold("", futures, new Function2<String, String, String>() {
			public String apply(String r, String t) {
				return r + t; // Just concatenate
			}
		}, ec);
		resultFuture.onSuccess(new PrintResult<String>(), system.dispatcher());
	}

	public static void main(String[] args) {
		Future_Fold fm = new Future_Fold();
		fm.test();
	}

}
