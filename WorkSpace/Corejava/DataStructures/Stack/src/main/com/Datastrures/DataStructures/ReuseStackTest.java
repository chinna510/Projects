<<<<<<< HEAD
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ReuseStackTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

	}
	static Logger logger = Logger.getLogger(ReuseStackTest.class);

	public static void main(String[] args) {
		StackReuse st = new StackReuse();
		Integer j = null;

		for (int i = 0; i <= 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			st.push(j);
			logger.debug("\npush : " + j);

		}
		while(!st.isEmpty()){
            logger.debug("\npop: " + ((Integer)st.pop()));
        }

	}
}
=======
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ReuseStackTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");

	}
	static Logger logger = Logger.getLogger(ReuseStackTest.class);

	public static void main(String[] args) {
		StackReuse st = new StackReuse();
		Integer j = null;

		for (int i = 0; i <= 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			st.push(j);
			logger.debug("\npush : " + j);

		}
		while(!st.isEmpty()){
            logger.debug("\npop: " + ((Integer)st.pop()));
        }

	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
