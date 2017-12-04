package com.akka.externalserveices;

public class Email {

	public final String to;
	public final String title;
	public final String body;

	public Email(String to, String title, String body) {
		this.to = to;
		this.title = title;
		this.body = body;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Email email = (Email) o;

		if (body != null ? !body.equals(email.body) : email.body != null) {
			return false;
		}
		if (title != null ? !title.equals(email.title) : email.title != null) {
			return false;
		}
		if (to != null ? !to.equals(email.to) : email.to != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = to != null ? to.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (body != null ? body.hashCode() : 0);
		return result;
	}
}