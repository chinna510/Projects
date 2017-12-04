package com.spout;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class Topology {
	public static void main(String[] args) {

		final TopologyBuilder builder = new TopologyBuilder();

		Spout1 aSpout = new Spout1();
		Spout2 bSpout = new Spout2();
		builder.setSpout("aSpout", aSpout);
		builder.setSpout("bSpout", bSpout);
		DoubleBolt dInputBolt = new DoubleBolt();
		builder.setBolt("doubleInBolt", dInputBolt, 5).shuffleGrouping("aSpout").shuffleGrouping("bSpout");
		final Config conf = new Config();

		final LocalCluster cluster = new LocalCluster();

		cluster.submitTopology("doubleInTest", conf, builder.createTopology());

		Utils.sleep(5000);
		cluster.shutdown();

		System.out.println("A-Tuples emitted: " + aSpout.getEmittedTuples().size());
		System.out.println("B-Tuples emitted: " + bSpout.getEmittedTuples().size());
		System.out.println("Bolt received: " + dInputBolt.getRecievedTuples().size());

	}
}
