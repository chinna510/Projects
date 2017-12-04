package com.graphx.withString;

import java.io.Serializable;
import java.util.Arrays;

import scala.Option;
import scala.runtime.AbstractFunction0;
import scala.runtime.AbstractFunction3;

public class VertexFunction extends AbstractFunction3<Object, String[], Option<String[]>, String[]>
		implements Serializable {

	@Override
	public String[] apply(Object id, String[] old, Option<String[]> extra) {
		System.out.println(Arrays.asList(old));
		if(extra.isEmpty())
			return old;
		return  extra.getOrElse(new F0());
	}

	class F0 extends AbstractFunction0<String[]> {

		@Override
		public String[] apply() {
			return new String[] { "vijay", "bizruntime" };
		}

	}

}
