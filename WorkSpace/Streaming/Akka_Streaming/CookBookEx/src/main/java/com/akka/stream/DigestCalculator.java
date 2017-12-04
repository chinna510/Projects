package com.akka.stream;

import java.security.MessageDigest;

import akka.stream.Attributes;
import akka.stream.FlowShape;
import akka.stream.Inlet;
import akka.stream.Outlet;
import akka.stream.stage.AbstractInHandler;
import akka.stream.stage.AbstractOutHandler;
import akka.stream.stage.GraphStage;
import akka.stream.stage.GraphStageLogic;
import akka.util.ByteString;

public class DigestCalculator extends GraphStage<FlowShape<ByteString, ByteString>> {

	final String algorithm;

	final Inlet<ByteString> in = Inlet.create("DigestCalculator.in");

	final Outlet<ByteString> out = Outlet.create("DigestCalculator.out");

	FlowShape<ByteString, ByteString> shape = FlowShape.of(in, out);

	public DigestCalculator(String algorithm) {

		this.algorithm = algorithm;
	}

	@Override
	public FlowShape<ByteString, ByteString> shape() {
		return shape;
	}

	@Override
	public GraphStageLogic createLogic(Attributes inheritedAttributes) {
		return new GraphStageLogic(shape) {

			final MessageDigest msgDigest;
			{
				try {
					msgDigest = MessageDigest.getInstance(algorithm);

				} catch (Exception e) {

					throw new RuntimeException(e);

				}

				setHandler(in, new AbstractInHandler() {

					@Override
					public void onPush() throws Exception {

						ByteString chunk = grab(in);

						msgDigest.update(chunk.toArray());
						pull(in);

					}

					public void onUpstreamFinish() throws Exception {

						emit(out, ByteString.fromArray(msgDigest.digest()));
						completeStage();

					};
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
