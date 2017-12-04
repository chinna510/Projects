package com.spark.graphx.GraphXSample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.graphx.Edge;
import org.apache.spark.graphx.Graph;
import org.apache.spark.storage.StorageLevel;

import scala.Predef;
import scala.Tuple2;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;

public class Mask implements Serializable {

	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(Mask.class);

	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public void test() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("PropertyGraph");
		JavaSparkContext jssc = new JavaSparkContext(conf);

		List<Tuple2<Object, String[]>> list = new ArrayList<Tuple2<Object, String[]>>();
		list.add(new Tuple2<Object, String[]>(1L, new String[] { "Chinna", "Student" }));
		list.add(new Tuple2<Object, String[]>(3L, new String[] { "JP", "Employee" }));
		list.add(new Tuple2<Object, String[]>(5L, new String[] { "Richard", "Worker" }));
		list.add(new Tuple2<Object, String[]>(7L, new String[] { "Narendra", "Professional" }));

		JavaRDD users = jssc.parallelize(list);
		List list2 = new ArrayList<Edge>();
		list2.add(new Edge(3, 7, "collab"));
		list2.add(new Edge(5, 3, "advisor"));
		list2.add(new Edge(1, 5, "colleague"));
		list2.add(new Edge(5, 9, "Friend"));

		JavaRDD relationships = jssc.parallelize(list2);

		String[] defaultuser = new String[] { "defaultuser", "default" };

		Graph<String[], String> graph = Graph.<String[], String>apply(users.rdd(), relationships.rdd(), defaultuser,
				StorageLevel.MEMORY_ONLY(), StorageLevel.MEMORY_ONLY(),
				ClassTag$.MODULE$.<String[]>apply(String[].class), ClassTag$.MODULE$.<String>apply(String.class));

		Graph<String[], String> subGraph = graph.subgraph(new EdgeFunction(), new VertexFunction());

		List<Tuple2<Object, String[]>> SubgraphList = subGraph.<String>vertices().toJavaRDD().collect();

		SubgraphList.forEach((tuple) -> {

			log.info(tuple._1);
			for (String s : tuple._2)
				log.info(s);
		});

		Graph<String[], String> maskGraph = graph.mask(subGraph, ClassTag$.MODULE$.apply(String[].class),
				ClassTag$.MODULE$.apply(String.class));

		List<Tuple2<Object, String[]>> maskList = maskGraph.vertices().toJavaRDD().collect();

		maskList.forEach((tuple) -> {

			log.info(tuple._1);
			for (String s : tuple._2)
				log.info(s);
		});

	}

	public static void main(String[] args) {
		Mask pr = new Mask();
		pr.test();
	}

}
