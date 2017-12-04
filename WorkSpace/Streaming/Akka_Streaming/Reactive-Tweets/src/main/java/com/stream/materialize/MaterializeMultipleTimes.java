package com.stream.materialize;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;

import com.akka.stream.Author;
import com.akka.stream.Hashtag;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.function.Procedure;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Keep;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;

public class MaterializeMultipleTimes {

	private final ActorSystem system = ActorSystem.create("akka-reactive-tweets");
	private final LoggingAdapter log = Logging.getLogger(system, this);
	public static final String AKKA = "#akka";

	final Materializer materializer = ActorMaterializer.create(system);
	Sink<String, CompletionStage<Done>> writeAuthors = Sink.foreach(new Procedure<String>() {
		private static final long serialVersionUID = 1L;

		@Override
		public void apply(String s) throws Exception {
			System.out.println(s);

		}
	});
	Sink<Hashtag, CompletionStage<Done>> writeHashtags = Sink.foreach(new Procedure<Hashtag>() {
		private static final long serialVersionUID = 1L;

		public void apply(Hashtag h) throws Exception {
			System.out.println(h.name);
		};
	});

	public static final Source<Tweet, NotUsed> tweets = Source.from(
			Arrays.asList(new Tweet[] { new Tweet(new Author("rolandkuhn"), System.currentTimeMillis(), "#akka rocks!"),
					new Tweet(new Author("patriknw"), System.currentTimeMillis(), "#akka !"),
					new Tweet(new Author("bantonsson"), System.currentTimeMillis(), "#akka !"),
					new Tweet(new Author("drewhk"), System.currentTimeMillis(), "#akka !"),
					new Tweet(new Author("ktosopl"), System.currentTimeMillis(), "#akka on the rocks!"),
					new Tweet(new Author("mmartynas"), System.currentTimeMillis(), "wow #akka !"),
					new Tweet(new Author("akkateam"), System.currentTimeMillis(), "#akka rocks!"),
					new Tweet(new Author("bananaman"), System.currentTimeMillis(), "#bananas rock!"),
					new Tweet(new Author("appleman"), System.currentTimeMillis(), "#apples rock!"),
					new Tweet(new Author("drama"), System.currentTimeMillis(), "we compared #apples to #oranges!") }));

	public void test() {

		final Source<Tweet, NotUsed> tweetsInMinuteFromNow = tweets;

		final Sink<Integer, CompletionStage<Integer>> sumSink = Sink.<Integer, Integer>fold(0,
				(acc, elem) -> acc + elem);
		final RunnableGraph<CompletionStage<Integer>> counterRunnableGraph = tweetsInMinuteFromNow
				.filter(t -> t.hashtags().contains(AKKA)).map(t -> 1).toMat(sumSink, Keep.right());

		final CompletionStage<Integer> morningTweetsCount = counterRunnableGraph.run(materializer);

		morningTweetsCount.thenAcceptAsync(c -> log.debug("Total Morning tweets processed: " + c), system.dispatcher())
				.whenComplete((a, b) -> system.terminate());

		final CompletionStage<Integer> eveningTweetsCount = counterRunnableGraph.run(materializer);

		eveningTweetsCount.thenAcceptAsync(c -> log.debug("Total Evening  tweets processed: " + c), system.dispatcher())
				.whenComplete((a, b) -> system.terminate());

		final CompletionStage<Integer> sum = tweets.map(t -> 1).runWith(sumSink, materializer);

		sum.thenAcceptAsync(c -> log.debug("Total tweets processed: " + c), system.dispatcher())
				.whenComplete((a, b) -> system.terminate());

	}

	public static void main(String[] args) {
		MaterializeMultipleTimes dsl = new MaterializeMultipleTimes();
		dsl.test();
	}

}