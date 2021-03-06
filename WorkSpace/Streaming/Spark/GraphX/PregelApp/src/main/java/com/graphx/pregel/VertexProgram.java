package com.graphx.pregel;

import java.io.Serializable;

import scala.runtime.AbstractFunction3;

public class VertexProgram extends AbstractFunction3<Object, Integer, Integer, Integer> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Integer apply(Object id, Integer dist, Integer newdist) {

		
		System.out.println("Old Dist : " + dist);
		
		System.out.println("New Dist : " + newdist);

		
		return Math.min(dist, newdist);
	}
}
