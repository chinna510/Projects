package com.myudfs;

import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import org.apache.pig.EvalFunc;
import org.apache.pig.FuncSpec;
import org.apache.pig.builtin.DoubleAbs;
import org.apache.pig.builtin.FloatAbs;
import org.apache.pig.builtin.IntAbs;
import org.apache.pig.builtin.LongAbs;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.logicalLayer.schema.Schema;
import org.apache.pig.data.DataType;

public class ABS extends EvalFunc<Double> {
	public Double exec(Tuple input) throws IOException {
		if (input == null || input.size() == 0)
			return null;
		Double d;
		try {
			d = DataType.toDouble(input.get(0));
		} catch (NumberFormatException nfe) {
			System.err.println("Failed to process input; error - " + nfe.getMessage());
			return null;
		} catch (Exception e) {
			throw new IOException("Caught exception processing input row ", e);
		}
		return Math.abs(d);
	}

	public List<FuncSpec> getArgToFuncMapping() throws FrontendException {
		List<FuncSpec> funcList = new ArrayList<FuncSpec>();
		funcList.add(
				new FuncSpec(this.getClass().getName(), new Schema(new Schema.FieldSchema(null, DataType.BYTEARRAY))));
		funcList.add(
				new FuncSpec(DoubleAbs.class.getName(), new Schema(new Schema.FieldSchema(null, DataType.DOUBLE))));
		funcList.add(new FuncSpec(FloatAbs.class.getName(), new Schema(new Schema.FieldSchema(null, DataType.FLOAT))));
		funcList.add(new FuncSpec(IntAbs.class.getName(), new Schema(new Schema.FieldSchema(null, DataType.INTEGER))));
		funcList.add(new FuncSpec(LongAbs.class.getName(), new Schema(new Schema.FieldSchema(null, DataType.LONG))));
		return funcList;
	}
}