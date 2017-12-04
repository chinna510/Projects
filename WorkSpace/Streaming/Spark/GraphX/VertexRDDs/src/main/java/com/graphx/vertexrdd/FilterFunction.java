package com.graphx.vertexrdd;

import java.io.Serializable;

import scala.Tuple2;
import scala.runtime.AbstractFunction1;

public class FilterFunction extends AbstractFunction1<Tuple2<Object, Integer>, Object> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object apply(Tuple2<Object, Integer> pred) {

		return pred._2 > 45;
	}

}