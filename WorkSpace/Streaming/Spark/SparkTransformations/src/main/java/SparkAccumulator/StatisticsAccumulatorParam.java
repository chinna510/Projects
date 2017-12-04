package SparkAccumulator;

import java.io.Serializable;

import org.apache.spark.AccumulatorParam;

public class StatisticsAccumulatorParam implements AccumulatorParam<Statistics>, Serializable {
	StatisticsAccumulatorParam() {
	}

	@Override
	public Statistics addInPlace(Statistics r, Statistics t) {
		return r.add(t);

	}

	@Override
	public Statistics zero(Statistics initialValue) {
		return Statistics.ZERO.add(initialValue);
	}

	@Override
	public Statistics addAccumulator(Statistics r, Statistics t) {
		return r.add(t);
	}

}
