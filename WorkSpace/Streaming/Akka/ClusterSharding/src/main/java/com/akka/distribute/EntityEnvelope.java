package com.akka.distribute;

import java.io.Serializable;

public class EntityEnvelope implements Serializable{

	private static final long serialVersionUID = 1L;
	public long id;
	public Object payload;

	public EntityEnvelope(long id, Object payload) {
		this.id = id;
		this.payload = payload;

	}

}
