package com.storm.kafka.mysql;

import java.util.Map;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class MySqlDumpBolt extends BaseBasicBolt {

	private static final long serialVersionUID = 1L;
	private MySqlDump mySqlDump;

	@Override
	public void prepare(Map stormConf, TopologyContext context) {
		mySqlDump = new MySqlDump();
	}

	public void execute(Tuple input, BasicOutputCollector collector) {
		// TODO Auto-generated method stub
		mySqlDump.persist(input);
		// System.out.println(input);
	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
	

	}

	@Override
	public void cleanup() {
		mySqlDump.close();
	}
}
