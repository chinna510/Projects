package com.graph.max;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.graphx.Edge;
import org.apache.spark.graphx.Graph;
import org.apache.spark.graphx.TripletFields;
import org.apache.spark.graphx.VertexRDD;
import org.apache.spark.graphx.util.GraphGenerators;
import org.apache.spark.storage.StorageLevel;

import scala.Tuple2;
import scala.reflect.ClassTag;
import scala.reflect.ClassTag$;

public class MaxAgeFinder implements Serializable {

	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(MaxAgeFinder.class);

	@SuppressWarnings("unchecked")
	public void test() throws InterruptedException {

		SparkConf conf = new SparkConf().setMaster("local").setAppName("PropertyGraph");
		JavaSparkContext jssc = new JavaSparkContext(conf);

		List<Tuple2<Object, Integer>> vertexlist = new ArrayList<Tuple2<Object, Integer>>();
		vertexlist.add(new Tuple2<Object, Integer>(1L, 22));
		vertexlist.add(new Tuple2<Object, Integer>(3L, 25));

		vertexlist.add(new Tuple2<Object, Integer>(5L, 43));

		vertexlist.add(new Tuple2<Object, Integer>(7L, 42));

		vertexlist.add(new Tuple2<Object, Integer>(9L, 67));

		JavaRDD vertexRdd = jssc.parallelize(vertexlist);

		List edgeList = new ArrayList();
		edgeList.add(new Edge(3, 5, 22));
		edgeList.add(new Edge(5, 3, 25));
		edgeList.add(new Edge(1, 5, 43));
		edgeList.add(new Edge(5, 9, 35));
		edgeList.add(new Edge(7, 3, 35));

		JavaRDD edgeRdd = jssc.parallelize(edgeList);

		Integer defaultuser = 11;

		Graph<Integer, Integer> graph = Graph.apply(vertexRdd.rdd(), edgeRdd.rdd(), defaultuser,
				StorageLevel.MEMORY_ONLY(), StorageLevel.MEMORY_ONLY(), ClassTag$.MODULE$.<Integer>apply(Integer.class),
				ClassTag$.MODULE$.<String>apply(Integer.class));

		Tuple2<Object, Object> inDegree = graph.ops().<Integer>inDegrees().reduce(new MaxAgeFunction());
		Tuple2<Object, Object> outDegree = graph.ops().outDegrees().reduce(new MaxAgeFunction());

		Tuple2<Object, Object> Degrees = graph.ops().degrees().reduce(new MaxAgeFunction());

		log.info("In Degrees : " + graph.ops().inDegrees().toJavaRDD().map(e ->

		{
			log.info("Graph InDegrees : -- >" + new Tuple2<Object, Object>(e._1, e._2));
			return e;

		}).count());

		log.info("Maximux InDegree : " + inDegree);

		log.info("Graph OutDegrees : " + graph.ops().outDegrees().toJavaRDD().map(e ->

		{
			log.info("Graph OutDegrees : -- >" + new Tuple2<Object, Object>(e._1, e._2));
			return e;

		}).count());

		log.info("Maximum Degree : " + outDegree);

		log.info("Graph OutDegrees : " + graph.ops().degrees().toJavaRDD().map(e ->

		{
			log.info("Graph Degrees : -- >" + new Tuple2<Object, Object>(e._1, e._2));
			return e;

		}).count());

		log.info("Maximum Degrees : " + Degrees);

	}

	public static void main(String[] args) throws InterruptedException {
		MaxAgeFinder pr = new MaxAgeFinder();
		pr.test();
	}

}
