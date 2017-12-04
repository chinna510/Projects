import java.net.*;
import java.io.*;

import org.apache.log4j.Logger;

public class URLDemo {
	static Logger log = Logger.getLogger(URLDemo.class);

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.gmail.com/index.htm?language=en#j2ee");

			log.debug("URL is: " + url.toString());
			log.debug("protocol is " + url.getProtocol());
			log.debug("authority is " + url.getAuthority());
			log.debug("file name is " + url.getFile());
			log.debug("host is " + url.getHost());
			log.debug("path is " + url.getPath());
			log.debug("port is " + url.getPort());
			log.debug("default port is " + url.getDefaultPort());
			log.debug("query is " + url.getQuery());
			log.debug("ref is " + url.getRef());
			log.debug("inetAddress " + InetAddress.getAllByName("localhost"));
		} catch (IOException io) {
			log.error(io);
		}
	}
}