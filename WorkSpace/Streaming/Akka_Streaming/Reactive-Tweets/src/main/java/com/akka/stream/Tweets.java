package com.akka.stream;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Tweets {

	public final String author;
	public final long timestamp;
	public final String body;

	public Tweets(String author, long timestamp, String body) {

		this.author = author;
		this.timestamp = timestamp;
		this.body = body;

	}

	public Set<Hashtag> hashtags() {

		return Arrays.asList(body.split(" ")).stream().filter(a -> a.startsWith("#")).map(a -> new Hashtag(a))
				.collect(Collectors.toSet());
	}

}
