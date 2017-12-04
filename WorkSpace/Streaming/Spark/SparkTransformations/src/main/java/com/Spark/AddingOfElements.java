package com.Spark;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AddingOfElements {
	static Logger logger = Logger.getLogger(AddingOfElements.class);

	public void test() {

		SparkConf conf = new SparkConf().setAppName("Addition").setMaster("spark://master:7077");
		JavaSparkContext sc = new JavaSparkContext(conf);
		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6);
		JavaRDD<Integer> distData = sc.parallelize(data);
		Integer count = distData.reduce((a, b) -> a + b);
		logger.info("Total Of Elements : " + count);

	}

	public static void main(String[] args) {
		AddingOfElements add = new AddingOfElements();
		add.test();
	}

}
