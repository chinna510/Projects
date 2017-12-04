package com.akka.externalserveices;

public class TextMessage {

	public final String to;
	public final String body;

	TextMessage(String to, String body) {
		this.to = to;
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

		TextMessage that = (TextMessage) o;

		if (body != null ? !body.equals(that.body) : that.body != null) {
			return false;
		}
		if (to != null ? !to.equals(that.to) : that.to != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = to != null ? to.hashCode() : 0;
		result = 31 * result + (body != null ? body.hashCode() : 0);
		return result;
	}

}
