<<<<<<< HEAD
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class DataStructuresTest {
	static {
		BasicConfigurator.configure();

	}
	static Logger logger = Logger.getLogger(ArrayStack.class);
	
	{

		logger.debug("enter size of an array :");
	}

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack();
		logger.info("Stack Started");
		stack.pop();
		stack.push(25);
		stack.push(45);
		stack.push(27);
		stack.push(26);
		stack.pop();
		stack.pop();
		stack.push(56);
		stack.push(78);
		stack.push(22);
		stack.pop();
		stack.pop();

		
	}

}
=======
package com.Datastrures.DataStructures;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class DataStructuresTest {
	static {
		BasicConfigurator.configure();

	}
	static Logger logger = Logger.getLogger(ArrayStack.class);
	
	{

		logger.debug("enter size of an array :");
	}

	public static void main(String[] args) {

		ArrayStack stack = new ArrayStack();
		logger.info("Stack Started");
		stack.pop();
		stack.push(25);
		stack.push(45);
		stack.push(27);
		stack.push(26);
		stack.pop();
		stack.pop();
		stack.push(56);
		stack.push(78);
		stack.push(22);
		stack.pop();
		stack.pop();

		
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
