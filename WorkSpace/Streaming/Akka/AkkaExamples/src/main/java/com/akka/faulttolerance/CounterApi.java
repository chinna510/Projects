package com.akka.faulttolerance;

import akka.actor.ActorRef;

public interface CounterApi {
	public static class UseStorage {
		public final ActorRef storage;

		public UseStorage(ActorRef storage) {
			this.storage = storage;
		}

		public String toString() {
			return String.format("%s(%s)", getClass().getSimpleName(), storage);
		}
	}
}
