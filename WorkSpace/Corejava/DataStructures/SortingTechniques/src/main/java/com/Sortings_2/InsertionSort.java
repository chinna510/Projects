package com.Sortings;

import org.apache.log4j.Logger;

public class InsertionSort {
	static Logger logger = Logger.getLogger(HeapSort.class);
	public static void insertionSort(Comparable a[]) {
		int i, j;
		Comparable e;
		for (i = 1; i < a.length; i++) {
			e = a[i];
			for (j = i - 1; j >= 0 && a[j].compareTo(e) > 0; j--)
				a[j + 1] = a[j];
			a[j + 1] = e;
		}
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[10];
		logger.debug("starting...\nadding:");
		for (int i = 0; i < a.length; i++) {
			a[i] = new Integer((int) (Math.random() * 100));
			logger.debug(" " + a[i]);
		}
		insertionSort(a);
		logger.debug("\nprinting:");
		for (int i = 0; i < a.length; i++) {
			logger.debug(" " + a[i]);
		}
		logger.debug("\nDone ;-)");
	}
}
