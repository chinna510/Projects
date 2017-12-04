package com.tez.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.ToolRunner;
import org.apache.tez.client.TezClient;
import org.apache.tez.dag.api.DAG;
import org.apache.tez.dag.api.DataSinkDescriptor;
import org.apache.tez.dag.api.DataSourceDescriptor;
import org.apache.tez.dag.api.Edge;
import org.apache.tez.dag.api.EdgeProperty;
import org.apache.tez.dag.api.ProcessorDescriptor;
import org.apache.tez.dag.api.TezConfiguration;
import org.apache.tez.dag.api.Vertex;
import org.apache.tez.mapreduce.input.MRInput;
import org.apache.tez.mapreduce.output.MROutput;
import org.apache.tez.runtime.library.conf.UnorderedKVEdgeConfig;
import org.apache.tez.runtime.library.conf.UnorderedPartitionedKVEdgeConfig;
import org.apache.tez.runtime.library.partitioner.HashPartitioner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashJoinsEx extends TezExampleBase {
	private static final String broadcastOption = "doBroadcast";
	private static final String streamingSide = "streamingSide";
	private static final String hashSide = "hashSide";
	private static final String inputFile = "inputFile";
	private static final String joiner = "joiner";
	private static final String joinOutput = "joinOutput";
	private static final Logger LOG = LoggerFactory.getLogger(HashJoinsEx.class);

	public static void main(String[] args) throws Exception {
		HashJoinsEx job = new HashJoinsEx();
		int status = ToolRunner.run(new Configuration(), job, args);
		System.exit(status);
	}

	protected void printUsage() {
		LOG.error("Usage: " + "hashjoin <file1> <file2> <numPartitions> <outPath> [" + broadcastOption
				+ "(default false)]");
	}

	@Override
	protected int runJob(String[] args, TezConfiguration tezConf, TezClient tezClient) throws Exception {
		boolean doBroadcast = args.length == 5 && args[4].equals(broadcastOption) ? true : false;
		LOG.info("Running HashJoinExample" + (doBroadcast ? "-WithBroadcast" : ""));

		String streamInputDir = args[0];
		String hashInputDir = args[1];
		int numPartitions = Integer.parseInt(args[2]);
		String outputDir = args[3];
		Path streamInputPath = new Path(streamInputDir);
		Path hashInputPath = new Path(hashInputDir);
		Path outputPath = new Path(outputDir);
		FileSystem fs = FileSystem.get(tezConf);
		if (fs.exists(outputPath)) {
			LOG.error("Output directory: " + outputDir + " already exists");
			return 3;
		}
		if (numPartitions <= 0) {
			LOG.error("NumPartitions must be > 0");
			return 4;
		}
		DAG dag = CreateDag(tezConf, streamInputPath, hashInputPath, outputPath, numPartitions, doBroadcast);
		return runDag(dag, isCountersLog(), LOG);
	}

	private DAG CreateDag(TezConfiguration tezConf, Path streamInputPath, Path hashInputPath, Path outputPath,
			int numPartitions, boolean doBroadcast) {
		DAG dag = DAG.create("HashJoins" + (doBroadcast ? "-WithBroadCast" : " "));
		DataSourceDescriptor dataSource = MRInput
				.createConfigBuilder(new Configuration(tezConf), TextInputFormat.class,
						hashInputPath.toUri().toString())
				.groupSplits(!isDisableSplitGrouping()).generateSplitsInAM(!isGenerateSplitInClient()).build();
		DataSourceDescriptor dataSource1 = MRInput
				.createConfigBuilder(new Configuration(tezConf), TextInputFormat.class,
						streamInputPath.toUri().toString())
				.groupSplits(!isDisableSplitGrouping()).generateSplitsInAM(!isGenerateSplitInClient()).build();
		DataSinkDescriptor dataSink = MROutput
				.createConfigBuilder(new Configuration(tezConf), TextOutputFormat.class, outputPath.toUri().toString())
				.build();
		Vertex hashVertex = Vertex.create(hashSide, ProcessorDescriptor.create(ForwardingProcessor.class.getName()))
				.addDataSource(inputFile, dataSource);
		Vertex streamVertex = Vertex
				.create(streamingSide, ProcessorDescriptor.create(ForwardingProcessor.class.getName()))
				.addDataSource(inputFile, dataSource1);

		Vertex joinVertex = Vertex
				.create(joiner, ProcessorDescriptor.create(HashJoinProcessor.class.getName()), numPartitions)
				.addDataSink(joinOutput, dataSink);

		UnorderedPartitionedKVEdgeConfig streamConf = UnorderedPartitionedKVEdgeConfig
				.newBuilder(Text.class.getName(), NullWritable.class.getName(), HashPartitioner.class.getName())
				.setFromConfiguration(tezConf).build();
		Edge e1 = Edge.create(streamVertex, joinVertex, streamConf.createDefaultEdgeProperty());

		EdgeProperty hashSideEdgeProperty = null;
		if (doBroadcast) {
			UnorderedKVEdgeConfig broadcastConf = UnorderedKVEdgeConfig
					.newBuilder(Text.class.getName(), NullWritable.class.getName()).setFromConfiguration(tezConf)
					.build();
			hashSideEdgeProperty = broadcastConf.createDefaultBroadcastEdgeProperty();

		} else {
			hashSideEdgeProperty = streamConf.createDefaultEdgeProperty();

		}
		Edge e2 = Edge.create(hashVertex, joinVertex, hashSideEdgeProperty);
		dag.addVertex(streamVertex).addVertex(hashVertex).addVertex(joinVertex).addEdge(e1).addEdge(e2);
		return dag;

	}

	@Override
	protected int validateArgs(String[] otherArgs) {
		if (!(otherArgs.length == 4 || otherArgs.length == 5)) {
			return 2;
		}
		return 0;

	}

}