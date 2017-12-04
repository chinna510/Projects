package com.jcg;

import org.apache.log4j.Logger;

public class Bean {
	static Logger log = Logger.getLogger(Bean.class);

	public static void sayHello() {
		log.info("Hello from loaded JAR class !!!");
	}

	public static void main(String[] args) {
		sayHello();
	}
}
