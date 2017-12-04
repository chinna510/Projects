package com.kafka.SyncAsyncProducer;

import java.util.Properties;

import kafka.producer.ProducerConfig;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;

public class DemoProducerOld implements DemoProducer {
	private Properties kafkaProps = new Properties();
	private Producer<String, String> producer;
	private ProducerConfig config;

	private String topic;

	public DemoProducerOld(String topic) {
		this.topic = topic;
	}

	public void configure(String brokerList, String sync) {
		kafkaProps.put("metadata.broker.list", brokerList);
		kafkaProps.put("serializer.class", "kafka.serializer.StringEncoder");
		kafkaProps.put("request.required.acks", "1");
		kafkaProps.put("producer.type", sync);
		kafkaProps.put("send.buffer.bytes", "550000");
		kafkaProps.put("receive.buffer.bytes", "550000");

		config = new ProducerConfig(kafkaProps);
	}

	public void start() {
		producer = new Producer<String, String>(config);
	}

	public void produce(String s) {
		KeyedMessage<String, String> message = new KeyedMessage<String, String>(topic, null, s);
		producer.send(message);
	}

	public void close() {
		producer.close();
	}

}
