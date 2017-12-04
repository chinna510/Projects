package com.graph.max;

import java.io.Serializable;

import scala.Tuple2;
import scala.runtime.AbstractFunction2;

public class MaxAgeFunction
		extends AbstractFunction2<Tuple2<Object, Object>, Tuple2<Object, Object>, Tuple2<Object, Object>>
		implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Tuple2<Object, Object> apply(Tuple2<Object, Object> a, Tuple2<Object, Object> b) {

		if ((Integer) a._2 > (Integer) b._2)

			return a;
		else
			return b;
	}

}
