package com.bizruntime.tez;

import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.tez.mapreduce.processor.SimpleMRProcessor;
import org.apache.tez.runtime.api.ProcessorContext;
import org.apache.tez.runtime.library.api.KeyValueReader;
import org.apache.tez.runtime.library.api.KeyValueWriter;
import org.apache.tez.runtime.library.processor.SimpleProcessor;

import com.google.common.base.Preconditions;

public class TokenProcessor extends SimpleProcessor {
	static String INPUT = "Input";
	static String SUMMATION = "Summation";
	IntWritable one = new IntWritable(1);
	Text word = new Text();

	public TokenProcessor(ProcessorContext context) {
		super(context);
	}

	@Override
	public void run() throws Exception {
		Preconditions.checkArgument(getInputs().size() == 1);
		Preconditions.checkArgument(getOutputs().size() == 1);
		KeyValueReader kvReader = (KeyValueReader) getInputs().get(INPUT).getReader();
		KeyValueWriter kvWriter = (KeyValueWriter) getOutputs().get(SUMMATION).getWriter();
		while (kvReader.next()) {
			StringTokenizer itr = new StringTokenizer(kvReader.getCurrentValue().toString());
			while (itr.hasMoreTokens()) {
				word.set(itr.nextToken());
				kvWriter.write(word, one);
			}
		}
	}
}