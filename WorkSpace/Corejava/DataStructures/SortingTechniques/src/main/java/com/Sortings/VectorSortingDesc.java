package com.Sortings;

import java.util.*;
import java.io.*;

import org.apache.log4j.Logger;

public class VectorSortingDesc implements Comparator {
	static Logger logger = Logger.getLogger(VectorSortingDesc.class);

	@SuppressWarnings("unchecked")
	public int compare(Object o1, Object o2) {
		return -((Comparable) o1).compareTo(o2);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Vector v = new Vector();
		logger.info("starting...\nadding:");
		for (int i = 0; i < 10; i++) {
			Integer j = new Integer((int) (Math.random() * 100));
			v.addElement(j);
			logger.info(" " + j);
		}
		Collections.sort(v, new VectorSortingDesc());
		logger.info("\nprinting:");
		Enumeration enume = v.elements();
		while (enume.hasMoreElements())
			logger.info(" " + (Integer) enume.nextElement());
		logger.info("\nDone ;-)");
	}
}
