package com.javacodegeeks.examples;

import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;

public class JavaNetURLMoreMethodsExample {
	static Logger log=Logger.getLogger(JavaNetURLMoreMethodsExample.class);
	public static void main(String[] args) {
		try {
			// Creates a URL object from the String representation.
			URL url = new URL("http://www.gnu.org/licenses/gpl.txt");

			// Gets the authority part of this URL.
			log.debug("URL Authority: " + url.getAuthority());

			// Gets the default port number of the protocol associated with this
			// URL.
			log.debug("URL Default Port: " + url.getDefaultPort());

			// Gets the file name of this URL.
			log.debug("URL File Name: " + url.getFile());

			// Gets the host name of this URL, if applicable.
			log.debug("URL Host Name: " + url.getHost());

			// Gets the path part of this URL.
			log.debug("URL Path: " + url.getPath());

			// Gets the protocol name of this URL.
			log.debug("URL Protocal Name: " + url.getProtocol());
		} catch (IOException io) {
			log.error(io);
		}
	}
}
