package com.akka.future;

import static akka.dispatch.Futures.sequence;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import akka.dispatch.Mapper;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

public class ComposingFuture {
	ActorSystem system = ActorSystem.create("ActorSystem");

	@SuppressWarnings({})
	public void test() {
		final ExecutionContext ec = system.dispatcher();
		List<Future<Integer>> source = new ArrayList<Future<Integer>>();
		Iterable<Future<Integer>> listOfFutureInts = source;
		for (int i = 0; i <=5; i++)
			source.add(Futures.successful(i));
		Future<Iterable<Integer>> futureListOfInts = sequence(listOfFutureInts, ec);

		Future<Long> futureSum = futureListOfInts.map(new Mapper<Iterable<Integer>, Long>() {
			public Long apply(Iterable<Integer> ints) {
				long sum = 0;
				for (Integer i : ints)
					sum += i;
				return sum;
			}
		}, ec);

		futureSum.onSuccess(new PrintResult<Long>(), system.dispatcher());
	}

	public static void main(String[] args) {
		ComposingFuture fm = new ComposingFuture();
		fm.test();
	}

}
