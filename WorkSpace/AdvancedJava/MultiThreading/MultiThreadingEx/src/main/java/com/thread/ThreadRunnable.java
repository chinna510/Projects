package com.thread;

import org.apache.log4j.Logger;

public class ThreadRunnable implements Runnable {
	static Logger logger = Logger.getLogger(ThreadRunnable.class);

	public void run() {
		logger.info("Thread Running ...");
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		ThreadRunnable tr = new ThreadRunnable();
		Thread th = new Thread(tr);
		th.start();
		th.sleep(1000);
		logger.info(th.getName());
	}
}