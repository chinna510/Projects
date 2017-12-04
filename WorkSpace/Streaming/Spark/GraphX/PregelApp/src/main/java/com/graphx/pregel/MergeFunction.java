package com.graphx.pregel;

import java.io.Serializable;

import scala.Function1;
import scala.Function2;
import scala.runtime.AbstractFunction2;

public class MergeFunction extends AbstractFunction2<Integer, Integer, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer apply(Integer a, Integer b) {
		System.out.println("merge a" + a + " b " + b);

		return Math.min(a, b);
	}

}