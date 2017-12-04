package mutithreadedsocket;

import java.io.DataInputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Main {
	static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] argv) throws Exception {
		byte[] b = new byte[1];
		Properties systemSettings = System.getProperties();
		systemSettings.put("http.proxyHost", "proxy.mydomain.local");
		systemSettings.put("http.proxyPort", "80");

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("gmail\\joydeeppaul2541",
						"dogababa123".toCharArray());
			}
		});

		URL u = new URL("http://www.google.com");
		HttpURLConnection con = (HttpURLConnection) u.openConnection();
		DataInputStream di = new DataInputStream(con.getInputStream());
		while (-1 != di.read(b, 0, 1)) {
			log.info(new String(b));
		}
	}
}