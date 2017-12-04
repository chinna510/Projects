package com.socket;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class Inet6AddressTest {
	static Logger logger = Logger.getLogger(Inet6AddressTest.class);

	public static void main(String[] args) throws UnknownHostException {

		String host = "bizruntime.com";

		InetAddress[] address = Inet6Address.getAllByName(host);
		for (InetAddress ia : address) {
			logger.debug(ia.getCanonicalHostName());
			logger.debug(ia.getCanonicalHostName());
		}
		InetAddress ina = Inet6Address.getLocalHost();
		logger.debug(ina.getCanonicalHostName());
		logger.debug(ina.getHostAddress());

	}

}
