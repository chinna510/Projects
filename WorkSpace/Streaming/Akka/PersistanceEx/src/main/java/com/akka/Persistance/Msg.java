package com.akka.Persistance;

import java.io.Serializable;

public class Msg implements Serializable {

	private static final long serialVersionUID = 1L;
	public final long deliveryId;
	public final String s;

	public Msg(long deliveryId, String s) {
		this.deliveryId = deliveryId;
		this.s = s;
	}
}
