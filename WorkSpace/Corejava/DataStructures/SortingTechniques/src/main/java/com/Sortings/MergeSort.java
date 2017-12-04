<<<<<<< HEAD
package com.Sortings;

import org.apache.log4j.Logger;

public class MergeSort {
	static Logger logger = Logger.getLogger(HeapSort.class);
	public static void mergeSort(Comparable a[]) {
		Comparable[] aux = new Comparable[a.length];
		int i, j, k, l1, l2, size, u1, u2;
		size = 1;
		while (size < a.length) {
			l1 = k = 0;
			while ((l1 + size) < a.length) {
				l2 = l1 + size;
				u1 = l2 - 1;
				u2 = (l2 + size - 1 < a.length) ? l2 + size - 1 : a.length - 1;
				for (i = l1, j = l2; i <= u1 && j <= u2; k++)
					if (a[i].compareTo(a[j]) <= 0)
						aux[k] = a[i++];
					else
						aux[k] = a[j++];
				for (; i <= u1; k++)
					aux[k] = a[i++];
				for (; j <= u2; k++)
					aux[k] = a[j++];
				l1 = u2 + 1;
			}
			for (i = l1; k < a.length; i++)
				aux[k++] = a[i];
			for (i = 0; i < a.length; i++)
				a[i] = aux[i];
			size *= 2;
		}

	}public static void main(String[] args){
        Integer[] a = new Integer[10];
        logger.info("starting...\nadding:");
        for(int i=0;i<a.length;i++){
            a[i] = new Integer((int)(Math.random()*100));
            logger.info(" " + a[i]);
        }
        mergeSort(a);
        logger.info("\nprinting:");
        for(int i=0;i<a.length;i++){
            logger.info(" " + a[i]);
        }
        logger.info("\nDone ;-)");
    }

}
=======
package com.Sortings;

import org.apache.log4j.Logger;

public class MergeSort {
	static Logger logger = Logger.getLogger(HeapSort.class);
	public static void mergeSort(Comparable a[]) {
		Comparable[] aux = new Comparable[a.length];
		int i, j, k, l1, l2, size, u1, u2;
		size = 1;
		while (size < a.length) {
			l1 = k = 0;
			while ((l1 + size) < a.length) {
				l2 = l1 + size;
				u1 = l2 - 1;
				u2 = (l2 + size - 1 < a.length) ? l2 + size - 1 : a.length - 1;
				for (i = l1, j = l2; i <= u1 && j <= u2; k++)
					if (a[i].compareTo(a[j]) <= 0)
						aux[k] = a[i++];
					else
						aux[k] = a[j++];
				for (; i <= u1; k++)
					aux[k] = a[i++];
				for (; j <= u2; k++)
					aux[k] = a[j++];
				l1 = u2 + 1;
			}
			for (i = l1; k < a.length; i++)
				aux[k++] = a[i];
			for (i = 0; i < a.length; i++)
				a[i] = aux[i];
			size *= 2;
		}

	}public static void main(String[] args){
        Integer[] a = new Integer[10];
        logger.info("starting...\nadding:");
        for(int i=0;i<a.length;i++){
            a[i] = new Integer((int)(Math.random()*100));
            logger.info(" " + a[i]);
        }
        mergeSort(a);
        logger.info("\nprinting:");
        for(int i=0;i<a.length;i++){
            logger.info(" " + a[i]);
        }
        logger.info("\nDone ;-)");
    }

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
