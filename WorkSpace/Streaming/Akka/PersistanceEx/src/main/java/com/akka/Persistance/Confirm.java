package com.akka.Persistance;

import java.io.Serializable;

public class Confirm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public final long deliveryId;

	public Confirm(long deliveryId) {
		this.deliveryId = deliveryId;
	}
}
