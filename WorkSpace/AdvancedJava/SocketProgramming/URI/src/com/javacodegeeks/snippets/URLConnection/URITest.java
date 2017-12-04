package com.javacodegeeks.snippets.URLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;

import org.apache.log4j.Logger;

public class URITest {
	static Logger logger = Logger.getLogger(URITest.class);

	public static void main(String args[]) throws IOException {
		URI uri = null;

		URL url = null;
		try {

			uri = new URI("http://www.javacodegeeks.com/");

			logger.debug("URI created: " + uri);

		}

		catch (URISyntaxException e) {

			logger.debug("URI Syntax Error: " + e.getMessage());

		}

		try {

			url = uri.toURL();

			logger.debug("URL from URI: " + url);

		}

		catch (MalformedURLException e) {

			logger.error("Malformed URL: " + e.getMessage());

		}

		try {

			url = new URL("http://examples.javacodegeeks.com/");

			logger.debug("URL created: " + url);

		}

		catch (MalformedURLException e) {

			logger.error("Malformed URL: " + e.getMessage());

		}
		try {

			uri = url.toURI();

			logger.debug("URI from URL: " + uri);

		}

		catch (URISyntaxException e) {

			logger.error("URI Syntax Error: " + e.getMessage());

		}

	}
}