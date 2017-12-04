package com.storm.HelloWorld;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class HelloWorldBolt extends BaseRichBolt {
	OutputCollector collector;

	@Override
	public void execute(Tuple tuple) {
		String msg = tuple.getString(0);
		System.out.println("=====before write file=====");
		try {
			File file = new File("/tmp/storm.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(msg + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=====after write file=====");

		collector.emit(new Values("" + msg + "world"));

	}

	@Override
	public void prepare(Map arg0, TopologyContext arg1, OutputCollector collector) {

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("world"));

	}

}
