package com.numbers;

import com.sun.istack.logging.Logger;

public class PrimeNumber {
	static Logger logger = Logger.getLogger(PrimeNumber.class);

	public int prime(int number) {
		if (number % 2 == 1) {
			logger.info(number + " is prime number");
		} else {
			logger.info(number + " is not prime number");
		}
		return number;

	}
}
