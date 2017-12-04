package com.graphx.edgerdd;

import java.io.Serializable;

import org.apache.spark.graphx.Edge;

import scala.runtime.AbstractFunction1;

public class MapFunction extends AbstractFunction1<Edge<Integer>, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer apply(Edge<Integer> edge) {
		return edge.attr;
	}

}
