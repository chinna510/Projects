package com.Spark.SparkSQLExamples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class ProgrammaticSchema implements Serializable {

	public void test() {

		SparkConf conf = new SparkConf().setAppName("WithoutJavaBean").setMaster("local");
		JavaSparkContext jssc = new JavaSparkContext(conf);
		SQLContext sqlContext = new SQLContext(jssc);
		JavaRDD<String> people = jssc.textFile("src/main/resources/ages.txt");
		String schemaString = "name,age";
		List<StructField> field = new ArrayList<StructField>();
		for (String fieldName : schemaString.split(",")) {
			field.add(DataTypes.createStructField(fieldName, DataTypes.StringType, true));
		}
		StructType schema = DataTypes.createStructType(field);
		JavaRDD<Row> rowRdd = people.map(new Function<String, Row>() {

			public Row call(String record) throws Exception {
				String[] fields = record.split(",");
				return RowFactory.create(fields[0], fields[1].trim());
			}
		});
		DataFrame peopleDataFrame = sqlContext.createDataFrame(rowRdd, schema);
		peopleDataFrame.registerTempTable("people");
		DataFrame results = sqlContext.sql("SELECT name FROM people");
		results.show();
		List<String> names = results.javaRDD().map(new Function<Row, String>() {

			public String call(Row row) throws Exception {

				return "Name : " + row.getString(0);
			}
		}).collect();

	}

	public static void main(String[] args) {

		ProgrammaticSchema pSchema = new ProgrammaticSchema();
		pSchema.test();
	}
}
