package com.biz.KafkaStorm;

import org.apache.log4j.Logger;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

@SuppressWarnings("serial")
public class PrinterBolt extends BaseBasicBolt {
	static Logger logger = Logger.getLogger(PrinterBolt.class);

	public void execute(Tuple tuple, BasicOutputCollector collector) {

		logger.info("Tuple Info :"+tuple.toString());

	}
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

}
