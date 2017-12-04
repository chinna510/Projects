package com.socket;

import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class NetworkInterfaceTest {
	static Logger logger = Logger.getLogger(NetworkInterfaceTest.class);

	public static void test(NetworkInterface ni) throws SocketException {
		logger.debug("Display Name : " + ni.getDisplayName());
		logger.debug("Index : " + ni.getIndex());
		logger.debug("MTU : " + ni.getMTU());
		logger.debug("Class Name : " + ni.getClass());
		logger.debug("HardwareAddress : " + ni.getHardwareAddress());
		logger.debug("Inet Address : " + ni.getInetAddresses());
		logger.debug("LoopBack : " + ni.isLoopback());
		logger.debug("Point to point : " + ni.isPointToPoint());
		logger.debug("Up : " + ni.isUp());
		logger.debug("Virtual : " + ni.isVirtual());
		logger.debug("SupportsMulticast : " + ni.supportsMulticast());
		logger.info(" ");
		logger.info("Network Addresses ");
		List<InterfaceAddress> list = ni.getInterfaceAddresses();
		Iterator<InterfaceAddress> it = list.iterator();
		while (it.hasNext()) {
			InterfaceAddress ia = it.next();
			logger.debug("Address : " + ia.getAddress());
			logger.debug("Broadcast : " + ia.getBroadcast());
			logger.debug("Length : " + ia.getNetworkPrefixLength());
		}
		logger.info(" ");
	}

	public static void main(String[] args) throws UnknownHostException, SocketException {
		Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
		while (en.hasMoreElements()) {
			NetworkInterface ni = en.nextElement();
			test(ni);
		}
	}

}
