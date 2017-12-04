package com.Sortings;

import java.util.*;

import org.apache.log4j.Logger;

/*
 * starting...
 adding: 80 42 34 63 48 50 36 69 7 7
 printing: 7 7 34 36 42 48 50 63 69 80
 Done ;-)
 */
public class VectorSortingAcse {
	static Logger logger = Logger.getLogger(VectorSortingAcse.class);

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Vector v = new Vector();
		logger.info("starting...\nadding:");
		for (int i = 0; i < 10; i++) {
			Integer j = new Integer((int) (Math.random() * 100));
			v.addElement(j);
			logger.info(" " + j);
		}
		Collections.sort(v);
		logger.info("\nprinting:");
		Enumeration enume = v.elements();
		while (enume.hasMoreElements())
			logger.info(" " + (Integer) enume.nextElement());
		logger.info("\nDone ;-)");
	}

}
