package com.akka.stream;

import akka.japi.Predicate;
import akka.stream.Attributes;
import akka.stream.FlowShape;
import akka.stream.Inlet;
import akka.stream.Outlet;
import akka.stream.stage.AbstractInHandler;
import akka.stream.stage.AbstractOutHandler;
import akka.stream.stage.GraphStage;
import akka.stream.stage.GraphStageLogic;

public class Filter<A> extends GraphStage<FlowShape<A, A>> {

	private final Predicate<A> p;

	public Filter(Predicate<A> p) {

		this.p = p;
	}

	Inlet<A> in = Inlet.create("Filter.in");
	Outlet<A> out = Outlet.create("Filter.out");

	FlowShape<A, A> shape = FlowShape.of(in, out);

	@Override
	public FlowShape<A, A> shape() {
		return shape;
	}

	@Override
	public GraphStageLogic createLogic(Attributes inheritedAttributes) {
		return new GraphStageLogic(shape) {
			{
				setHandler(in, new AbstractInHandler() {

					@Override
					public void onPush() throws Exception {

						A elem = grab(in);
						if (p.test(elem)) {
							push(out, elem);
						} else {
							pull(in);
						}
					}

				});
				setHandler(out, new AbstractOutHandler() {

					@Override
					public void onPull() throws Exception {
						pull(in);
					}
				});
			}
		};
	}

}
