package com.kafka.NewConsumer;

import java.util.Properties;

import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class NewProducer extends Thread {
	private final KafkaProducer<Integer, String> producer;
	private final String topic;
	private final Boolean isAsync;

	public NewProducer(String topic, Boolean isAsync) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "192.168.1.54:9092");
		props.put("client.id", "DemoProducer");
		props.put("consumer.id", "id10");
		props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<Integer, String>(props);
		this.topic = topic;
		this.isAsync = isAsync;
	}

	public void run() {
		int messageNo = 1;
		while (messageNo < 50) {
			String messageStr = "Message_" + messageNo;
			long startTime = System.currentTimeMillis();
			if (isAsync) { 
				producer.send(new ProducerRecord<Integer, String>(topic, messageNo, messageStr),
						new DemoCallBack(startTime, messageNo, messageStr));
			} else {
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

	public static void main(String[] args) {
		NewProducer prod = new NewProducer("testTopic", false);
		prod.run();
	}
}