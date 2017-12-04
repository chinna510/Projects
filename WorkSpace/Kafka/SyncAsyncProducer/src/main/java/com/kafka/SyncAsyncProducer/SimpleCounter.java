package com.kafka.SyncAsyncProducer;

import org.apache.log4j.Logger;

public class SimpleCounter {
	private static DemoProducer producer;
	static Logger logger = Logger.getLogger(ProducerNewJavaAPI.class);

	public static void main(String[] args) {
		if (args.length == 0) {
			logger.info("SimpleCounter {broker-list} {topic} {type old/new} {type sync/async} {delay (ms)} {count}");
			return;
		}
		String brokerList = args[0];
		String topic = args[1];
		String age = args[2];
		String sync = args[3];
		int delay = Integer.parseInt(args[4]);
		int count = Integer.parseInt(args[5]);
		if (age.equals("old"))
			producer = new DemoProducerOld(topic);
		else if (age.equals("new"))
			producer = new ProducerNewJavaAPI(topic);
		else {
			logger.debug("Third argument should be old or new, got " + age);
			System.exit(-1);
		}

		/* start a producer */
		producer.configure(brokerList, sync);
		producer.start();

		long startTime = System.currentTimeMillis();
		logger.info("Starting...");
		producer.produce("Starting...");

		/* produce the numbers */
		for (int i = 0; i < count; i++) {
			producer.produce(Integer.toString(i));
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		long endTime = System.currentTimeMillis();
		logger.debug("... and we are done. This took " + (endTime - startTime) + " ms.");
		producer.produce("... and we are done. This took " + (endTime - startTime) + " ms.");

		/* close shop and leave */
		producer.close();
		System.exit(0);
	}

}
