package com.graphx.InOutDegrees;

import java.io.Serializable;

import org.apache.spark.graphx.EdgeContext;

import scala.Tuple2;
import scala.runtime.AbstractFunction1;
import scala.runtime.BoxedUnit;

public class SendMessage extends AbstractFunction1<EdgeContext<Integer, Integer, Integer>, BoxedUnit>
		implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public BoxedUnit apply(EdgeContext<Integer, Integer, Integer> triplet) {

		triplet.sendToDst(triplet.srcAttr());

		return BoxedUnit.UNIT;
	}

}
