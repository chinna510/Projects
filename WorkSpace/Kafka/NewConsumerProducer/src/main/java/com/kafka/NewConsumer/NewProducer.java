package com.kafka.NewConsumer;

import java.util.Properties;

import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer extends Thread {
	private final KafkaProducer<Integer, String> producer;
	private final String topic;
	private final Boolean isAsync;

	public Producer(String topic, Boolean isAsync) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("client.id", "DemoProducer");
		props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<Integer, String>(props);
		this.topic = topic;
		this.isAsync = isAsync;
	}

	public void run() {
		int messageNo = 1;
		while (true) {
			String messageStr = "Message_" + messageNo;
			long startTime = System.currentTimeMillis();
			if (isAsync) { // Send asynchronously
				producer.send(new ProducerRecord<Integer, String>(topic, messageNo, messageStr),
						new DemoCallBack(startTime, messageNo, messageStr));
			} else { // Send synchronously
				try {
					producer.send(new ProducerRecord<Integer, String>(topic, messageNo, messageStr)).get();
					System.out.println("Sent message: (" + messageNo + ", " + messageStr + ")");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
			++messageNo;
		}
	}
}