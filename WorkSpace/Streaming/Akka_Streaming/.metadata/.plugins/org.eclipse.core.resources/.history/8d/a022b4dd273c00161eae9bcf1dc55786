package com.akka.stream;

import akka.stream.Attributes;
import akka.stream.Outlet;
import akka.stream.SourceShape;
import akka.stream.stage.AbstractOutHandler;
import akka.stream.stage.GraphStage;
import akka.stream.stage.GraphStageLogic;

public class NumberSource extends GraphStage<SourceShape<Integer>> {

	public final Outlet<Integer> out = Outlet.create("NumbersSource.out");

	private final SourceShape<Integer> shape = SourceShape.of(out);

	@Override
	public SourceShape<Integer> shape() {

		return shape;
	}

	@Override
	public GraphStageLogic createLogic(Attributes arg0) {

		return new GraphStageLogic(shape()) {

			private int counter = 1;
			{
				setHandler(out, new AbstractOutHandler() {

					@Override
					public void onPull() throws Exception {

						push(out, counter);
						counter = counter + 1;
					}
				});
			}

		};
	}

}
