package com.akka.persistance;

import java.io.Serializable;

public class Cmd implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String data;

	public Cmd(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}
}
