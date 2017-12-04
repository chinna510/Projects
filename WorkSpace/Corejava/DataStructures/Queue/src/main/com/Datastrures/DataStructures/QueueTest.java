<<<<<<< HEAD
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class QueueTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

	}
	static Logger logger = Logger.getLogger(ArrayStack.class);

	public static void main(String[] args) {
		QueueAndLL s = new QueueAndLL();
		Integer j = null;
		int i;
		logger.info("\nstarting...");
		for (i = 0; i < 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			s.insert(j);
			logger.debug("\ninsert: " + j);
		}
		while (!s.isEmpty()) {
			logger.debug("\nremove: " + ((Integer) s.remove()));
		}
		logger.info("\nDone ;-)");
	}
}
=======
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class QueueTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

	}
	static Logger logger = Logger.getLogger(ArrayStack.class);

	public static void main(String[] args) {
		QueueAndLL s = new QueueAndLL();
		Integer j = null;
		int i;
		logger.info("\nstarting...");
		for (i = 0; i < 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			s.insert(j);
			logger.debug("\ninsert: " + j);
		}
		while (!s.isEmpty()) {
			logger.debug("\nremove: " + ((Integer) s.remove()));
		}
		logger.info("\nDone ;-)");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
