package com.akka.distribute;

import java.io.Serializable;

public class CounterChanged implements Serializable {

	private static final long serialVersionUID = 1L;
	public int delta;

	public CounterChanged(int delta) {
		this.delta = delta;

	}

}