package com.kafka.MessageTransfer;


import java.util.Properties;


import org.apache.log4j.Logger;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


public class SimpleProducer {
	static Logger logger = Logger.getLogger(SimpleProducer.class);
	private static Producer<Integer, String> producer;
	private final Properties props = new Properties();

	public SimpleProducer() {
		props.put("metadata.broker.list", "localhost:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("request.required.acks", "1");
		producer = new Producer<Integer, String>(new ProducerConfig(props));

	}

	public static void main(String[] args) {
		SimpleProducer sp = new SimpleProducer();
		String topic = (String) args[0];
		String messageStr = (String) args[1];
		KeyedMessage<Integer, String> data = new KeyedMessage<Integer, String>("test", messageStr);
		producer.send(data);
		producer.close();

	}
}
