package com.socket;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class Inet4AddressTest {
	static Logger logger = Logger.getLogger(Inet4AddressTest.class);

	public static void main(String[] args) throws UnknownHostException {
		String url = "bizruntime.com";

		try {

			Inet4Address address = (Inet4Address) Inet4Address.getByName(url);

			logger.debug("The IP of " + url + " is " + address.getLocalHost());
			logger.debug(address.isLinkLocalAddress());
			logger.debug(address.equals(Inet4Address.getLocalHost()));
			logger.debug(address.getCanonicalHostName());
			logger.debug(address.getHostName());
			logger.debug(address.isLoopbackAddress());

		} catch (UnknownHostException e) {
			logger.error(e.getMessage());

		}

	}

}
