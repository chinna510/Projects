package com.storm.wordcount;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;

public class WordCounterBolt implements IRichBolt{
	static Logger logger=Logger.getLogger(WordCounterBolt.class);
	Integer id;
	String name;
	Map<String, Integer> counters;
	private OutputCollector collector;
	
	@Override
	public void prepare(Map stormConf, TopologyContext context,
			OutputCollector collector) {
		this.counters = new HashMap<String, Integer>();
		this.collector = collector;
		this.name = context.getThisComponentId();
		this.id = context.getThisTaskId();
		
	}

	@Override
	public void execute(Tuple input) {
		String str = input.getString(0);
		if(!counters.containsKey(str)){
			counters.put(str, 1);
		}else{
			Integer c = counters.get(str) +1;
			counters.put(str, c);
		}
		collector.ack(input);
	}

	@Override
	public void cleanup() {
		logger.debug(" -- Word Counter ["+ name + "-"+id +"]");
		for(Map.Entry<String, Integer> entry:counters.entrySet()){
			logger.debug("Word : "+entry.getKey()+";    count: " + entry.getValue());
		}
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		
		return null;
	}
}
