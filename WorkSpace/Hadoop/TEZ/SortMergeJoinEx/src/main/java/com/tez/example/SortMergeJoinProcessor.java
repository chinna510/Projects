package com.tez.example;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.tez.mapreduce.processor.SimpleMRProcessor;
import org.apache.tez.runtime.api.LogicalInput;
import org.apache.tez.runtime.api.LogicalOutput;
import org.apache.tez.runtime.api.ProcessorContext;
import org.apache.tez.runtime.api.Reader;
import org.apache.tez.runtime.library.api.KeyValueWriter;
import org.apache.tez.runtime.library.api.KeyValuesReader;

import com.google.common.base.Preconditions;

public class SortMergeJoinProcessor extends SimpleMRProcessor {

	private static final String input1 = "input1";
	private static final String input2 = "input2";
	private static final String joinOutput = "joinOutput";

	public SortMergeJoinProcessor(ProcessorContext context) {
		super(context);

	}

	@Override
	public void run() throws Exception {
		Preconditions.checkState(getInputs().size() == 2);
		Preconditions.checkState(getOutputs().size() == 1);
		LogicalInput logicalInput1 = getInputs().get(input1);
		LogicalInput logicalInput2 = getInputs().get(input2);
		Reader reader1 = logicalInput1.getReader();
		Reader reader2 = logicalInput2.getReader();
		Preconditions.checkState(reader1 instanceof KeyValuesReader);
		Preconditions.checkState(reader2 instanceof KeyValuesReader);
		LogicalOutput lo = getOutputs().get(joinOutput);
		Preconditions.checkState(lo.getWriter() instanceof KeyValueWriter);
		KeyValueWriter writer = (KeyValueWriter) lo.getWriter();

		join((KeyValuesReader) reader1, (KeyValuesReader) reader2, writer);
	}

	private void join(KeyValuesReader reader1, KeyValuesReader reader2, KeyValueWriter writer) throws IOException {

		while (reader1.next() && reader2.next()) {
			Text value1 = (Text) reader1.getCurrentKey();
			Text value2 = (Text) reader2.getCurrentKey();
			boolean reachEnd = false;
			while (value1.compareTo(value2) != 0) {
				if (value1.compareTo(value2) > 0) {
					if (reader2.next()) {
						value2 = (Text) reader2.getCurrentKey();
					} else {
						reachEnd = true;
						break;
					}
				} else {
					if (reader1.next()) {
						value1 = (Text) reader1.getCurrentKey();
					} else {
						reachEnd = true;
						break;
					}
				}
			}

			if (reachEnd) {
				break;
			} else {
				writer.write(value1, NullWritable.get());
			}
		}
	}

}