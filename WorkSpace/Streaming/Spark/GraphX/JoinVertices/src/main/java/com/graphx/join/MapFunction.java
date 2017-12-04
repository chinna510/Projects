package com.graphx.join;

import java.io.Serializable;
import java.util.Arrays;

import scala.Option;
import scala.runtime.AbstractFunction0;
import scala.runtime.AbstractFunction3;

public class MapFunction extends AbstractFunction3<Object, Double, Double, Double> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Double apply(Object id, Double old, Double extra) {

		return old + extra;
	}

}
