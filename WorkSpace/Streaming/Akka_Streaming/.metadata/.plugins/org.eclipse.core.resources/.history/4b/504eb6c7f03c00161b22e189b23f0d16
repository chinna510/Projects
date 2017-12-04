package com.akka.stream;

import java.util.Arrays;

import akka.stream.Attributes;
import akka.stream.FlowShape;
import akka.stream.Inlet;
import akka.stream.Outlet;
import akka.stream.stage.AbstractInHandler;
import akka.stream.stage.AbstractOutHandler;
import akka.stream.stage.GraphStage;
import akka.stream.stage.GraphStageLogic;

public class Duplicator2<A> extends GraphStage<FlowShape<A, A>> {

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
						emitMultiple(out, Arrays.asList(elem, elem).iterator());
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
