package com.kafka.NewConsumer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

public class Producer {
	static Logger logger = Logger.getLogger(Producer.class);
	public static Properties props;
	public static KafkaProducer<?, ?> producer;

	public Producer() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.1.54:9092");
		props.put("acks", "all");
		props.put("retries", 3);
		props.put("batch.size", 16384);
		props.put("group.id", "id10");
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);

		for (int i = 3; i < 10; i++) {
			String messageNo = Integer.toString(i);
			String messageStr = Integer.toString(i);
			producer.send(new ProducerRecord<String, String>("test-topic10", messageNo, messageStr));

		}
		logger.info("Data Produced");
		producer.close();

	}

	public static void main(String[] args) {
		Producer pro = new Producer();

	}
}
