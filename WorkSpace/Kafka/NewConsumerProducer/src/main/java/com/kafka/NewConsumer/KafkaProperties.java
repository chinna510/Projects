package com.kafka.NewConsumer;

public interface KafkaProperties {
	final static String groupId = "group1";
	final static String topic = "test1";
	final static String kafkaServerURL = "localhost";
	final static int kafkaServerPort = 9092;
	final static int kafkaProducerBufferSize = 64 * 1024;
	final static int connectionTimeOut = 100000;
	final static int reconnectInterval = 10000;
	final static String topic2 = "topic2";
	final static String topic3 = "topic3";
	final static String clientId = "SimpleConsumerDemoClient";

}
