package com.akka.remoting;

import akka.actor.UntypedActor;

public class CalculatorActor extends UntypedActor {

	@Override
	public void onReceive(Object message) throws Exception {

		if (message instanceof Add) {
			Add add = (Add) message;
			System.out.println("Calculating " + add.getN1() + " + " + add.getN2());
			AddResult result = new AddResult(add.getN1(), add.getN2(), add.getN1() + add.getN2());
			getSender().tell(result, getSelf());

		} else if (message instanceof Subtract) {
			Subtract subtract = (Subtract) message;
			System.out.println("Calculating " + subtract.getN1() + " - " + subtract.getN2());
			SubtractResult result = new SubtractResult(subtract.getN1(), subtract.getN2(),
					subtract.getN1() - subtract.getN2());
			getSender().tell(result, getSelf());

		} else if (message instanceof Multiply) {
			Multiply multiply = (Multiply) message;
			System.out.println("Calculating " + multiply.getN1() + " * " + multiply.getN2());
			MultiplicationResult result = new MultiplicationResult(multiply.getN1(), multiply.getN2(),
					multiply.getN1() * multiply.getN2());
			getSender().tell(result, getSelf());

		} else if (message instanceof Divide) {
			Divide divide = (Divide) message;
			System.out.println("Calculating " + divide.getN1() + " / " + divide.getN2());
			DivisionResult result = new DivisionResult(divide.getN1(), divide.getN2(), divide.getN1() / divide.getN2());
			getSender().tell(result, getSelf());

		} else {
			unhandled(message);
		}
	}
}
