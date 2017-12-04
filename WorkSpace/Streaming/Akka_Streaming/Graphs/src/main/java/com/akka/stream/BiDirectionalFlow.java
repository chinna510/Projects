package com.akka.stream;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.PFBuilder;
import akka.stream.ActorMaterializer;
import akka.stream.BidiShape;
import akka.stream.FlowShape;
import akka.stream.Materializer;
import akka.stream.javadsl.BidiFlow;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.GraphDSL;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.ByteIterator;
import akka.util.ByteString;
import akka.util.ByteStringBuilder;

interface Message {
}

public class BiDirectionalFlow {

	ActorSystem system = ActorSystem.create("BiDirectionalFlows");
	Materializer mat = ActorMaterializer.create(system);
	LoggingAdapter log = Logging.getLogger(system, this);

	public static ByteString toBytes(Message msg) {
		if (msg instanceof Ping) {
			final int id = ((Ping) msg).id;
			return new ByteStringBuilder().putByte((byte) 1).putInt(id, ByteOrder.LITTLE_ENDIAN).result();
		} else {
			final int id = ((Pong) msg).id;
			return new ByteStringBuilder().putByte((byte) 2).putInt(id, ByteOrder.LITTLE_ENDIAN).result();
		}

	}

	public static Message fromBytes(ByteString bytes) {
		final ByteIterator it = bytes.iterator();
		switch (it.getByte()) {
		case 1:
			return new Ping(it.getInt(ByteOrder.LITTLE_ENDIAN));
		case 2:
			return new Pong(it.getInt(ByteOrder.LITTLE_ENDIAN));
		default:
			throw new RuntimeException("message format error");

		}

	}

	@SuppressWarnings("unused")
	private void flow() throws InterruptedException, ExecutionException, TimeoutException {

		BidiFlow<Message, ByteString, ByteString, Message, NotUsed> verboseCodec = BidiFlow
				.fromGraph(GraphDSL.create(b -> {

					final FlowShape<Message, ByteString> top = b
							.add(Flow.of(Message.class).map(BiDirectionalFlow::toBytes));
					final FlowShape<ByteString, Message> bottom = b
							.add(Flow.of(ByteString.class).map(BiDirectionalFlow::fromBytes));
					return BidiShape.fromFlows(top, bottom);

				}));
		final BidiFlow<Message, ByteString, ByteString, Message, NotUsed> codec = BidiFlow
				.fromFunctions(BiDirectionalFlow::toBytes, BiDirectionalFlow::fromBytes);

		final BidiFlow<ByteString, ByteString, ByteString, ByteString, NotUsed> framing = BidiFlow
				.fromGraph(GraphDSL.create(b -> {
					final FlowShape<ByteString, ByteString> top = b
							.add(Flow.of(ByteString.class).map(BiDirectionalFlow::addLengthHeader));
					final FlowShape<ByteString, ByteString> bottom = b
							.add(Flow.of(ByteString.class).via(new FrameParser()));
					return BidiShape.fromFlows(top, bottom);
				}));

		final BidiFlow<Message, ByteString, ByteString, Message, NotUsed> stack = codec.atop(framing);

		// test it by plugging it into its own inverse and closing the right end
		final Flow<Message, Message, NotUsed> pingpong = Flow.of(Message.class)
				.collect(new PFBuilder<Message, Message>().match(Ping.class, p -> new Pong(p.id)).build());

		final Flow<Message, Message, NotUsed> flow = stack.atop(stack.reversed()).join(pingpong);

		Sink<List<Message>, CompletionStage<Done>> sink = Sink.foreach(p -> System.out.println("sink" + p));

		final CompletionStage<Done> result = Source.from(Arrays.asList(0, 1, 2, 3, 4)).<Message>map(id -> new Ping(id))
				.via(flow).grouped(10).runWith(sink, mat);

		result.whenComplete((i, j) -> System.out.println("BI " + i));

		/*
		 * final CompletionStage<List<Message>> result =
		 * Source.from(Arrays.asList(0, 1, 2, 3, 4)) .<Message>map(id -> new
		 * Ping(id)).via(flow).grouped(10).runWith(Sink.<List<Message>>head(),
		 * mat);
		 * 
		 * result.thenAcceptAsync(f -> { log.info("" + f);
		 * 
		 * }).toCompletableFuture(); result.toCompletableFuture().get(1,
		 * TimeUnit.SECONDS).toArray(new Message[0]);
		 */
	}

	public static ByteString addLengthHeader(ByteString bytes) {
		final int len = bytes.size();
		return new ByteStringBuilder().putInt(len, ByteOrder.LITTLE_ENDIAN).append(bytes).result();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		BiDirectionalFlow test = new BiDirectionalFlow();
		test.flow();
	}
}

class Ping implements Message {

	public int id;

	public Ping(int id) {
		this.id = id;

	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Ping) {
			return ((Ping) o).id == id;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return id;
	}

}

class Pong implements Message {

	public int id;

	public Pong(int id) {
		this.id = id;

	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Pong) {
			return ((Pong) o).id == id;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
