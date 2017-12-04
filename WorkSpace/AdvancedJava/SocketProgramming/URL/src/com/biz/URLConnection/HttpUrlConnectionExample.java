package com.biz.URLConnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.Logger;

public class HttpUrlConnectionExample {
	static Logger log = Logger.getLogger(HttpUrlConnectionExample.class);

	private final String USER_AGENT = "google-chrome";

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://www.google.com/search?q=mkyong";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		log.debug("\nSending 'GET' request to URL : " + url);
		log.debug("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		
		String inputLine;
		
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		log.debug(response.toString());
	}

	// HTTP POST request
	private void sendPost() throws Exception {

		String url = "https://selfsolve.apple.com/wcResults.do";
		
		URL obj = new URL(url);
		
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		
		// add reuqest header
		con.setRequestMethod("POST");
		
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		
		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
		
		// Send post request
		con.setDoOutput(true);
		
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		
		wr.writeBytes(urlParameters);
		
		wr.flush();
		wr.close();
		
		int responseCode = con.getResponseCode();
		log.debug("\nSending 'POST' request to URL : " + url);
		log.debug("ContentHandler:");
		log.debug("Post parameters : " + urlParameters);
		log.debug("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		
		String inputLine;
		
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print result
		log.debug(response.toString());
	}

	public static void main(String[] args) throws Exception {

		HttpUrlConnectionExample http = new HttpUrlConnectionExample();

		log.debug("Testing 1 - Send Http GET request");
		http.sendGet();

		log.debug("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}
}