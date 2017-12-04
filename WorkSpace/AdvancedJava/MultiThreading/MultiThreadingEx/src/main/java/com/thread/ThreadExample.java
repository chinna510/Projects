package com.thread;

import org.apache.log4j.Logger;

public class ThreadExample extends Thread {
	static Logger logger = Logger.getLogger(ThreadExample.class);

	public void run() {
		logger.info("Thread is Running......");

	}

	public static void main(String[] args) {
		ThreadExample ex = new ThreadExample();
		ex.start();
		logger.info(ex.isAlive());
		logger.info(ex.isDaemon());
		logger.info(ex.isInterrupted());
		logger.info(ex.getClass());
		logger.info(ex.getContextClassLoader());
		logger.info(ex.getId());
		logger.info(ex.getName());
		logger.info(ex.getPriority());
		logger.info(ex.getState());
		logger.info(ex.getStackTrace());
		logger.info(ex.getAllStackTraces());
		logger.info(ex.currentThread());

	}

}