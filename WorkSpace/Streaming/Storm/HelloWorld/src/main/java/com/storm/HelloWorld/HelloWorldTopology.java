package com.storm.HelloWorld;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class HelloWorldTopology {
	public void test() throws AlreadyAliveException, InvalidTopologyException {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("Hello", new HelloWorldSpout(), 12);
		builder.setBolt("World", new HelloWorldBolt(), 12).shuffleGrouping("Hello");
		builder.setBolt("WorldTwo", new HelloWorldBolt(), 12).shuffleGrouping("World");

		Config config = new Config();
		config.setDebug(true);
		config.setNumWorkers(6);
		config.setNumAckers(6);
		config.setMaxSpoutPending(100);
		config.setMessageTimeoutSecs(20);
		StormSubmitter.submitTopology("Hello-world", config, builder.createTopology());
		Utils.sleep(10000);

	}

	public static void main(String[] args) throws Exception {
		HelloWorldTopology top = new HelloWorldTopology();
		top.test();
	}
}
