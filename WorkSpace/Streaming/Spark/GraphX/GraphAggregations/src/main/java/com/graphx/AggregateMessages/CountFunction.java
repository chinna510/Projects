package com.graphx.AggregateMessages;

import java.io.Serializable;

import scala.Tuple2;
import scala.runtime.AbstractFunction1;

public class CountFunction extends AbstractFunction1<Tuple2<Integer, Long>, Double> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Double apply(Tuple2<Integer, Long> tuple) {
		int count = tuple._1;
		long totalAge = tuple._2;

		return (double) (totalAge / count);
	}

}