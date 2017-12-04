<<<<<<< HEAD
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class QueuTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);

	public static void main(String[] args) {
		ArrayQueue2 q = new ArrayQueue2(10);
		Integer j = null;
		int i;
		logger.info("starting...");
		for (i = 0; i < 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			q.insert(j);
			logger.debug("insert: " + j);
		}
		while (!q.isEmpty()) {
			logger.debug("remove: " + ((Integer) q.remove()));
		}
		logger.info("Done ;-)");
	}
}
=======
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class QueuTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);

	public static void main(String[] args) {
		ArrayQueue2 q = new ArrayQueue2(10);
		Integer j = null;
		int i;
		logger.info("starting...");
		for (i = 0; i < 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			q.insert(j);
			logger.debug("insert: " + j);
		}
		while (!q.isEmpty()) {
			logger.debug("remove: " + ((Integer) q.remove()));
		}
		logger.info("Done ;-)");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
