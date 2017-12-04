package com.akka.stream;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import akka.japi.Pair;
import akka.stream.javadsl.Tcp.OutgoingConnection;

public class Combiner {

	  static CompletionStage<MyClass> f(CompletableFuture<Optional<Integer>> p,
		      Pair<CompletionStage<OutgoingConnection>, CompletionStage<String>> rest) {
		
	    return rest.first().thenApply(c -> new MyClass(p, c));		
	}
	
}
