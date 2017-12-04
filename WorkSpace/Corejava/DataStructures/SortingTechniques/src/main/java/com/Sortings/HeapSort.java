<<<<<<< HEAD
package com.Sortings;

import org.apache.log4j.Logger;

public class HeapSort {
	static Logger logger = Logger.getLogger(HeapSort.class);

	public static void heapSort(Comparable a[]) {
		int i, f, s;
		for (i = 1; i < a.length; i++) {
			Comparable e = a[i];
			s = i;
			f = (s - 1) / 2;
			while (s > 0 && a[f].compareTo(e) < 0) {
				a[s] = a[f];
				s = f;
				f = (s - 1) / 2;
			}
			a[s] = e;
		}
		for (i = a.length - 1; i > 0; i--) {
			Comparable value = a[i];
			a[i] = a[0];
			f = 0;
			if (i == 1)
				s = -1;
			else
				s = 1;
			if (i > 2 && a[2].compareTo(a[1]) > 0)
				s = 2;
			while (s >= 0 && value.compareTo(a[s]) < 0) {
				a[f] = a[s];
				f = s;
				s = 2 * f + 1;
				if (s + 1 <= i - 1 && a[s].compareTo(a[s + 1]) < 0)
					s = s + 1;
				if (s > i - 1)
					s = -1;
			}
			a[f] = value;
		}
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[10];
		logger.info("starting...\nadding:");
		for (int i = 0; i < a.length; i++) {
			a[i] = new Integer((int) (Math.random() * 100));
			logger.debug(" " + a[i]);
		}
		heapSort(a);
		logger.info("\nprinting:");
		for (int i = 0; i < a.length; i++) {
			logger.debug(" " + a[i]);
		}
		logger.info("\nDone ;-)");
	}
}
=======
package com.Sortings;

import org.apache.log4j.Logger;

public class HeapSort {
	static Logger logger = Logger.getLogger(HeapSort.class);

	public static void heapSort(Comparable a[]) {
		int i, f, s;
		for (i = 1; i < a.length; i++) {
			Comparable e = a[i];
			s = i;
			f = (s - 1) / 2;
			while (s > 0 && a[f].compareTo(e) < 0) {
				a[s] = a[f];
				s = f;
				f = (s - 1) / 2;
			}
			a[s] = e;
		}
		for (i = a.length - 1; i > 0; i--) {
			Comparable value = a[i];
			a[i] = a[0];
			f = 0;
			if (i == 1)
				s = -1;
			else
				s = 1;
			if (i > 2 && a[2].compareTo(a[1]) > 0)
				s = 2;
			while (s >= 0 && value.compareTo(a[s]) < 0) {
				a[f] = a[s];
				f = s;
				s = 2 * f + 1;
				if (s + 1 <= i - 1 && a[s].compareTo(a[s + 1]) < 0)
					s = s + 1;
				if (s > i - 1)
					s = -1;
			}
			a[f] = value;
		}
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[10];
		logger.info("starting...\nadding:");
		for (int i = 0; i < a.length; i++) {
			a[i] = new Integer((int) (Math.random() * 100));
			logger.debug(" " + a[i]);
		}
		heapSort(a);
		logger.info("\nprinting:");
		for (int i = 0; i < a.length; i++) {
			logger.debug(" " + a[i]);
		}
		logger.info("\nDone ;-)");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
