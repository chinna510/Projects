package com.smooks_JavaToJsonTransformation.JavaToJsonTransformation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.payload.JavaSource;
import org.xml.sax.SAXException;

public class RunSmooksTransform {
	protected String runSmooksTransform(Object inputJavaObject) throws IOException, SAXException {
		Smooks smooks = new Smooks("src/main/resources/smooks-config.xml");
		try {
			ExecutionContext executionContext = smooks.createExecutionContext();
			StringWriter writer = new StringWriter();
			smooks.filterSource(executionContext, new JavaSource(inputJavaObject),
					new StreamResult(new FileOutputStream(new File("src/main/resources/output.jsn"))));
			return writer.toString();
		} finally {
			smooks.close();
		}
	}
}
