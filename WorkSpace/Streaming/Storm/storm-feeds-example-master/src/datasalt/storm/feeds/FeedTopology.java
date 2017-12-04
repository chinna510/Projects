
package datasalt.storm.feeds;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.generated.StormTopology;
import backtype.storm.topology.TopologyBuilder;

public class FeedTopology {

	public static StormTopology buildTopology(String[] feeds) {
		TopologyBuilder builder = new TopologyBuilder();

		builder.setSpout("feedSpout", new FeedSpout(feeds), 1);

		builder.setBolt("fetcherBolt", new FetcherBolt(), 2).shuffleGrouping("feedSpout");

		builder.setBolt("listingBolt", new ListingBolt(), 1).globalGrouping("fetcherBolt");

		return builder.createTopology();
	}

	public static void main(String[] args) throws AlreadyAliveException, InvalidTopologyException {
		Config conf = new Config();
		conf.setDebug(true);
		conf.setNumWorkers(2);
		conf.setMaxSpoutPending(1);
		StormSubmitter.submitTopology("feedTopology", conf, buildTopology(Constants.FEEDS));
	}
}
