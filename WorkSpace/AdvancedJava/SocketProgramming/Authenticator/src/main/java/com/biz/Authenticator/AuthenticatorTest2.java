package com.biz.Authenticator;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AuthenticatorTest2 {
	static Logger logger = Logger.getLogger(AuthenticatorTest2.class);

	public static void main(String[] args) throws IOException {

		byte[] b = new byte[1];
		Properties systemSettings = System.getProperties();
		systemSettings.put("http.proxyHost", "proxy.mydomain.local");
		systemSettings.put("http.proxyPort", "80");

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("mydomain\\username", "password".toCharArray());
			}
		});

		URL u = new URL("http://www.torrentz.com");
		HttpURLConnection con = (HttpURLConnection) u.openConnection();
		DataInputStream di = new DataInputStream(con.getInputStream());
		while (-1 != di.read(b, 0, 1)) {
			logger.debug(new String(b));
		}
		
	}

}
