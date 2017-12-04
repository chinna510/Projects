package com.kafka.KafkaProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class TopicCreation {
	private static Producer<String, String> producer;
	private final Properties props = new Properties();

	public TopicCreation() {
		InputStream in = TopicCreation.class.getClassLoader().getResourceAsStream("kafka.properties");
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		props.put("metadata.broker.list", props.get("brokerlist"));
		props.put("serializer.class", props.get("serializerclass"));
		props.put("request.required.acks", props.get("requiredacks"));

		producer = new Producer<String, String>(new ProducerConfig(props));

	}

	public static void main(String[] args) {

		TopicCreation sp = new TopicCreation();
		sp.produce();
	}

	public void produce() {

		// ZooKeeperClient zc=new ZooKeeperClient();
		String topic = "TopicsCreation1";

		// zc.createTopic(topic);
		String messageStr = "Simple Message Testing";
		KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, messageStr);

		producer.send(data);
		producer.close();

	}
}
