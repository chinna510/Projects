package com.socket;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ProxyTest {
	static Logger logger = Logger.getLogger(ProxyTest.class);

	public static void main(String args[]) throws SocketException, URISyntaxException {
		try {
			Properties systemSettings = System.getProperties();
			systemSettings.put("proxySet", "true");
			systemSettings.put("http.proxyHost", "proxy.bizruntime.localhost");
			systemSettings.put("http.proxyPort", "80");
			URL u = new URL("http://www.bizruntime.com");
			HttpURLConnection con = (HttpURLConnection) u.openConnection();
			logger.debug(con.getResponseCode() + " : " + con.getResponseMessage());
			logger.debug(con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(false);
		}
		System.setProperty("java.net.useSystemProxies", "true");
		Proxy proxy = (Proxy) ProxySelector.getDefault().select(new URI("http://www.bizruntime.com/")).iterator()
				.next();
		logger.debug("proxy hostname : " + proxy.type());
		InetSocketAddress addr = (InetSocketAddress) proxy.address();
		if (addr == null) {
			logger.debug("No Proxy");
		} else {
			logger.debug("proxy hostname : " + addr.getHostName());
			logger.debug("proxy port : " + addr.getPort());
		}
	}
}
