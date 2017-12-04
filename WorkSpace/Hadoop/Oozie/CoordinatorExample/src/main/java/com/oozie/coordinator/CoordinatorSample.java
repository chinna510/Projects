package com.oozie.coordinator;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.WorkflowJob;

public class CoordinatorSample {
	OozieClient wc = null;

	public CoordinatorSample(String oozieUrl) {
		wc = new OozieClient(oozieUrl);
	}

	static Logger logger = Logger.getLogger(CoordinatorSample.class);

	public void test() {
		OozieClient wc = new OozieClient("http://192.168.1.146:11000/oozie/");

		Properties conf = wc.createConfiguration();
		conf.setProperty(OozieClient.APP_PATH, "hdfs://localhost:9000/user/bizruntime/oozie/cron/");
		// conf.setProperty("oozie.coord.application.path","hdfs://localhost:9000/user/bizruntime/oozie/cron/");
		conf.setProperty("jobTracker", "192.168.1.146:8032");
		conf.setProperty("nameNode", "hdfs://localhost:9000");
		conf.setProperty("queueName", "default");
		conf.setProperty("oozie.libpath", "hdfs://localhost:9000/user/bizruntime/share/lib/");
		conf.setProperty("oozie.use.system.libpath", "true");
		conf.setProperty("oozie.wf.rerun.failnodes", "true");
		conf.setProperty("startTime", "2016-05-02T12:49Z");
		conf.setProperty("endTime", "2016-05-02T12:50Z");

		try {
			String jobId = wc.run(conf);
			logger.info("Workflow job, " + jobId + " submitted");
			while (wc.getJobInfo(jobId).getStatus() == WorkflowJob.Status.RUNNING) {
				logger.info("Workflow job running ...");
				logger.info(wc.getStatus(jobId));
				Thread.sleep(10 * 1000);
			}

			logger.info(wc.getJobLog(jobId));
			logger.info(wc.getOozieUrl());
			logger.info(wc.getSystemMode());
			logger.info("Workflow job completed ...");
			logger.info(wc.getJobInfo(jobId));

		} catch (Exception r) {
			logger.info("Errors " + r.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		String oozieUrl = "http://192.168.1.146:11000/oozie/";
		CoordinatorSample coord = new CoordinatorSample(oozieUrl);
		coord.test();
	}
}