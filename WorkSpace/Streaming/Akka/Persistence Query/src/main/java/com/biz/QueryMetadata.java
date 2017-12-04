package com.biz;

public class QueryMetadata {
	  public final boolean deterministicOrder;
	  public final boolean infinite;
	 
	  public QueryMetadata(boolean deterministicOrder, boolean infinite) {
	    this.deterministicOrder = deterministicOrder;
	    this.infinite = infinite;
	  }
}
