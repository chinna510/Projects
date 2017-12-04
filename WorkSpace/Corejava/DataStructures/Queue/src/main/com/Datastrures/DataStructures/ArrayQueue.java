<<<<<<< HEAD
package com.Datastrures.DataStructures;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ArrayQueue {
	static Scanner sc = new Scanner(System.in);
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);
	{
		logger.debug("enter array size : ");

	}
	public final int SIZE = sc.nextInt();
	int top = -1;
	int rear = 0;
	protected int start, end;
	protected boolean full;
	int arr[] = new int[SIZE];

	public boolean isEmpty() {
		return ((start == end) && !full);
	}

	public void front(int element) {
		if (top < SIZE - 1) {
			top++;
			arr[top] = element;
			logger.debug(element + " is Pushed");
			display();
		} else {
			logger.error("OverFlow");
		}
	}

	public Object remove() {

		if (top >= rear) {
			rear++;
			logger.debug(arr[top] + " is Popped");

		} else {
			logger.info("UnderFlow");

		}
		return SIZE;
	}

	public void display() {
		if (top >= rear)
			logger.info("Elements in Queue are");
		for (int i = 0; i <= top; i++)
			logger.debug(arr[i]);

	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();

		logger.info("Queue Started");
		queue.isEmpty();
		queue.remove();
		queue.front(10);
		queue.remove();
		queue.front(20);
		queue.front(30);
		queue.front(40);
		queue.remove();
		queue.remove();
		logger.info("Queue Ended");
	}
}
=======
package com.Datastrures.DataStructures;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ArrayQueue {
	static Scanner sc = new Scanner(System.in);
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);
	{
		logger.debug("enter array size : ");

	}
	public final int SIZE = sc.nextInt();
	int top = -1;
	int rear = 0;
	protected int start, end;
	protected boolean full;
	int arr[] = new int[SIZE];

	public boolean isEmpty() {
		return ((start == end) && !full);
	}

	public void front(int element) {
		if (top < SIZE - 1) {
			top++;
			arr[top] = element;
			logger.debug(element + " is Pushed");
			display();
		} else {
			logger.error("OverFlow");
		}
	}

	public Object remove() {

		if (top >= rear) {
			rear++;
			logger.debug(arr[top] + " is Popped");

		} else {
			logger.info("UnderFlow");

		}
		return SIZE;
	}

	public void display() {
		if (top >= rear)
			logger.info("Elements in Queue are");
		for (int i = 0; i <= top; i++)
			logger.debug(arr[i]);

	}

	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue();

		logger.info("Queue Started");
		queue.isEmpty();
		queue.remove();
		queue.front(10);
		queue.remove();
		queue.front(20);
		queue.front(30);
		queue.front(40);
		queue.remove();
		queue.remove();
		logger.info("Queue Ended");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
