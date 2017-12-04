<<<<<<< HEAD
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class StackTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

	}
	static Logger logger = Logger.getLogger(ArrayStack.class);

	public static void main(String[] args) {
		ArrayStack2 s = new ArrayStack2(10);
		int i, j;
		logger.info("Stack Started!");
		for (i = 0; i < 10; i++) {
			j = (int) (Math.random() * 100);
			s.push(j);
			logger.debug("push: " + j);
		}
		while (!s.isEmpty()) {
			logger.debug("pop: " + s.pop());
		}
		logger.info("Done ;-)");
	}
}
=======
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class StackTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

	}
	static Logger logger = Logger.getLogger(ArrayStack.class);

	public static void main(String[] args) {
		ArrayStack2 s = new ArrayStack2(10);
		int i, j;
		logger.info("Stack Started!");
		for (i = 0; i < 10; i++) {
			j = (int) (Math.random() * 100);
			s.push(j);
			logger.debug("push: " + j);
		}
		while (!s.isEmpty()) {
			logger.debug("pop: " + s.pop());
		}
		logger.info("Done ;-)");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
