package com.spark.graphx;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;

import scala.Option;
import scala.collection.JavaConversions;
import scala.runtime.AbstractFunction0;
import scala.runtime.AbstractFunction3;

public class VertexFunction1 extends AbstractFunction3<Object, Object, Option<Object>, Object> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object apply(Object id, Object old, Option<Object> extra) {
		System.out.println(Arrays.asList(old));

		return extra.getOrElse(new F0());
	}

	class F0 extends AbstractFunction0<Object> {

		@Override
		public Object apply() {
			return JavaConversions.asScalaIterator(Collections.<String>emptyIterator());
		}

	}

}
