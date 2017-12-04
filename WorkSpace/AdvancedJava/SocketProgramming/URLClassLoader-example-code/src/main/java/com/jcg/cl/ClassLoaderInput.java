package com.jcg.cl;

import org.apache.log4j.Logger;

public class ClassLoaderInput {
	static Logger log = Logger.getLogger(ClassLoaderInput.class);

	public void printString() {
		log.info("Hello world from the loaded class !!!");
	}
}