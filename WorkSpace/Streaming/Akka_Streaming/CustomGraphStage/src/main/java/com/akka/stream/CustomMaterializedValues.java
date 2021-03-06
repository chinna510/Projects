package com.akka.stream;

import java.util.concurrent.CompletionStage;

import akka.dispatch.Futures;
import akka.stream.Attributes;
import akka.stream.FlowShape;
import akka.stream.Inlet;
import akka.stream.Outlet;
import akka.stream.stage.AbstractInHandler;
import akka.stream.stage.AbstractOutHandler;
import akka.stream.stage.GraphStageLogic;
import akka.stream.stage.GraphStageWithMaterializedValue;
import scala.Tuple2;
import scala.concurrent.Promise;

public class CustomMaterializedValues<A> extends GraphStageWithMaterializedValue<FlowShape<A, A>, CompletionStage<A>> {

	Inlet<A> in = Inlet.create("Filter.in");
	Outlet<A> out = Outlet.create("Filter.out");

	FlowShape<A, A> shape = FlowShape.of(in, out);

	@Override
	public FlowShape<A, A> shape() {
		return shape;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Tuple2<GraphStageLogic, CompletionStage<A>> createLogicAndMaterializedValue(Attributes inheritedAttributes) {

		Promise<A> promise = Futures.promise();

		GraphStageLogic logic = new GraphStageLogic(shape) {

			{
				setHandler(in, new AbstractInHandler() {

					@Override
					public void onPush() throws Exception {
						A elem = grab(in);
						promise.success(elem);
						push(out, elem);

						setHandler(in, new AbstractInHandler() {

							@Override
							public void onPush() throws Exception {

								push(out, grab(in));
							}
						});
					}
				});
				{
					setHandler(out, new AbstractOutHandler() {

						@Override
						public void onPull() throws Exception {

							pull(in);
						}
					});
				}
			}

		};

		return new Tuple2(logic, promise.future());
	}

}
