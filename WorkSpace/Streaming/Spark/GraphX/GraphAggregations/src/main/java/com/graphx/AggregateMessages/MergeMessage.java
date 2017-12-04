package com.graphx.AggregateMessages;

import java.io.Serializable;

import scala.Tuple2;
import scala.runtime.AbstractFunction2;

public class MergeMessage extends AbstractFunction2<Tuple2<Integer, Long>, Tuple2<Integer, Long>, Tuple2<Integer, Long>>
		implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Tuple2<Integer, Long> apply(Tuple2<Integer, Long> a, Tuple2<Integer, Long> b) {
		return new Tuple2<Integer, Long>(a._1 + b._1, a._2 + b._2);
	}

}