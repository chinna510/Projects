package com.akka.subchannel;

import akka.util.Subclassification;

public class StartsWithSubclassification implements Subclassification<String> {

	@Override
	public boolean isEqual(String a, String b) {
		return a.equals(b);
	}

	@Override
	public boolean isSubclass(String a, String b) {
		return a.startsWith(b);
		
	}

}