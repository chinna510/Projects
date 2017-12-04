package com.smooks.Smooks_XMLToCSVTransform;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLToCSVTransformation {
	static Logger logger = Logger.getLogger(XMLToCSVTransformation.class);

	public void xmlToCsv() {
		File stylesheet = new File("src/main/resources/input.xsl");
		File xmlSource = new File("src/main/resources/sample.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage());
		}
		Document document = null;
		try {
			document = builder.parse(xmlSource);
		} catch (SAXException e) {

			logger.error(e.getMessage());
		} catch (IOException e) {

			logger.error(e.getMessage());
		}

		StreamSource stylesource = new StreamSource(stylesheet);
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer(stylesource);
		} catch (TransformerConfigurationException e) {

			logger.error(e.getMessage());
		} catch (TransformerFactoryConfigurationError e) {

			logger.error(e.getMessage());
		}
		Source source = new DOMSource(document);
		Result outputTarget = new StreamResult(new File("src/main/resources/output.csv"));
		try {
			transformer.transform(source, outputTarget);
		} catch (TransformerException e) {

			logger.error(e.getMessage());
		}
		logger.info("Done.");
	}

	public static void main(String args[]) throws Exception {
		XMLToCSVTransformation transform = new XMLToCSVTransformation();
		transform.xmlToCsv();
	}
}