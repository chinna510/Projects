package com.akka.externalserveices;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class SometimesSlowService {

	private final Executor ec;

	public SometimesSlowService(Executor ec) {
		this.ec = ec;
	}

	private final AtomicInteger runningCount = new AtomicInteger();

	public CompletionStage<String> convert(String s) {
		System.out.println("running: " + s + "(" + runningCount.incrementAndGet() + ")");
		return CompletableFuture.supplyAsync(() -> {
			if (!s.isEmpty() && Character.isLowerCase(s.charAt(0)))
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			else
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
				}
			System.out.println("completed: " + s + "(" + runningCount.decrementAndGet() + ")");
			return s.toUpperCase();
		}, ec);
	}

}
