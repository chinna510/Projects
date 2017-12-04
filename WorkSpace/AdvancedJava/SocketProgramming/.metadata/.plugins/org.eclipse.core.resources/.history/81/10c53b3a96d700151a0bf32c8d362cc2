package com.socket;

import java.net.SocketPermission;
import java.security.AccessController;

import org.apache.log4j.Logger;

public class SocketPermissionTest {
	static Logger logger = Logger.getLogger(SocketPermissionTest.class);

	public static void main(String[] args) {
		SocketPermission socket = new SocketPermission("www.google.com", "connect");
		try {
			AccessController.checkPermission(socket);
			logger.info("Ok to open Socket");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
