package com.Spark;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

public class LinesCount {
	static Logger logger = Logger.getLogger(LinesCount.class);

	public void test() {
		SparkConf conf = new SparkConf().setAppName("LinesCount").setMaster("spark://master:7077");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.textFile("inputs/Status.txt");
		JavaRDD<Integer> lineLengths = lines.map(new GetMap());
		int totalLength = lineLengths.reduce(new GetReduce());
		logger.info("Total Length := " + totalLength);
		lineLengths.saveAsTextFile("output/linesCount");
	}

	public static void main(String[] args) {
		LinesCount count = new LinesCount();
		count.test();
	}
}

class GetMap implements Function<String, Integer> {

	@Override
	public Integer call(String str) throws Exception {
		return str.length();
	}

}

class GetReduce implements Function2<Integer, Integer, Integer> {

	@Override
	public Integer call(Integer a, Integer b) throws Exception {

		return a + b;
	}

}