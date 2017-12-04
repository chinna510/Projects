package com.Spark;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class WordCount implements Serializable {
	static Logger logger = Logger.getLogger(WordCount.class);

	public void test() {

		SparkConf conf = new SparkConf().setAppName("WordCount").setMaster("spark://master:7077");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> textFile = sc.textFile("inputs/Status.txt");
		JavaRDD<String> words = textFile.flatMap(new FlatMapFunction<String, String>() {

			public Iterable<String> call(String s) throws Exception {

				return Arrays.asList(s.split(" "));
			}
		});
		JavaPairRDD<String, Integer> pair = words.mapToPair(new PairFunction<String, String, Integer>() {

			public Tuple2<String, Integer> call(String s) throws Exception {

				return new Tuple2<String, Integer>(s, 1);
			}
		});
		JavaPairRDD<String, Integer> count = pair.reduceByKey(new Function2<Integer, Integer, Integer>() {

			public Integer call(Integer a, Integer b) throws Exception {

				return a + b;
			}
		});
		List<Tuple2<String, Integer>> pairs = count.collect();
		count.saveAsTextFile("output/wordcount");

	}

	public static void main(String[] args) {
		WordCount wc = new WordCount();
		wc.test();
	}

}
