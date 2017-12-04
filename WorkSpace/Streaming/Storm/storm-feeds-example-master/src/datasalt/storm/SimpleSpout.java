
package datasalt.storm;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.OutputFieldsDeclarer;

@SuppressWarnings("rawtypes")
public class SimpleSpout implements IRichSpout {

	

	protected SpoutOutputCollector collector;
	Map conf;
	TopologyContext context;

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.collector = collector;
		this.conf = conf;
		this.context = context;
	}

	@Override
	public void close() {
	}

	@Override
	public void nextTuple() {
	}

	@Override
	public void ack(Object msgId) {
	}

	@Override
	public void fail(Object msgId) {
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {

	}

	@Override
	public boolean isDistributed() {
		return true;
	}
}
