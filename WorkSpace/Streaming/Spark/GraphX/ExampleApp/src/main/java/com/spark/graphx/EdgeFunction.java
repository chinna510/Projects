package com.spark.graphx;

import java.io.Serializable;

import org.apache.spark.graphx.EdgeTriplet;

import scala.runtime.AbstractFunction1;

public class EdgeFunction extends AbstractFunction1<EdgeTriplet<Object, Object>, Object> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object apply(EdgeTriplet<Object, Object> id) {

		return true;
	}

}