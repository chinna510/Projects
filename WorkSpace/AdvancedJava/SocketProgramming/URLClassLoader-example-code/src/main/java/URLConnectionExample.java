

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;

import org.apache.log4j.Logger;
public class URLConnectionExample 
{
	static Logger log=Logger.getLogger(URLConnectionExample.class);
	private static final String FINAL_URL="http://www.google.com/";
	public static void main(String args[]) throws IOException
	{
		StringBuilder content = new StringBuilder();
		// create a url object
		URL url = new URL(FINAL_URL);
		
		// create a url connection object
		URLConnection urlConnection = url.openConnection();
		
		//display Content Type
		log.info("Content-Type: " +urlConnection.getContentType());
		
		// display Content Length
		log.info("Content-Length: " + urlConnection.getContentLength()); 
		
		// display Date
		log.info( "Date: " +new Date(urlConnection.getDate()));
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
		String line;
		 
		// read from the urlconnection via the bufferedreader
		while ((line = bufferedReader.readLine()) != null)
		{
			content.append(line + "\n");
		}
		bufferedReader.close();
		log.info("output:\n "+content);
	}
}
