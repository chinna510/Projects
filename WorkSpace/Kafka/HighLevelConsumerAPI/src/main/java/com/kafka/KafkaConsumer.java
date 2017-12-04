package com.kafka;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class KafkaConsumer {
	static Logger  log=Logger.getLogger(KafkaConsumer.class); 
	public static void main(String[] args) {

		String group = "Group1";
		Properties props = new Properties();
		props.put("zookeeper.connect", "localhost:2181");
		props.put("group.id", group);
		props.put("zookeeper.session.timeout.ms", "413");
		props.put("zookeeper.sync.time.ms", "203");
		props.put("auto.commit.interval.ms", "1000");
		props.put("consumer.id","A1");
		ConsumerConfig cf = new ConsumerConfig(props);

		ConsumerConnector consumer = Consumer.createJavaConsumerConnector(cf);

		String topic = "test5";

		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, new Integer(1));
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer
				.createMessageStreams(topicCountMap);
		List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);

		KafkaStream<byte[], byte[]> stream = streams.get(0);

		ConsumerIterator<byte[], byte[]> it = stream.iterator();
		int i = 1;
		while (it.hasNext()) {
			log.info(i + ": " + new String(it.next().message()));
			++i;
		}

		consumer.shutdown();
	}

}