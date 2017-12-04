<<<<<<< HEAD
package com.Datastrures.DataStructures;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Vector<T> {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);

	private int capacity;
	private int size;
	private ArrayList<T> vector;
	private static final int INCREMENT_FACTOR = 5;

	public Vector(int size) {
		this.size = size;
		this.capacity = size + INCREMENT_FACTOR;
		vector = new ArrayList<T>();
	}

	public void store(int index, T value) {
		try {
			vector.set(index, value);
		} catch (IndexOutOfBoundsException indexOutBounds) {
			if (index >= 0 && (index < size)) {
				vector.add(index, value);
			}
			if (index >= 0 && (index >= size && index < capacity)) {
				vector.add(index, value);
				size = index + 1;
				if (size == capacity)
					capacity = capacity + INCREMENT_FACTOR;
			}
			if (index >= capacity) {
				throw new IndexOutOfBoundsException();
			}
		}
	}

	public T get(int index) {
		try {
			return vector.get(index);
		} catch (IndexOutOfBoundsException indexOutBounds) {
		}
		return null;
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public static void main(String... arg) {
		int size;
		int num;
		int value;

		Scanner scanner = new Scanner(System.in);
		logger.info("Enter the initial size of the vector : ");
		size = scanner.nextInt();

		Vector<Integer> vector = new Vector<Integer>(size);
		logger.info("Enter the number of elements : ");
		num = scanner.nextInt();

		logger.info("Enter the values  : ");
		for (int index = 0; index < num; index++) {
			value = scanner.nextInt();
			vector.store(index, value);
		}

		logger.info("The Entered Values are       : ");
		for (int index = 0; index < vector.getSize(); index++) {
			System.out.print(vector.get(index) + "\t");
		}

		logger.info("\nTHE SIZE OF THE VECTOR IS    : " + vector.getSize());
		logger.info("\nTHE CAPACITY OF THE VECTOR IS : " + vector.getCapacity());
		scanner.close();
	}
=======
package com.Datastrures.DataStructures;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Vector<T> {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);

	private int capacity;
	private int size;
	private ArrayList<T> vector;
	private static final int INCREMENT_FACTOR = 5;

	public Vector(int size) {
		this.size = size;
		this.capacity = size + INCREMENT_FACTOR;
		vector = new ArrayList<T>();
	}

	public void store(int index, T value) {
		try {
			vector.set(index, value);
		} catch (IndexOutOfBoundsException indexOutBounds) {
			if (index >= 0 && (index < size)) {
				vector.add(index, value);
			}
			if (index >= 0 && (index >= size && index < capacity)) {
				vector.add(index, value);
				size = index + 1;
				if (size == capacity)
					capacity = capacity + INCREMENT_FACTOR;
			}
			if (index >= capacity) {
				throw new IndexOutOfBoundsException();
			}
		}
	}

	public T get(int index) {
		try {
			return vector.get(index);
		} catch (IndexOutOfBoundsException indexOutBounds) {
		}
		return null;
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public static void main(String... arg) {
		int size;
		int num;
		int value;

		Scanner scanner = new Scanner(System.in);
		logger.info("Enter the initial size of the vector : ");
		size = scanner.nextInt();

		Vector<Integer> vector = new Vector<Integer>(size);
		logger.info("Enter the number of elements : ");
		num = scanner.nextInt();

		logger.info("Enter the values  : ");
		for (int index = 0; index < num; index++) {
			value = scanner.nextInt();
			vector.store(index, value);
		}

		logger.info("The Entered Values are       : ");
		for (int index = 0; index < vector.getSize(); index++) {
			System.out.print(vector.get(index) + "\t");
		}

		logger.info("\nTHE SIZE OF THE VECTOR IS    : " + vector.getSize());
		logger.info("\nTHE CAPACITY OF THE VECTOR IS : " + vector.getCapacity());
		scanner.close();
	}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
}