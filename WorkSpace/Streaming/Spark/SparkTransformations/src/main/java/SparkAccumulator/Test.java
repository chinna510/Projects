package SparkAccumulator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;

import scala.Tuple2;

public class Test implements Serializable {
	static Logger logger = Logger.getLogger(Test.class);
	public static final Integer[] keys = { 1, 2, 3, 4, 5, 6, 7, 8 };
	public static final Random RND = new Random();

	public static final int MIN_ENTRIES = 4000;
	public static final int MAX_ENTRIES = 10000;

	private static double buildStats(final Integer key) {
		double v = RND.nextGaussian();
		v *= key;
		v += 4 * key;
		return v;
	}

	public void test() {
		SparkConf conf = new SparkConf().setAppName("AccumulatorTest").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		List<Integer> keyList = Arrays.asList(keys);
		JavaRDD<Integer> keys = sc.parallelize(keyList);

		JavaPairRDD<Integer, Double> dataWithStatistics = keys
				.flatMapToPair(new PairFlatMapFunction<Integer, Integer, Double>() {
					public Iterable<Tuple2<Integer, Double>> call(final Integer key) throws Exception {
						List<Tuple2<Integer, Double>> holder = new ArrayList<Tuple2<Integer, Double>>();
						int numberEntries = MIN_ENTRIES + RND.nextInt(MAX_ENTRIES);
						for (int i = 0; i < numberEntries; i++) {
							double stats = buildStats(key);
							holder.add(new Tuple2<Integer, Double>(key, stats));
						}
						return holder;
					}
				});

		JavaPairRDD<Integer, Statistics> generatedStatistics = dataWithStatistics
				.combineByKey(new Function<Double, Statistics>() {
					@Override
					public Statistics call(final Double start) throws Exception {
						return new Statistics(start);
					}
				}, new Function2<Statistics, Double, Statistics>() {
					@Override
					public Statistics call(final Statistics in, final Double added) throws Exception {
						return in.add(added);
					}
				}, new Function2<Statistics, Statistics, Statistics>() {
					@Override
					public Statistics call(final Statistics in, final Statistics added) throws Exception {
						return in.add(added);
					}
				}

		);

		List<Tuple2<Integer, Statistics>> statistics = generatedStatistics.collect();

		for (Tuple2<Integer, Statistics> statistic : statistics) {
			Integer key = statistic._1();
			Statistics value = statistic._2();
			logger.info("key  = " + key);
			logger.info("total values  = " + value.getNumber());
			logger.info("average  = " + String.format("%10.2f", value.getAverage()));
			logger.info("Sd  = " + String.format("%10.2f", value.getStandardDeviation()));
			logger.info("Max  = " + value.getMax());
			logger.info("Min  = " + value.getMin());
			logger.info("================================================");
		}
	}

	public static void main(String[] args) {
		Test te = new Test();
		te.test();
	}

}
