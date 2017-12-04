package com.kafka.SyncAsyncProducer;

import java.util.concurrent.ExecutionException;

public interface DemoProducer {
	void configure(String brokerList, String sync);

	void start();

	void produce(String s) ;

	void close();

}
