package com.smooks.smooks_CsvToXml;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.xml.sax.SAXException;

public class SmooksTransformation {
	static Logger logger = Logger.getLogger(SmooksTransformation.class);
	private static byte[] messageIn = readInputMessage();

	private static byte[] readInputMessage() {
		try {
			return StreamUtils.readStream(new FileInputStream("src/main/resources/input.csv"));
		} catch (IOException e) {
			logger.error(e.getMessage());
			return "<no-message/>".getBytes();
		}
	}

	protected void csvToXml() {

		Smooks smooks = null;
		try {
			smooks = new Smooks("smooks-config.xml");
		} catch (IOException e) {

			logger.error(e.getMessage());
		} catch (SAXException e) {

			logger.error(e.getMessage());
		}

		try {
			ExecutionContext executionContext = smooks.createExecutionContext();
			FileOutputStream fout = null;
			try {
				fout = new FileOutputStream("src/main/resources/output.xml");
			} catch (FileNotFoundException e) {
				logger.error(e.getMessage());
			}
			try {
				smooks.filterSource(executionContext,
						new StreamSource(new InputStreamReader(new ByteArrayInputStream(messageIn), "UTF-8")),
						new StreamResult(fout));
			} catch (SmooksException e) {
				logger.error(e.getMessage());
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage());
			}
		} finally {
			smooks.close();
		}
	}

	public static void main(String[] args) {

		SmooksTransformation transform = new SmooksTransformation();
		try {
			transform.csvToXml();
		} catch (SmooksException e) {

			logger.error("SmooksException :" + e.getMessage());
		}
		logger.info("check output.xml");
	}

}