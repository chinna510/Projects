package com.spout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class DoubleBolt extends BaseRichBolt {
	OutputCollector collector;
	List<Tuple> recievedTuples = new ArrayList<Tuple>(0);

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {

		this.collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		System.out.println(input.getString(0));
		recievedTuples.add(input);
		collector.ack(input);

	}

	public List<Tuple> getRecievedTuples() {
		return recievedTuples;
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

}
