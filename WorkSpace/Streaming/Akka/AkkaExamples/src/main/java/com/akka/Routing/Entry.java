package com.akka.Routing;

import java.io.Serializable;

public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;
	public final String key;
	public final String value;

	public Entry(String key, String value) {
		this.key = key;
		this.value = value;
	}

}
