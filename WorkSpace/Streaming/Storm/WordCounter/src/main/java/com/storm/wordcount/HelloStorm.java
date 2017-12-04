package com.storm.wordcount;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.AuthorizationException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class HelloStorm {
	public void test() throws AlreadyAliveException, InvalidTopologyException, AuthorizationException {
		Config config = new Config();
		config.put(Config.STORM_ZOOKEEPER_SERVERS, "192.168.1.54");
		config.put(Config.STORM_ZOOKEEPER_PORT, 2181);
		config.put(Config.NIMBUS_HOST, "192.168.1.54");
		config.put(Config.NIMBUS_THRIFT_PORT, 6627);

		config.put("inputFile", "src/main/resources/input.txt");
		config.setDebug(true);
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("line-reader-spout", new LineReaderSpout(), 12);
		builder.setBolt("word-spitter", new WordSpitterBolt(), 12).shuffleGrouping("line-reader-spout");
		builder.setBolt("word-counter", new WordCounterBolt(), 12).shuffleGrouping("word-spitter");
		config.setNumWorkers(6);
		config.setNumAckers(6);
		config.setMaxSpoutPending(100);
		config.setMessageTimeoutSecs(20);
		StormSubmitter.submitTopology("hello", config, builder.createTopology());
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("Word-count", config, builder.createTopology());
		Utils.sleep(10000);
		cluster.killTopology("Word-count");
		cluster.shutdown();
	}

	public static void main(String[] args) throws Exception {
		HelloStorm he = new HelloStorm();
		he.test();
	}

}
