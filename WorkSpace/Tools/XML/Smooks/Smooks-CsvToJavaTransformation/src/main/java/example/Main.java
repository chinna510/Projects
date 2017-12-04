
package example;

import org.apache.log4j.Logger;
import org.milyn.*;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.List;
import javax.xml.transform.stream.StreamSource;

public class Main {
	public static Logger logger = Logger.getLogger(Main.class);
	private static byte[] messageIn = readInputMessage();

	private static byte[] readInputMessage() {
		// for reading the input file
		try {
			return StreamUtils.readStream(new FileInputStream("src/main/resources/input.csv"));
		} catch (IOException e) {
			logger.error(e.getMessage());
			return "<no-message/>".getBytes();
		}
	}

	protected static List<?> csvToJavaTransform() {
		Smooks smooks = null;
		JavaResult result = new JavaResult();
		try {
			smooks = new Smooks("src/main/resources/smooks-config.xml");
			ExecutionContext executionContext = smooks.createExecutionContext();

			smooks.filterSource(executionContext,
					new StreamSource(new InputStreamReader(new ByteArrayInputStream(messageIn), "UTF-8")), result);

		} catch (SmooksException e) {
			logger.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (SAXException e) {
			logger.error(e.getMessage());
		} finally {
			smooks.close();
		}
		return (List<?>) result.getBean("customerList");
	}

	public static void main(String[] args) {
		List<?> messageOut = Main.csvToJavaTransform();
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream("src/main/resources/OutFile.java"));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());

		}
		out.print(messageOut);
		out.close();
	}
}
