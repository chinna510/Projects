<<<<<<< HEAD
package com.Datastrures.DataStructures;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ArrayStack {
	public static Scanner sc = new Scanner(System.in);
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		 
	}
	Logger logger = Logger.getLogger(ArrayStack.class);

	{

		logger.debug("enter size of an array :");
	}
	public final int SIZE = sc.nextInt();

	int top = -1;
	int arr[] = new int[SIZE];

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;

	}

	public void push(int element) {
		if (top <= SIZE - 1) {
			top++;
			arr[top] = element;
			logger.debug("pushed element is : " + element);
			printElements();

		} else {
			logger.debug("Stack Overflow");

		}
	}

	public void pop() {
		if (top >= 0) {
			logger.debug("popped element is : " + arr[top]);
			top--;
			printElements();
			
		} else {
			logger.debug("Stack underflow");
		}
	}

	public void printElements() {
		if (top >= 0) {
			for (int i = 0; i <= top; i++)
				logger.info("elements are : " + arr[i]);

		}
	}

}
=======
package com.Datastrures.DataStructures;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ArrayStack {
	public static Scanner sc = new Scanner(System.in);
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		 
	}
	Logger logger = Logger.getLogger(ArrayStack.class);

	{

		logger.debug("enter size of an array :");
	}
	public final int SIZE = sc.nextInt();

	int top = -1;
	int arr[] = new int[SIZE];

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;

	}

	public void push(int element) {
		if (top <= SIZE - 1) {
			top++;
			arr[top] = element;
			logger.debug("pushed element is : " + element);
			printElements();

		} else {
			logger.debug("Stack Overflow");

		}
	}

	public void pop() {
		if (top >= 0) {
			logger.debug("popped element is : " + arr[top]);
			top--;
			printElements();
			
		} else {
			logger.debug("Stack underflow");
		}
	}

	public void printElements() {
		if (top >= 0) {
			for (int i = 0; i <= top; i++)
				logger.info("elements are : " + arr[i]);

		}
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
