<<<<<<< HEAD
package com.Sortings;

import org.apache.log4j.Logger;

public class SelectionSort {
	static Logger logger = Logger.getLogger(HeapSort.class);
	public static void selectionSort(Comparable a[]) {

		for (int i = a.length - 1; i > 0; i--) {
			Comparable large = a[0];
			int indx = 0;
			for (int j = 1; j <= i; j++)
				if (a[j].compareTo(large) > 0) {
					large = a[j];
					indx = j;
				}
			a[indx] = a[i];
			a[i] = large;
		}

	}

	public static void main(String[] args) {
		Integer[] a = new Integer[10];
		logger.info("starting...\nadding:");
		for (int i = 0; i < a.length; i++) {
			a[i] = new Integer((int) (Math.random() * 100));
			logger.info(" " + a[i]);
		}
		selectionSort(a);
		logger.info("\nprinting:");
		for (int i = 0; i < a.length; i++) {
			logger.info(" " + a[i]);
		}
		logger.info("\nDone ;-)");
	}
}
=======
package com.Sortings;

import org.apache.log4j.Logger;

public class SelectionSort {
	static Logger logger = Logger.getLogger(HeapSort.class);
	public static void selectionSort(Comparable a[]) {

		for (int i = a.length - 1; i > 0; i--) {
			Comparable large = a[0];
			int indx = 0;
			for (int j = 1; j <= i; j++)
				if (a[j].compareTo(large) > 0) {
					large = a[j];
					indx = j;
				}
			a[indx] = a[i];
			a[i] = large;
		}

	}

	public static void main(String[] args) {
		Integer[] a = new Integer[10];
		logger.info("starting...\nadding:");
		for (int i = 0; i < a.length; i++) {
			a[i] = new Integer((int) (Math.random() * 100));
			logger.info(" " + a[i]);
		}
		selectionSort(a);
		logger.info("\nprinting:");
		for (int i = 0; i < a.length; i++) {
			logger.info(" " + a[i]);
		}
		logger.info("\nDone ;-)");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
