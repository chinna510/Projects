package com.javacodegeeks.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class JavaNetURLExample {
	static Logger log = Logger.getLogger(JavaNetURLExample.class);

	public static void main(String[] args) {
		try {
			// Generate absolute URL
			// Base URL = www.gnu.org
			URL url1 = new URL("http://www.gnu.org");
			log.debug("URL1: " + url1.toString());

			// Generate URL for pages with a common base
			URL url2 = new URL(url1, "licenses/gpl.txt");
			log.debug("URL2: " + url2.toString());

			// Generate URL from different pieces of data
			URL url3 = new URL("http", "www.gnu.org", "/licenses/gpl.txt");
			log.debug("URL3: " + url3.toString());

			URL url4 = new URL("http", "www.gnu.org", 80, "/licenses/gpl.txt");
			log.debug("URL4: " + url4.toString() + "\n");

			// Open URL stream as an input stream and print contents to command
			// line
			try (BufferedReader in = new BufferedReader(new InputStreamReader(
					url4.openStream()))) {
				String inputLine;

				// Read the "gpl.txt" text file from its URL representation
				log.debug("/***** File content (URL4) *****/\n");
				while ((inputLine = in.readLine()) != null) {
					log.debug(inputLine);
				}
			} catch (IOException io) {
				log.error(io);
			}
		} catch (MalformedURLException mue) {
			log.error(mue);
		}
	}
}
