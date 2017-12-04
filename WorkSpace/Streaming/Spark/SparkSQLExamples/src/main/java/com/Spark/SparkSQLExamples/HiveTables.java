package com.Spark.SparkSQLExamples;

import java.io.Serializable;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.hive.HiveContext;

public class HiveTables implements Serializable {
	public void test() {
		SparkConf conf = new SparkConf().setAppName("HiveTables").setMaster("spark://master:7077");
		JavaSparkContext jssc = new JavaSparkContext(conf);
		HiveContext sqlContext = new HiveContext(jssc.sc());
		sqlContext.sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING)");
		sqlContext.sql("LOAD DATA LOCAL INPATH 'examples/src/main/resources/kv1.txt' INTO TABLE src");
		Row[] results = sqlContext.sql("FROM src SELECT key, value").collect();
		
	}

	public static void main(String[] args) {
		HiveTables ht = new HiveTables();
		ht.test();
	}
}
