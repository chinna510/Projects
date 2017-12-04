package com.oozie;

import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.tez.mapreduce.processor.SimpleMRProcessor;
import org.apache.tez.runtime.api.ProcessorContext;
import org.apache.tez.runtime.library.api.KeyValueReader;
import org.apache.tez.runtime.library.api.KeyValueWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class TokenProcessor extends SimpleMRProcessor {

	static String INPUT = "Input";
	static String OUTPUT = "Output";
	static String TOKENIZER = "Tokenizer";
	static String SUMMATION = "Summation";
	IntWritable one = new IntWritable(1);
	Text word = new Text();
	private static final Logger LOG = LoggerFactory.getLogger(TokenProcessor.class);

	public TokenProcessor(ProcessorContext context) {
		super(context);
		LOG.info("*******TokenProcessor Constructor Loading ***********");
	}

	@Override
	public void run() throws Exception {
		LOG.info("*****************TokenProcessor Run() method Called **************");
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
