package com.smooks_JavaToJsonTransformation.JavaToJsonTransformation;

import com.model.Customer;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import java.io.IOException;

public class JavaToJson {
	static Logger log = Logger.getLogger(JavaToJson.class);
	RunSmooksTransform run = new RunSmooksTransform();

	public static void main(String[] args) throws IOException, SAXException {
		JavaToJson javatosvc = new JavaToJson();
		Customer customer = new Customer();
		javatosvc.run.runSmooksTransform(customer);
		log.info("Check output.csv in \"src/main/resources\" folder");
	}
}