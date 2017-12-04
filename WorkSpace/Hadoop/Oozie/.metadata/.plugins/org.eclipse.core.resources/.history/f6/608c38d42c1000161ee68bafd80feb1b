package com.oozie.OozieExamples;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.oozie.BuildInfo;
import org.apache.oozie.cli.OozieCLI;
import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.WorkflowJob;
import org.apache.oozie.client.event.message.JobMessage;

public class OozieJavaClient {
	static Logger logger = Logger.getLogger(OozieJavaClient.class);

	public void test() {
		OozieClient wc = new OozieClient("http://192.168.1.146:11000/oozie/");

		Properties conf = wc.createConfiguration();
		conf.setProperty(OozieClient.APP_PATH,
				"hdfs://localhost:9000/user/bizruntime/workspace/OozieExamples/workflow.xml");
		conf.setProperty("jobTracker", "192.168.1.146:8032");
		conf.setProperty("nameNode", "hdfs://localhost:9000");
		conf.setProperty("queueName", "default");

		conf.setProperty("oozie.libpath", "hdfs://localhost:9000/user/bizruntime/share/lib/");
		conf.setProperty("oozie.use.system.libpath", "true");
		conf.setProperty("oozie.wf.rerun.failnodes", "true");

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
		OozieJavaClient cli = new OozieJavaClient();
		cli.test();

	}
}
