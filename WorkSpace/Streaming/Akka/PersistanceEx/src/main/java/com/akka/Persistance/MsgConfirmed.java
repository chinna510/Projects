package com.akka.Persistance;

import java.io.Serializable;

public class MsgConfirmed implements Serializable{
	private static final long serialVersionUID = 1L;
	  public final long deliveryId;
	  
	  public MsgConfirmed(long deliveryId) {
	    this.deliveryId = deliveryId;
	  }
}
