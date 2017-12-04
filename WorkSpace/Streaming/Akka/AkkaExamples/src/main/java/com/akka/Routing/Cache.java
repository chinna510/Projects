package com.akka.Routing;

import java.util.*;

import akka.actor.UntypedActor;

public class Cache extends UntypedActor {
	private static final Object NOT_FOUND = "NOT-FOUND";
	Map<String, String> cache = new HashMap<String, String>();

	public void onReceive(Object msg) {
		if (msg instanceof Entry) {
			Entry entry = (Entry) msg;
			cache.put(entry.key, entry.value);
		} else if (msg instanceof Get) {
			Get get = (Get) msg;
			Object value = cache.get(get.key);
			getSender().tell(value == null ? NOT_FOUND : value, getContext().self());
		} else if (msg instanceof Evict) {
			Evict evict = (Evict) msg;
			cache.remove(evict.key);
		} else {
			unhandled(msg);
		}
	}
}
