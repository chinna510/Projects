package com.graphx.vertexrdd;

import java.io.Serializable;

import scala.runtime.AbstractFunction3;

public class InnerJoinFunction extends AbstractFunction3<Object, Integer, Integer, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer apply(Object id, Integer old, Integer next) {

		return old + next;
	}

}