
package example;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.xml.sax.SAXException;

import example.model.Order;

public class Main {
	public static Logger logger = Logger.getLogger(Main.class);
	private static byte[] messageIn = readInputMessage();

	protected static Order xmlToJavaTransform() {
		Smooks smooks = null;
		JavaResult result = new JavaResult();
		try {
			smooks = new Smooks("src/main/resources/smooks-config.xml");

			ExecutionContext executionContext = smooks.createExecutionContext();

			smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(messageIn)), result);

		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (SAXException e) {
			logger.error(e.getMessage());
		} finally {
			smooks.close();
		}
		return (Order) result.getBean("order");
	}

	private static byte[] readInputMessage() {
		try {
			return StreamUtils.readStream(new FileInputStream("src/main/resources/input-message.xml"));
		} catch (IOException e) {
			logger.error(e.getMessage());
			return "<no-message/>".getBytes();
		}
	}

	public static void main(String[] args) {

		Order order = Main.xmlToJavaTransform();

		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream("src/main/resources/OutFile.txt"));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		out.println(order);

		out.close();
	}
}
