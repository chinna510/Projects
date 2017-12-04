package com.biz;

import java.util.Set;

public class RichEvent {
	public final Set<String> tags;
	public final Object payload;

	public RichEvent(Set<String> tags, Object payload) {
		this.tags = tags;
		this.payload = payload;
	}
}
