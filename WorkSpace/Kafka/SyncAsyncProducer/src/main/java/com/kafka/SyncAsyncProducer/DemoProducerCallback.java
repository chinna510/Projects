package com.kafka.SyncAsyncProducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

public class DemoProducerCallback implements Callback {
	static Logger logger = Logger.getLogger(DemoProducerCallback.class);

	public void onCompletion(RecordMetadata recordMetadata, Exception e) {

		if (e != null) {
			logger.debug("Error producing the topic " + recordMetadata.topic());
			logger.error(e.getMessage());
		}
	}

}
