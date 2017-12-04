package com.Sortings;

import org.apache.log4j.Logger;

public class AptimizedQuickSort {
	static Logger logger = Logger.getLogger(AptimizedQuickSort.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(Comparable[] c) {
		int i, j, left = 0, right = c.length - 1, stack_pointer = -1;
		int[] stack = new int[128];
		Comparable swap, temp;
		while (true) {
			if (right - left <= 7) {
				for (j = left + 1; j <= right; j++) {
					swap = c[j];
					i = j - 1;
					while (i >= left && c[i].compareTo(swap) > 0)
						c[i + 1] = c[i--];
					c[i + 1] = swap;
				}
				if (stack_pointer == -1)
					break;
				right = stack[stack_pointer--];
				left = stack[stack_pointer--];
			} else {
				int mid = (left + right) >> 1;
				i = left + 1;
				j = right;
				swap = c[mid];
				c[mid] = c[i];
				c[i] = swap;
				/* make sure: c[left] <= c[left+1] <= c[right] */
				if (c[left].compareTo(c[right]) > 0) {
					swap = c[left];
					c[left] = c[right];
					c[right] = swap;
				}
				if (c[i].compareTo(c[right]) > 0) {
					swap = c[i];
					c[i] = c[right];
					c[right] = swap;
				}
				if (c[left].compareTo(c[i]) > 0) {
					swap = c[left];
					c[left] = c[i];
					c[i] = swap;
				}
				temp = c[i];
				while (true) {
					do
						i++;
					while (c[i].compareTo(temp) < 0);
					do
						j--;
					while (c[j].compareTo(temp) > 0);
					if (j < i)
						break;
					swap = c[i];
					c[i] = c[j];
					c[j] = swap;
				}
				c[left + 1] = c[j];
				c[j] = temp;
				if (right - i + 1 >= j - left) {
					stack[++stack_pointer] = i;
					stack[++stack_pointer] = right;
					right = j - 1;
				} else {
					stack[++stack_pointer] = left;
					stack[++stack_pointer] = j - 1;
					left = i;
				}
			}
		}
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
