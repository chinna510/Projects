package com.sqoop;

import org.apache.log4j.Logger;
import org.apache.sqoop.client.SqoopClient;

import org.apache.sqoop.model.MLink;
import org.apache.sqoop.model.MLinkConfig;
import org.apache.sqoop.validation.Status;

public class LinkCreation extends SqoopClient {
	String url = "http://192.168.1.146:12000/sqoop/";
	SqoopClient client = new SqoopClient(url);
	static Logger logger = Logger.getLogger(LinkCreation.class);

	public LinkCreation(String serverUrl) {
		super(serverUrl);

	}

	public void test() {
		long connectorId = 1;
		MLink link = client.createLink(connectorId);
		link.setName("Vampire");
		link.setCreationUser("Buffy");
		MLinkConfig linkConfig = link.getConnectorLinkConfig();

		linkConfig.getStringInput("linkConfig.connectionString").setValue("jdbc:mysql://192.168.1.146:3306/sqoopdb");
		linkConfig.getStringInput("linkConfig.jdbcDriver").setValue("com.mysql.jdbc.Driver");
		linkConfig.getStringInput("linkConfig.username").setValue("root");
		linkConfig.getStringInput("linkConfig.password").setValue("root");
		Status status = client.saveLink(link);
		if (status.canProceed()) {
			logger.info("Created Link with Link Id : " + link.getPersistenceId());
		} else {
			logger.info("Something went wrong creating the link");
		}
	}

	public static void main(String[] args) {
		String url = "http://192.168.1.146:12000/sqoop/";
		LinkCreation link1 = new LinkCreation(url);
		link1.test();
	}
}