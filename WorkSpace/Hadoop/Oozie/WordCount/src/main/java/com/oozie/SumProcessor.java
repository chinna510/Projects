package com.oozie;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.tez.mapreduce.processor.SimpleMRProcessor;
import org.apache.tez.runtime.api.ProcessorContext;
import org.apache.tez.runtime.library.api.KeyValueWriter;
import org.apache.tez.runtime.library.api.KeyValuesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class SumProcessor extends SimpleMRProcessor {
	private static final Logger LOG = LoggerFactory.getLogger(SumProcessor.class);

	static String INPUT = "Input";
	static String OUTPUT = "Output";
	static String TOKENIZER = "Tokenizer";
	static String SUMMATION = "Summation";

	public SumProcessor(ProcessorContext context) {

		super(context);
		LOG.info("####### SUMProcessor Constructor Loading ...");
	}

	@Override
	public void run() throws Exception {
		LOG.info("SUMProcessor Run()  Loading ...");
		Preconditions.checkArgument(getInputs().size() == 1);
		Preconditions.checkArgument(getOutputs().size() == 1);
		KeyValueWriter kvWriter = (KeyValueWriter) getOutputs().get(OUTPUT).getWriter();
		KeyValuesReader kvReader = (KeyValuesReader) getInputs().get(TOKENIZER).getReader();

		while (kvReader.next()) {
			Text word = (Text) kvReader.getCurrentKey();
			int sum = 0;
			for (Object value : kvReader.getCurrentValues()) {
				sum += ((IntWritable) value).get();
			}
			kvWriter.write(word, new IntWritable(sum));
		}
	}
}