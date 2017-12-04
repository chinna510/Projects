package com.Spark.SparkSQLExamples;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.DataFrameWriter;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class DataFrameCreation implements Serializable {

	private static final long serialVersionUID = -9010585191193012732L;
	public static Logger logger = Logger.getLogger(DataFrameCreation.class);

	@SuppressWarnings("serial")
	public void test() {
		SparkConf conf = new SparkConf().setAppName("DataFrame").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(sc);
		JavaRDD<Person> people = sc.textFile("src/main/resources/ages.txt").map(new Function<String, Person>() {

			public Person call(String line) throws Exception {
				String parts[] = line.split(",");
				Person person = new Person();
				person.setName(parts[0]);
				person.setAge(Integer.parseInt(parts[1].trim()));
				return person;
			}
		});
		DataFrame schemaPeople = sqlContext.createDataFrame(people, Person.class);
		schemaPeople.registerTempTable("people");
		DataFrame teenagers = sqlContext.sql("SELECT name FROM people where age>=13 and age <=19");
		List<String> teenagerNames = teenagers.javaRDD().map(new Function<Row, String>() {
			public String call(Row row) {
				return "Name: " + row.getString(0);
			}
		}).collect();
		schemaPeople.show();
		logger.info("Teenagers : " + teenagerNames);
		DataFrameWriter writer = new DataFrameWriter(teenagers);
		writer.save("src/main/resources/out.txt");
		
	}

	public static void main(String[] args) {
		DataFrameCreation dc = new DataFrameCreation();
		dc.test();
	}
}
