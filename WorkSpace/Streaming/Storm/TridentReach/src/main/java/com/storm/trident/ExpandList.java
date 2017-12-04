package com.storm.trident;

import java.util.*;

import backtype.storm.tuple.Values;
import storm.trident.operation.BaseFunction;
import storm.trident.operation.TridentCollector;
import storm.trident.tuple.TridentTuple;

@SuppressWarnings("serial")
public class ExpandList extends BaseFunction {

	@Override
	public void execute(TridentTuple tuple, TridentCollector collector) {
		List l = (List) tuple.getValue(0);
		if (l != null) {
			for (Object o : l) {
				collector.emit(new Values(o));
			}
		}
	}

}