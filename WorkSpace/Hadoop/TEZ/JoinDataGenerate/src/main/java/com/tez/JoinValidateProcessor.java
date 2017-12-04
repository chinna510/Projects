package com.tez;

import org.apache.tez.common.counters.TezCounter;
import org.apache.tez.runtime.api.LogicalInput;
import org.apache.tez.runtime.api.ProcessorContext;
import org.apache.tez.runtime.api.Reader;
import org.apache.tez.runtime.library.api.KeyValuesReader;
import org.apache.tez.runtime.library.processor.SimpleProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class JoinValidateProcessor extends SimpleProcessor {
	private static final Logger LOG = LoggerFactory.getLogger(JoinValidateProcessor.class);
	private static final String LHS_INPUT_NAME = "lhsfile";
	private static final String RHS_INPUT_NAME = "rhsfile";

	private static final String COUNTER_GROUP_NAME = "JOIN_VALIDATE";
	private static final String MISSING_KEY_COUNTER_NAME = "MISSING_KEY_EXISTS";

	public JoinValidateProcessor(ProcessorContext context) {
		super(context);
	}

	@Override
	public void run() throws Exception {
		Preconditions.checkState(getInputs().size() == 2);
		Preconditions.checkState(getOutputs().size() == 0);
		LogicalInput lhsInput = getInputs().get(LHS_INPUT_NAME);
		LogicalInput rhsInput = getInputs().get(RHS_INPUT_NAME);
		Reader lhsReaderRaw = lhsInput.getReader();
		Reader rhsReaderRaw = rhsInput.getReader();
		Preconditions.checkState(lhsReaderRaw instanceof KeyValuesReader);
		Preconditions.checkState(rhsReaderRaw instanceof KeyValuesReader);
		KeyValuesReader lhsReader = (KeyValuesReader) lhsReaderRaw;
		KeyValuesReader rhsReader = (KeyValuesReader) rhsReaderRaw;

		TezCounter lhsMissingKeyCounter = getContext().getCounters().findCounter(COUNTER_GROUP_NAME,
				MISSING_KEY_COUNTER_NAME);

		while (lhsReader.next()) {
			if (rhsReader.next()) {
				if (!lhsReader.getCurrentKey().equals(rhsReader.getCurrentKey())) {
					LOG.info("MismatchedKeys: " + "lhs=" + lhsReader.getCurrentKey() + ", rhs="
							+ rhsReader.getCurrentKey());
					lhsMissingKeyCounter.increment(1);
				}
			} else {
				lhsMissingKeyCounter.increment(1);
				LOG.info("ExtraKey in lhs: " + lhsReader.getClass());
				break;
			}
		}
		if (rhsReader.next()) {
			lhsMissingKeyCounter.increment(1);
			LOG.info("ExtraKey in rhs: " + lhsReader.getClass());
		}
	}

}
