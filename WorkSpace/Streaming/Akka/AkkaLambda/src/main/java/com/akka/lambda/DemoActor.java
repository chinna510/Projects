package com.akka.lambda;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class DemoActor extends AbstractActor {

	static Props props(Integer magicNumber) {
		return Props.create(DemoActor.class, () -> new DemoActor(magicNumber));

	}

	private final Integer magicNumber;

	public DemoActor(Integer magicNumber) {
		this.magicNumber = magicNumber;
		receive(ReceiveBuilder.match(Integer.class, i -> {
			sender().tell(i + magicNumber, self());
		}).build());
	}

}
