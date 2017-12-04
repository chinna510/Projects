package com.graphx.vertexrdd;

import java.io.Serializable;

import scala.runtime.AbstractFunction2;

public class AggregateFunction extends AbstractFunction2<Integer, Integer, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer apply(Integer old, Integer extra) {

		return Math.min(old, extra);
	}

}
