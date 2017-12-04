package com.akka.integration;

public class Work {

	public final int id;

	public Work(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Work(%s)", id);
	}

}
