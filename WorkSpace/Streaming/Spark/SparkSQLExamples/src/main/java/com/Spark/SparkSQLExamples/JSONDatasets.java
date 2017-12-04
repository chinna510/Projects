package com.Spark.SparkSQLExamples;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

public class JSONDatasets implements Serializable {

	private static final long serialVersionUID = 3253121385680353837L;

	public void test() {
		SparkConf conf = new SparkConf().setAppName("JSONDATA").setMaster("local");
		JavaSparkContext jssc = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(jssc);
		DataFrame people = sqlContext.read().json("src/main/resources/people.json");
		people.printSchema();
		people.registerTempTable("people");

		DataFrame df = sqlContext.sql("SELECT name from people where age>=13 AND age<=19");
		df.show();
		List<String> jsonData = Arrays
				.asList("{\"name\":\"Yin\",\"address\":{\"city\":\"Columbus\",\"state\":\"Ohio\"}}");
		JavaRDD<String> anotherPeopleRDD = jssc.parallelize(jsonData);
		DataFrame anotherPeople = sqlContext.read().json(anotherPeopleRDD);
		anotherPeople.show();
	}

	public static void main(String[] args) {
		JSONDatasets jd = new JSONDatasets();
		jd.test();
	}
}
