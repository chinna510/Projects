package com.akka.stream;

public class Topic {

	private final String name;

	public Topic(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Topic topic = (Topic) o;

		if (name != null ? !name.equals(topic.name) : topic.name != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return name != null ? name.hashCode() : 0;
	}
}
