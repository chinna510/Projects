package com.akka.extension;
import java.util.concurrent.atomic.AtomicLong;

import akka.actor.Extension;

public class CountExtensionImpl implements Extension {

	AtomicLong counter = new AtomicLong(0);

	public long increment() {
		return counter.incrementAndGet();
	}

}
