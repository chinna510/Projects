package com.graphx.InOutDegrees;

import java.io.Serializable;

import scala.Tuple2;
import scala.runtime.AbstractFunction2;

public class MergeMessage extends AbstractFunction2<Integer, Integer, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer apply(Integer a, Integer b) {

		if (a > b)
			return a;
		return b;
	}

}
