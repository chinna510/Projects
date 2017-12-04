package com.Spark.SparkSQLExamples;

import java.io.Serializable;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class DataFrameOperations implements Serializable {
	private static final long serialVersionUID = 1L;

	public void test() {
		SparkConf conf = new SparkConf().setAppName("DataFrameOperations").setMaster("local");
		JavaSparkContext jssc = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(jssc);
		DataFrame df = sqlContext.read().json("src/main/resources/people.json");
		df.show();
		df.printSchema();
		df.count();
		df.select("name").show();
		df.select(df.col("name"), df.col("age").plus(1)).show();
		df.filter(df.col("age").gt(17)).show();
		df.groupBy("age").count().show();
		// Load And Save Functions of SparkSQL

		DataFrame df1 = sqlContext.read().load("src/main/resources/users.parquet");
		df1.select("name", "favorite_color").write().save("src/main/resources/namesAndFavColors.parquet");

		DataFrame df2 = sqlContext.read().format("json").load("src/main/resources/people.json");
		df2.select("name", "age").write().format("parquet").save("namesAndAges.parquet");
		
		DataFrame df3 = sqlContext.sql("SELECT * FROM parquet.`src/main/resources/users.parquet`");
		df3.show();

	}

	public static void main(String[] args) {
		DataFrameOperations dfo = new DataFrameOperations();
		dfo.test();
	}

}
