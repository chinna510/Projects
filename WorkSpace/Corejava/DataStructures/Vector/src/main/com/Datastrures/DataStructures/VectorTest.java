<<<<<<< HEAD
package com.Datastrures.DataStructures;

import java.util.Enumeration;
import java.util.Vector;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class VectorTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);

	public void test() {
		Vector<Number> v = new Vector<Number>(3, 2);
		logger.debug("\nInitial size: " + v.size());
		logger.debug("\nInitial capacity: " + v.capacity());
		v.addElement(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		logger.debug("\nCapacity after four additions: " + v.capacity());
		v.addElement(new Double(5.45));
		logger.debug("\nCurrent capacity: " + v.capacity());
		v.addElement(new Double(6.08));
		v.addElement(new Integer(7));
		System.out.println("\nCurrent capacity: " + v.capacity());
		v.addElement(new Float(9.4));
		v.addElement(new Integer(10));
		System.out.println("\nCurrent capacity: " + v.capacity());
		v.addElement(new Integer(11));
		v.addElement(new Integer(12));
		logger.debug("\nFirst element: " + (Integer) v.firstElement());
		logger.debug("\nLast element: " + (Integer) v.lastElement());
		if (v.contains(new Integer(3)))
			logger.debug("\nVector contains 3.");
		// enumerate the elements in the vector.
		Enumeration<Number> vEnum = v.elements();
		logger.debug("\nElements in vector:");
		while (vEnum.hasMoreElements())
			logger.debug(vEnum.nextElement() + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		VectorTest ve = new VectorTest();
		ve.test();
	}
}
=======
package com.Datastrures.DataStructures;

import java.util.Enumeration;
import java.util.Vector;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class VectorTest {
	static {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
	}
	static Logger logger = Logger.getLogger(ArrayQueue.class);

	public void test() {
		Vector<Number> v = new Vector<Number>(3, 2);
		logger.debug("\nInitial size: " + v.size());
		logger.debug("\nInitial capacity: " + v.capacity());
		v.addElement(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		logger.debug("\nCapacity after four additions: " + v.capacity());
		v.addElement(new Double(5.45));
		logger.debug("\nCurrent capacity: " + v.capacity());
		v.addElement(new Double(6.08));
		v.addElement(new Integer(7));
		System.out.println("\nCurrent capacity: " + v.capacity());
		v.addElement(new Float(9.4));
		v.addElement(new Integer(10));
		System.out.println("\nCurrent capacity: " + v.capacity());
		v.addElement(new Integer(11));
		v.addElement(new Integer(12));
		logger.debug("\nFirst element: " + (Integer) v.firstElement());
		logger.debug("\nLast element: " + (Integer) v.lastElement());
		if (v.contains(new Integer(3)))
			logger.debug("\nVector contains 3.");
		// enumerate the elements in the vector.
		Enumeration<Number> vEnum = v.elements();
		logger.debug("\nElements in vector:");
		while (vEnum.hasMoreElements())
			logger.debug(vEnum.nextElement() + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		VectorTest ve = new VectorTest();
		ve.test();
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
