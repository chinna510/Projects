<<<<<<< HEAD
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LinkedListTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		Integer j = null;
		int i;
		logger.info("\nstarting...");
		for (i = 0; i < 5; i++) {
			j = new Integer((int) (Math.random() * 100));
			l.insert(j);
			logger.debug("\ninsert: " + j);
		}
		for (; i < 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			l.insertEnd(j);
			logger.debug("\ninsertEnd: " + j);
		}
		for (i = 0; i < l.size(); i++)
			logger.debug("\npeek " + i + ": " + l.peek(i));
		for (i = 0; i < 5; i++)
			logger.debug("\nremove: " + ((Integer) l.remove()));
		while (!l.isEmpty())
			logger.debug("\nremoveEnd: " + ((Integer) l.removeEnd()));
		logger.info("\nDone ;-)");
	}
}
=======
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LinkedListTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		Integer j = null;
		int i;
		logger.info("\nstarting...");
		for (i = 0; i < 5; i++) {
			j = new Integer((int) (Math.random() * 100));
			l.insert(j);
			logger.debug("\ninsert: " + j);
		}
		for (; i < 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			l.insertEnd(j);
			logger.debug("\ninsertEnd: " + j);
		}
		for (i = 0; i < l.size(); i++)
			logger.debug("\npeek " + i + ": " + l.peek(i));
		for (i = 0; i < 5; i++)
			logger.debug("\nremove: " + ((Integer) l.remove()));
		while (!l.isEmpty())
			logger.debug("\nremoveEnd: " + ((Integer) l.removeEnd()));
		logger.info("\nDone ;-)");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
