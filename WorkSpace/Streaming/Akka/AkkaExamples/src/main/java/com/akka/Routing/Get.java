package com.akka.Routing;

import java.io.Serializable;

public class Get implements Serializable {
	private static final long serialVersionUID = 1L;
	public final String key;

	public Get(String key) {
		this.key = key;
	}

	public Object consistentHashKey() {
		return key;
	}
}
