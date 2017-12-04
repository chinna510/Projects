package com.kafka.AsyncProducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

public class AsyncProducer {
	static Logger logger = Logger.getLogger(AsyncProducer.class);
	public static Properties props;
	public static KafkaProducer<?, ?> producer;

	public AsyncProducer() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("producer.type", "async");
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		for (int i = 3; i < 100; i++)
			producer.send(new ProducerRecord<String, String>("testpage", Integer.toString(i), Integer.toString(i)));
		producer.close();
	}

	public static void main(String[] args) {
		AsyncProducer pro = new AsyncProducer();
	}
}
