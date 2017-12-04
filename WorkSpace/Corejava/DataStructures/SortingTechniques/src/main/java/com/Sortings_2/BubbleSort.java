package com.Sortings;

import org.apache.log4j.Logger;

public class BubbleSort {
	static Logger logger = Logger.getLogger(HeapSort.class);
	public static void bubbleSort(Comparable a[]) {
		boolean switched = true;
		for (int i = 0; i < a.length - 1; i++) {

			switched = false;
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					switched = true;
					Comparable temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

				}
			}
		}

	}
	public static void main(String[] args){
        Integer[] a = new Integer[10];
        logger.info("starting...\nadding:");
        for(int i=0;i<a.length;i++){
            a[i] = new Integer((int)(Math.random()*100));
            logger.info(" " + a[i]);
        }
        bubbleSort(a);
        logger.info("\nprinting:");
        for(int i=0;i<a.length;i++){
            logger.info(" " + a[i]);
        }
        logger.info("\nDone ;-)");
    }

}
