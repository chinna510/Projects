package com.sqoop;

import org.apache.log4j.Logger;
import org.apache.sqoop.client.SqoopClient;
import org.apache.sqoop.model.MDriverConfig;
import org.apache.sqoop.model.MFromConfig;
import org.apache.sqoop.model.MJob;
import org.apache.sqoop.model.MToConfig;
import org.apache.sqoop.validation.Status;

public class JobCreation extends SqoopClient {
	static String url = "http://192.168.1.146:12000/sqoop/";
	SqoopClient client = new SqoopClient(url);
	static Logger logger = Logger.getLogger(JobCreation.class);

	public JobCreation(String serverUrl) {
		super(serverUrl);
	}

	public void test() {
		long fromLinkId = 43;
		long toLinkId = 42;
		MJob job = client.createJob(fromLinkId, toLinkId);
		job.setName("import");
		job.setCreationUser("bizruntime");
		MFromConfig fromJobConfig = job.getFromJobConfig();
		fromJobConfig.getStringInput("fromJobConfig.schemaName").setValue("sqoopdb");
		fromJobConfig.getStringInput("fromJobConfig.tableName").setValue("Persons");
		fromJobConfig.getStringInput("fromJobConfig.partitionColumn").setValue("PersonID");
		MToConfig toJobConfig = job.getToJobConfig();
		toJobConfig.getStringInput("toJobConfig.outputDirectory").setValue("/user/out1111/");
		MDriverConfig driverConfig = job.getDriverConfig();

		Status status = client.saveJob(job);
		if (status.canProceed()) {
			logger.info("Created Job with Job Id: " + job.getPersistenceId());
		} else {
			logger.info("Something went wrong creating the job");
		}
	}

	public static void main(String[] args) {
		JobCreation job = new JobCreation(url);
		job.test();
	}

}
