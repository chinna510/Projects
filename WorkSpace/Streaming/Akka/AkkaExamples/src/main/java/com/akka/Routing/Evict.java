package com.akka.Routing;

import java.io.Serializable;

public class Evict implements Serializable {
	private static final long serialVersionUID = 1L;
	public final String key;

	public Evict(String key) {
		this.key = key;
	}
}
