
/*Arguments to pass 
192.168.1.146:9092 topicname
*/

package com.Spark.SparkStreamingEx;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import kafka.serializer.StringDecoder;
import scala.Tuple2;

public class JavaDirectKafkaWordCount implements Serializable {
	String brokers;
	String topics;

	public JavaDirectKafkaWordCount(String brokers, String topics) {
		super();
		this.brokers = brokers;
		this.topics = topics;
	}

	@SuppressWarnings("serial")
	public void test() {
		SparkConf conf = new SparkConf().setAppName("JavaDirectKafkaWordCount").setMaster("local[*]");
		JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(2));
		Set<String> topicSet = new HashSet<String>(Arrays.asList(topics.split(",")));
		Map<String, String> kafkaparams = new HashMap<String, String>();
		kafkaparams.put("bootstrap.servers", brokers);
		JavaPairInputDStream<String, String> messages = KafkaUtils.createDirectStream(jssc, String.class, String.class,
				StringDecoder.class, StringDecoder.class, kafkaparams, topicSet);
		JavaDStream<String> lines = messages.map(new Function<Tuple2<String, String>, String>() {
			@Override
			public String call(Tuple2<String, String> tuple2) {
				return tuple2._2();
			}
		});
		JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {

			@Override
			public Iterable<String> call(String x) throws Exception {

				return Arrays.asList(x.split(" "));

			}
		});
		JavaPairDStream<String, Integer> wordCounts = words.mapToPair(new PairFunction<String, String, Integer>() {
			@Override
			public Tuple2<String, Integer> call(String s) {
				return new Tuple2<>(s, 1);
			}
		}).reduceByKey(new Function2<Integer, Integer, Integer>() {

			@Override
			public Integer call(Integer v1, Integer v2) throws Exception {

				return v1 + v2;
			}
		});

		wordCounts.print();
		jssc.start();
		jssc.awaitTermination();
	}

	public static void main(String[] args) {

		JavaDirectKafkaWordCount count = new JavaDirectKafkaWordCount(args[0], args[1]);
		count.test();

	}
}