package com.storm.trident;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backtype.storm.task.IMetricsContext;
import storm.trident.state.ReadOnlyState;
import storm.trident.state.State;
import storm.trident.state.StateFactory;
import storm.trident.state.map.ReadOnlyMapState;

public class StaticSingleKeyMapState extends ReadOnlyState implements ReadOnlyMapState<Object> {
	@SuppressWarnings("serial")
	public static class Factory implements StateFactory {
		Map _map;

		@SuppressWarnings("rawtypes")
		public Factory(Map map) {
			_map = map;
		}

		@Override
		public State makeState(Map conf, IMetricsContext metrics, int partitionIndex, int numPartitions) {
			return new StaticSingleKeyMapState(_map);
		}

	}

	Map _map;

	public StaticSingleKeyMapState(Map map) {
		_map = map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Object> multiGet(List<List<Object>> keys) {
		List<Object> ret = new ArrayList();
		for (List<Object> key : keys) {
			Object singleKey = key.get(0);
			ret.add(_map.get(singleKey));
		}
		return ret;
	}

}