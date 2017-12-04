package com.tez.example;

import org.apache.tez.runtime.api.ProcessorContext;
import org.apache.tez.runtime.library.api.KeyValueWriter;
import org.apache.tez.runtime.library.api.KeyValuesReader;
import org.apache.tez.runtime.library.processor.SimpleProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class SorterProcessor extends SimpleProcessor {

	private static String OUTPUT = "Output";
	private static String SUMMATION = "Summation";
	private static final Logger LOG = LoggerFactory.getLogger(SorterProcessor.class);

	public SorterProcessor(ProcessorContext context) {
		super(context);

	}

	@Override
	public void run() throws Exception {
		Preconditions.checkArgument(getInputs().size() == 1);
		Preconditions.checkArgument(getOutputs().size() == 1);
		KeyValueWriter kvWriter = (KeyValueWriter) getOutputs().get(OUTPUT).getWriter();
		KeyValuesReader kvReader = (KeyValuesReader) getInputs().get(SUMMATION).getReader();
		while (kvReader.next()) {
			Object sum = kvReader.getCurrentKey();
			for (Object word : kvReader.getCurrentValues()) {
				kvWriter.write(word, sum);
			}
		}

	}
}