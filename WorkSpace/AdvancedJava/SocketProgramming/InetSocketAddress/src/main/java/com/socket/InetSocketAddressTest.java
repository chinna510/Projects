package com.socket;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;

public class InetSocketAddressTest {
	static Logger logger = Logger.getLogger(InetSocketAddressTest.class);

	public static void main(String[] args) {
		InetSocketAddress addr1 = new InetSocketAddress("localhost", 12345);
		printSocketAddress(addr1);

		InetSocketAddress addr2 = InetSocketAddress.createUnresolved("localhost", 12881);
		printSocketAddress(addr2);
	}

	public static void printSocketAddress(InetSocketAddress sAddr) {
		logger.debug("Socket  Address: " + sAddr.getAddress());
		logger.debug("Socket Host  Name: " + sAddr.getHostName());
		logger.debug("Socket Port:  " + sAddr.getPort());
		logger.debug("isUnresolved(): " + sAddr.isUnresolved());
		logger.debug("Host String: " + sAddr.getHostString().toString());

	}
}