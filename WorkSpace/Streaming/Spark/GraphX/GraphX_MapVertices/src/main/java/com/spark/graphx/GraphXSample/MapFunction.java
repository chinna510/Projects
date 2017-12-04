package com.spark.graphx.GraphXSample;

import java.io.Serializable;

import scala.runtime.AbstractFunction2;

public class MapFunction extends AbstractFunction2<Object, String[], String[]> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] apply(Object id, String[] attr) {
		for(String s: attr)
			System.out.println(s);
		return  new String[]{"Vijay",""};
	}

}
