package com.akka.persistance;

import java.io.Serializable;
import java.util.ArrayList;

public class ExampleState implements Serializable {
	private static final long serialVersionUID = 1L;
	private final ArrayList<String> events;

	public ExampleState() {
		this(new ArrayList<String>());
	}

	public ExampleState(ArrayList<String> events) {
		this.events = events;
	}

	public ExampleState copy() {
		return new ExampleState(new ArrayList<String>(events));
	}

	public void update(Evt evt) {
		events.add(evt.getData());
	}

	public int size() {
		return events.size();
	}

	@Override
	public String toString() {
		return events.toString();
	}
}
