package com.akka.externalserveices;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public interface RS {

	Publisher<Tweet> tweets();
	// #tweets-publisher

	// #author-storage-subscriber
	Subscriber<Author> storage();
	// #author-storage-subscriber

	// #author-alert-subscriber
	Subscriber<Author> alert();

}
