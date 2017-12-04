package com.akka.externalserveices;

public class Hashtag {

	public final String name;

	public Hashtag(String name) {
		this.name = name;
	}

	// ...
	// #model

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hashtag other = (Hashtag) obj;
		return name.equals(other.name);
	}

	@Override
	public String toString() {
		return "Hashtag(" + name + ")";
	}
}
