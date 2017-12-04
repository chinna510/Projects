package com.akka.externalserveices;

public class Author {

	public final String handle;

	public Author(String handle) {
		this.handle = handle;
	}

	// ...

	// #model

	@Override
	public String toString() {
		return "Author(" + handle + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Author author = (Author) o;

		if (handle != null ? !handle.equals(author.handle) : author.handle != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return handle != null ? handle.hashCode() : 0;
	}
	// #model

}
