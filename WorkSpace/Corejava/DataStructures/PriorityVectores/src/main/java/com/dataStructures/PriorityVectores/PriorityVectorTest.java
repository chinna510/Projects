<<<<<<< HEAD
package com.dataStructures.PriorityVectores;

import java.util.*;

import org.apache.log4j.Logger;

public class PriorityVectorTest {
	static Logger logger = Logger.getLogger(PriorityVectorTest.class);

	public static void main(String[] args) {
		PriorityVectores v = new PriorityVectores();
		logger.info("starting...\nadding:");
		for (int i = 0; i < 10; i++) {
			Integer j = new Integer((int) (Math.random() * 100));
			v.AddElement(j);
			logger.debug(" " + j);
		}
		logger.info("\nprinting:");
		Enumeration enume = v.elements();

		while (enume.hasMoreElements())
			logger.debug(" " + (Integer) enume.nextElement());
		logger.info("\nDone ;-)");
	}
}
=======
package com.dataStructures.PriorityVectores;

import java.util.*;

import org.apache.log4j.Logger;

public class PriorityVectorTest {
	static Logger logger = Logger.getLogger(PriorityVectorTest.class);

	public static void main(String[] args) {
		PriorityVectores v = new PriorityVectores();
		logger.info("starting...\nadding:");
		for (int i = 0; i < 10; i++) {
			Integer j = new Integer((int) (Math.random() * 100));
			v.AddElement(j);
			logger.debug(" " + j);
		}
		logger.info("\nprinting:");
		Enumeration enume = v.elements();

		while (enume.hasMoreElements())
			logger.debug(" " + (Integer) enume.nextElement());
		logger.info("\nDone ;-)");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
