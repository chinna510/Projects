package com.akka.reactiveStreams;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import akka.actor.ActorRef;

public class MinimalProbeSubscriber<T> implements Subscriber<T> {

	private final ActorRef ref;

	public MinimalProbeSubscriber(ActorRef ref) {
		this.ref = ref;
	}

	@Override
	public void onSubscribe(Subscription s) {
		s.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(T t) {
		ref.tell(t, ActorRef.noSender());
	}

	@Override
	public void onError(Throwable t) {
		ref.tell(t, ActorRef.noSender());
	}

	@Override
	public void onComplete() {
		ref.tell("complete", ActorRef.noSender());
	}

}
