package com.biz.Cmanager;
import java.net.CookieHandler;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.apache.log4j.Logger;

public class CookieManagerExample {
	static Logger log=Logger.getLogger(CookieManagerExample.class);

	private final static String URL_STRING = "http://www.bing.com";

	public static void main(String args[]) throws Exception 
	{
		CookieManager cookieManager = new CookieManager();
		CookieHandler.setDefault(cookieManager);
		URL url = new URL(URL_STRING);
		URLConnection connection = url.openConnection();
		connection.getContent();
		CookieStore cookieStore = cookieManager.getCookieStore();
		List<HttpCookie> cookieList = cookieStore.getCookies();
		for (HttpCookie cookie : cookieList) 
		{
			log.info("Domain: " + cookie.getDomain());
			log.info("max age: " + cookie.getMaxAge());
			log.info("name of cookie: " + cookie.getName());
			log.info("server path: " + cookie.getPath());
			log.info("is cookie secure: " + cookie.getSecure());
			log.info("value of cookie: " + cookie.getValue());
			log.info("version of cookie: " + cookie.getVersion());
		}
		log.info(cookieManager.getCookieStore());
	}
}