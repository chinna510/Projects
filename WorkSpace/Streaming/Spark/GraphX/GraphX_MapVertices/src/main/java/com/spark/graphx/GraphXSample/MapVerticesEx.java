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
import scala.reflect.ClassTag$;

public class MapVerticesEx implements Serializable {

	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(MapVerticesEx.class);

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

		Graph<String[], String> graph1 = graph.<String[]>mapVertices(new MapFunction(),
				ClassTag$.MODULE$.apply(String[].class), Predef.$eq$colon$eq$.MODULE$.tpEquals());

		graph1.vertices().toJavaRDD().foreach(f -> {
			for (String s : f._2)
				System.out.println(s);
		});
		
		log.info("No Of Vertices : " + graph1.vertices().count());
		log.info("No Of Vertices : " + graph1.ops().numEdges());

	}

	public static void main(String[] args) {
		MapVerticesEx pr = new MapVerticesEx();
		pr.test();
	}

}
