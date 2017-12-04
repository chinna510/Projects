package com.akka.Persistance;

import java.io.Serializable;

public class MsgSent implements Serializable{

	private static final long serialVersionUID = 1L;
	public final String s;
	  
	  public MsgSent(String s) {
	    this.s = s;
	  }
}
