<<<<<<< HEAD
package com.FirstProject;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Arithmetic {
	// private final String[] operators = {"`+`", "`-`", "`*`", "`/`"};
	int result;
	static {
		BasicConfigurator.configure();
	}
	static Logger logger = Logger.getLogger(Arithmetic.class);

	private void run(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		char operator = args[2].charAt(0);

		switch (operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		}
		logger.debug(num1 + args[2].replace("`", "") + num2 + "=" + result);
	}

	public static void main(String[] args) {
		Logger root = Logger.getRootLogger();
		root.setLevel(Level.DEBUG);

		Arithmetic aArithmetic = new Arithmetic();
		aArithmetic.run(args);

	}
=======
package com.FirstProject;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Arithmetic {
	// private final String[] operators = {"`+`", "`-`", "`*`", "`/`"};
	int result;
	static {
		BasicConfigurator.configure();
	}
	static Logger logger = Logger.getLogger(Arithmetic.class);

	private void run(String[] args) {
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		char operator = args[2].charAt(0);

		switch (operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		}
		logger.debug(num1 + args[2].replace("`", "") + num2 + "=" + result);
	}

	public static void main(String[] args) {
		Logger root = Logger.getRootLogger();
		root.setLevel(Level.DEBUG);

		Arithmetic aArithmetic = new Arithmetic();
		aArithmetic.run(args);

	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}