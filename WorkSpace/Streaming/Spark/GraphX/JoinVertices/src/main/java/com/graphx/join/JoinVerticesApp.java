package com.graphx.join;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.graphx.Edge;
import org.apache.spark.graphx.Graph;
import org.apache.spark.graphx.PartitionStrategy;
import org.apache.spark.storage.StorageLevel;

import scala.Predef;
import scala.Tuple2;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;

public class JoinVerticesApp implements Serializable {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(JoinVerticesApp.class);

	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public void test() throws InterruptedException {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("PropertyGraph");
		JavaSparkContext jssc = new JavaSparkContext(conf);

		List<Tuple2<Object, Double>> vertexlist = new ArrayList<Tuple2<Object, Double>>();
		vertexlist.add(new Tuple2<Object, Double>(1L, 1.0));
		vertexlist.add(new Tuple2<Object, Double>(3L, 3.0));

		vertexlist.add(new Tuple2<Object, Double>(5L, 1.5));

		vertexlist.add(new Tuple2<Object, Double>(7L, 4.0));

		vertexlist.add(new Tuple2<Object, Double>(9L, 6.0));

		JavaRDD vertexRdd = jssc.parallelize(vertexlist);
		List edgeList = new ArrayList<Edge>();
		edgeList.add(new Edge(3, 7, "collab"));
		edgeList.add(new Edge(5, 3, "advisor"));
		edgeList.add(new Edge(1, 5, "colleague"));
		edgeList.add(new Edge(5, 9, "Friend"));

		JavaRDD edgeRdd = jssc.parallelize(edgeList);

		Double defaultuser = 7.5;

		List<Tuple2<Object, Double>> vertexlist2 = new ArrayList<Tuple2<Object, Double>>();
		vertexlist.add(new Tuple2<Object, Double>(6L, 1.0));
		vertexlist.add(new Tuple2<Object, Double>(8L, 3.0));

		vertexlist.add(new Tuple2<Object, Double>(5L, 1.5));

		JavaRDD<Tuple2<Object, Double>> vertexRdd2 = jssc.parallelize(vertexlist2);

		Graph<Double, String> graph = Graph.<Double, String>apply(vertexRdd.rdd(), edgeRdd.rdd(), defaultuser,
				StorageLevel.MEMORY_ONLY(), StorageLevel.MEMORY_ONLY(), ClassTag$.MODULE$.<Double>apply(Double.class),
				ClassTag$.MODULE$.<String>apply(String.class));

		Graph<Double, String> joinGraph1 = graph.ops().joinVertices(vertexRdd2.rdd(), new MapFunction(),
				ClassTag$.MODULE$.apply(Double.class));
		Thread.sleep(1000);
		joinGraph1.vertices().toJavaRDD().foreach(f -> {
			System.out.println(Arrays.asList(f._2));
		});

		log.info(graph.ops().numVertices());

	}

	public static void main(String[] args) throws InterruptedException {
		JoinVerticesApp pr = new JoinVerticesApp();
		pr.test();
	}

}