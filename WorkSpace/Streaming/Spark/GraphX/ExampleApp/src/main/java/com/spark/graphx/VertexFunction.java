package com.spark.graphx;

import java.io.Serializable;

import scala.runtime.AbstractFunction2;

public class VertexFunction extends AbstractFunction2<Object, Object, Object> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object apply(Object id, Object attr) {

		return ((String)attr).split(" ").length == 2;
	}

}
