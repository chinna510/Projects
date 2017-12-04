package com.kafka.SyncAsyncProducer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

public class ProducerNewJavaAPI implements DemoProducer {
	static Logger logger = Logger.getLogger(ProducerNewJavaAPI.class);
	private Properties props = new Properties();
	private Producer<String, String> producer;
	String topic;
	String sync;

	public ProducerNewJavaAPI(String topic) {
		super();
		this.topic = topic;
	}

	public void configure(String brokerList, String sync) {
		this.sync = sync;
		props.put("bootstrap.servers", brokerList);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("acks", "1");
		props.put("retries", "3");
		props.put("linger.ms", 5);

	}

	public void start() {
		producer = new KafkaProducer<String, String>(props);
	}

	public void produce(String s) {
		if (sync.equals("sync"))
			try {
				produceSync(s);
			} catch (InterruptedException e) {

				logger.error(e.getMessage());
			} catch (ExecutionException e) {

				logger.error(e.getMessage());
			}
		else if (sync.equals("async"))
			produceAsync(s);
		else
			throw new IllegalArgumentException("Expected sync or async, got " + sync);
	}

	private void produceSync(String s) throws InterruptedException, ExecutionException {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, s);
		producer.send(record).get();
	}

	private void produceAsync(String s) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, s);
		producer.send(record, new DemoProducerCallback());
	}

	public void close() {

	}

}
