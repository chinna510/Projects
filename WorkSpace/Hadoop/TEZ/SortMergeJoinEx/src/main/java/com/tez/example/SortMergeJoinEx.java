package com.tez.example;

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
import org.apache.tez.dag.api.ProcessorDescriptor;
import org.apache.tez.dag.api.TezConfiguration;
import org.apache.tez.dag.api.Vertex;
import org.apache.tez.dag.library.vertexmanager.ShuffleVertexManager;
import org.apache.tez.mapreduce.input.MRInput;
import org.apache.tez.mapreduce.output.MROutput;
import org.apache.tez.runtime.library.conf.OrderedPartitionedKVEdgeConfig;
import org.apache.tez.runtime.library.partitioner.HashPartitioner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortMergeJoinEx extends TezExampleBase {

	private static final String inputFile = "inputFile";
	private static final String joiner = "joiner";
	private static final String joinOutput = "joinOutput";
	private static Logger logger = LoggerFactory.getLogger(SortMergeJoinEx.class);

	@Override
	protected void printUsage() {
		logger.error("Usage:sortmergejoin <file1> <file2> <numPartitions> <outPath>");
	}

	@Override
	protected int validateArgs(String[] otherArgs) {
		if (otherArgs.length != 4) {
			return 2;
		}
		return 0;
	}

	@Override
	protected int runJob(String[] args, TezConfiguration tezConf, TezClient tezClient) throws Exception {
		String inputDir1 = args[0];
		String inputDir2 = args[1];
		int numPartitions = Integer.parseInt(args[2]);
		String outputDir = args[3];
		Path inputpath1 = new Path(inputDir1);
		Path inputpath2 = new Path(inputDir2);
		Path outputpath = new Path(outputDir);

		FileSystem fs = FileSystem.get(tezConf);
		if (fs.exists(outputpath)) {
			logger.error("Output Directory  " + outputDir + " Already Exists");
			return 3;
		}
		if (numPartitions <= 0) {
			logger.error("should have partitions <=0");
			return 4;
		}
		DAG dag = createDag(tezConf, inputpath1, inputpath2, numPartitions, outputpath);
		logger.info("SortMergeJoinExample Running .....");
		return runDag(dag, isCountersLog(), logger);

	}

	private DAG createDag(TezConfiguration tezConf, Path inputpath1, Path inputpath2, int numPartitions,
			Path outputpath) {
		DAG dag = DAG.create("SortMergeJoin");
		DataSourceDescriptor dataSource1 = MRInput
				.createConfigBuilder(new Configuration(tezConf), TextInputFormat.class, inputpath1.toUri().toString())
				.groupSplits(isDisableSplitGrouping()).generateSplitsInAM(isGenerateSplitInClient()).build();
		DataSourceDescriptor dataSource2 = MRInput
				.createConfigBuilder(new Configuration(tezConf), TextInputFormat.class, inputpath2.toUri().toString())
				.groupSplits(isDisableSplitGrouping()).generateSplitsInAM(isGenerateSplitInClient()).build();
		DataSinkDescriptor dataSink = MROutput
				.createConfigBuilder(new Configuration(tezConf), TextOutputFormat.class, outputpath.toUri().toString())
				.build();

		Vertex vertex1 = Vertex.create("input1", ProcessorDescriptor.create(ForwardingProcessor.class.getName()))
				.addDataSource(inputFile, dataSource1);
		Vertex vertex2 = Vertex.create("input2", ProcessorDescriptor.create(ForwardingProcessor.class.getName()))
				.addDataSource(inputFile, dataSource2);
		Vertex joinVertex = Vertex
				.create(joiner, ProcessorDescriptor.create(SortMergeJoinProcessor.class.getName()), numPartitions)
				.setVertexManagerPlugin(
						ShuffleVertexManager.createConfigBuilder(tezConf).setAutoReduceParallelism(true).build())
				.addDataSink(joinOutput, dataSink);
		OrderedPartitionedKVEdgeConfig edgeConf = OrderedPartitionedKVEdgeConfig
				.newBuilder(Text.class.getName(), NullWritable.class.getName(), HashPartitioner.class.getName())
				.setFromConfiguration(tezConf).build();
		Edge e1 = Edge.create(vertex1, joinVertex, edgeConf.createDefaultEdgeProperty());
		Edge e2 = Edge.create(vertex2, joinVertex, edgeConf.createDefaultEdgeProperty());
		dag.addVertex(vertex1).addVertex(vertex2).addVertex(joinVertex).addEdge(e1).addEdge(e2);
		return dag;
	}

	public static void main(String[] args) throws Exception {
		SortMergeJoinEx smJoin = new SortMergeJoinEx();
		int status = ToolRunner.run(smJoin, args);
		System.exit(status);
	}

}
