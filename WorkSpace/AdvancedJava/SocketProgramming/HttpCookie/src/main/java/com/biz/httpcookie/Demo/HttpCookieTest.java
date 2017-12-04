package com.biz.httpcookie.Demo;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.log4j.Logger;

public class HttpCookieTest {

	static Logger log=Logger.getLogger(HttpCookieTest.class);
	public static void main(String[] args) throws IOException {
		
		String urlString = "https://www.google.com";

		//Create a default system-wide CookieManager
		CookieManager cookieManager = new CookieManager();

		CookieHandler.setDefault(cookieManager);

		//Open a connection for the given URL
		URL url = new URL(urlString);
		URLConnection urlConnection = url.openConnection();
		urlConnection.getContent();

		//Get CookieStore which is the default internal in-memory 
		CookieStore cookieStore = cookieManager.getCookieStore();

		//Retrieve all stored HttpCookies from CookieStore
		List<HttpCookie> cookies = cookieStore.getCookies();
		
		int cookieIdx = 0;
		log.info("chackpoint 1");
		//Iterate HttpCookie object
		for (HttpCookie ck : cookies) {
			
			log.info("------------------ Cookie." + ++cookieIdx  + " ------------------");

			//Get the cookie name
			log.info("Cookie name: " + ck.getName());
						
			//Get the domain set for the cookie
			log.info("Domain: " + ck.getDomain());

			//Get the max age of the cookie
			log.info("Max age: " + ck.getMaxAge());

			//Get the path of the server
			log.info("Server path: " + ck.getPath());

			//Get boolean if the cookie is being restricted to a secure protocol
			log.info("Is secured: " + ck.getSecure());

			//Gets the value of the cookie
			log.info("Cookie value: " + ck.getValue());

			//Gets the version of the protocol with which the given cookie is related.
			log.info("Cookie protocol version: " + ck.getVersion());
			
		}
		log.info("Checkpoint 2");
	}

}
