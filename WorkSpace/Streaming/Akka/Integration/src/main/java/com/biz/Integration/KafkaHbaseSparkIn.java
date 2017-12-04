package com.biz.Integration;

import java.util.*;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import scala.Tuple2;

public class KafkaHbaseSparkIn {
	static Logger log = Logger.getLogger(KafkaHbaseSparkIn.class.getName());
	static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
	@SuppressWarnings({ "serial", "deprecation" })
	public static void main(String[] args) {
		
		SparkConf sparkConf = new SparkConf().setAppName("spark streaming to HBase").setMaster("local[2]");

		JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, new Duration(5000));

		JavaSparkContext context = jssc.sparkContext();
		Configuration config = HBaseConfiguration.create();

JavaHBaseContext hBaseContext = new JavaHBaseContext(context, config);

		int numThreads = Integer.parseInt(args[3]);
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		String[] topics = args[2].split(",");
		for (String topic : topics) {
			topicMap.put(topic, numThreads);
		}

		JavaPairReceiverInputDStream<String, String> messages = KafkaUtils.createStream(jssc, args[0], args[1],
				topicMap);
		JavaDStream<PersonBean> lines = messages.map(new Function<Tuple2<String, String>, PersonBean>() {
			public PersonBean call(Tuple2<String, String> tuple2) {
				String jsonData = tuple2._2();
				TypeToken<PersonBean> token = new TypeToken<PersonBean>(){};
				PersonBean model = gson.fromJson(jsonData, token.getType());
				return model;
			}

		}
		
		lines.foreach(new Function<JavaRDD<PersonBean>, Void>() {
			public Void call(JavaRDD<PersonBean> personRDD) throws Exception {
				pushRawDataToHBase(hBaseContext, personRDD);
				return null;
			}
		});

		lines.print();
		jssc.start();
	}

	public static void pushRawDataToHBase(JavaHBaseContext hBaseContext, JavaRDD<PersonBean> resultRDD) {
	 
	try{
		hBaseContext.bulkPut(resultRDD, "person", new Function<PersonBean, Put>() {
	 
	private static final long serialVersionUID = 4090513150477943397L;
	//@Override
	@SuppressWarnings("deprecation")
	public Put call(PersonBean dataBean) throws Exception {
		Put put = new Put(Bytes.toBytes(new java.util.Date().getTime()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("UniqueId"), Bytes.toBytes(dataBean.getUid()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("FirstName"), Bytes.toBytes(dataBean.getFirstName()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("LastName"), Bytes.toBytes(dataBean.getLastName()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("City"), Bytes.toBytes(dataBean.getCity()));
		put.add(Bytes.toBytes("details"), Bytes.toBytes("Salary"), Bytes.toBytes(dataBean.getSalary()));
		
		return put;
		}
	}, true);  
	} catch (Exception e) {
		e.printStackTrace();
		  }

	}
}
