package com.storm.wordcount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class LineReaderSpout implements IRichSpout {
	static Logger logger = Logger.getLogger(WordCounterBolt.class);
	private SpoutOutputCollector collector;
	private FileReader fileReader;
	private boolean completed = false;
	private TopologyContext context;

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		try {
			this.context = context;
			this.fileReader = new FileReader(conf.get("inputFile").toString());
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
		this.collector = collector;
	}

	@Override
	public void nextTuple() {
		if (completed) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
			}
		}
		String str;
		BufferedReader reader = new BufferedReader(fileReader);
		try {
			while ((str = reader.readLine()) != null) {
				this.collector.emit(new Values(str), str);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			completed = true;
		}

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("line"));
	}

	@Override
	public void close() {
		try {
			fileReader.close();
		} catch (IOException e) {
			logger.error(e.getMessage());

		}

	}

	public boolean isDistributed() {
		return false;
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ack(Object msgId) {

	}

	@Override
	public void fail(Object msgId) {

	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
