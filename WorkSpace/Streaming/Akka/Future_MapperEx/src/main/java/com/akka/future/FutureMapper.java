package com.akka.future;

import java.util.concurrent.Callable;
import static akka.dispatch.Futures.future;
import akka.actor.ActorSystem;
import akka.dispatch.Mapper;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Future;

public class FutureMapper {
	ActorSystem system = ActorSystem.create("ActorSystem");

	@SuppressWarnings("unchecked")
	public void test() {
		final ExecutionContext ec = system.dispatcher();
		Future<String> future = future(new Callable<String>() {
			public String call() {
				return "Hello" + "World"+"BizRuntime";
			}
		}, ec);
		Future<Integer> f2 = future.map(new Mapper<String, Integer>() {
			public Integer apply(String s) {
				return s.length();
			}
		}, ec);
		f2.onSuccess(new PrintResult(), system.dispatcher());
	}

	public static void main(String[] args) {
		FutureMapper fm = new FutureMapper();
		fm.test();
	}

}
