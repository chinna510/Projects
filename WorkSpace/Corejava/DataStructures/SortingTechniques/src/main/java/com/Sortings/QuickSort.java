package com.Sortings;

import org.apache.log4j.Logger;

/*OutPut:
 * inserting: 
 55 6 64 73 85 48 63 3 23 63 49 86 17 6 89 38 57 61 90 77 
 sorted: 
 3 6 6 17 23 38 48 49 55 57 61 63 63 64 73 77 85 86 89 90 
 Done ;-)
 */
public class QuickSort {
	static Logger logger = Logger.getLogger(QuickSort.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void qsort(Comparable[] c, int start, int end) {
		if (end <= start)
			return;
		Comparable comp = c[start];
		int i = start, j = end + 1;
		for (;;) {
			do
				i++;
			while (i < end && c[i].compareTo(comp) < 0);
			do
				j--;
			while (j > start && c[j].compareTo(comp) > 0);
			if (j <= i)
				break;
			Comparable tmp = c[i];
			c[i] = c[j];
			c[j] = tmp;
		}
		c[start] = c[j];
		c[j] = comp;
		qsort(c, start, j - 1);
		qsort(c, j + 1, end);
	}

	@SuppressWarnings("rawtypes")
	public static void qsort(Comparable[] c) {
		qsort(c, 0, c.length - 1);
	}

	public static void main(String[] args) {
		int i;
		Integer[] arr = new Integer[20];
		logger.info("inserting: ");
		for (i = 0; i < arr.length; i++) {
			arr[i] = new Integer((int) (Math.random() * 99));
			logger.info(arr[i] + " ");
		}
		QuickSort.qsort(arr);
		logger.info("\nsorted: ");
		for (i = 0; i < arr.length; i++)
			logger.info(arr[i] + " ");
		logger.info("\nDone ;-)");
	}
}
