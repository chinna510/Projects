package com.XSLT.XSLTTransformation;

//jdk1.4.1
import javax.xml.transform.*;
import java.net.*;
import java.io.*;

public class HowToXSLT {
	public static void main(String[] args) {
		try {

			TransformerFactory tFactory = TransformerFactory.newInstance();

			Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("src/main/resources/input.xsl"));

			transformer.transform(new javax.xml.transform.stream.StreamSource("src/main/resources/input.xml"),
					new javax.xml.transform.stream.StreamResult(new FileOutputStream("src/main/resources/Output1.html")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}