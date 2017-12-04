package com.spark.graphx;

import java.io.Serializable;

import scala.Tuple2;
import scala.runtime.AbstractFunction1;

public class OrderFunction2 extends AbstractFunction1<Tuple2<Object, String>, Object> implements Serializable {

	@Override
	public Object apply(Tuple2<Object, String> tuple) {

		System.out.println(tuple);

		return tuple._2;
	}

}
