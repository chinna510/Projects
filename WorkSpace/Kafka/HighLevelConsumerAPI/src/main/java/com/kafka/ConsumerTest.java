package com.kafka;

import org.apache.log4j.Logger;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

public class ConsumerTest implements Runnable {
	static Logger logger = Logger.getLogger(ConsumerTest.class);
	private KafkaStream<byte[], byte[]> m_stream;
	private int m_threadNumber;

	public ConsumerTest(KafkaStream<byte[], byte[]> a_stream, int a_threadNumber) {
		m_threadNumber = a_threadNumber;
		m_stream = a_stream;
	}

	public void run() {
		ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
		while (it.hasNext())
			logger.debug("Thread " + m_threadNumber + ": " + new String(it.next().message()));
		logger.debug("Shutting down Thread: " + m_threadNumber);
	}
}