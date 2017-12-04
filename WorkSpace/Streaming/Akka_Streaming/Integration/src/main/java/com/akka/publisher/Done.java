package com.akka.publisher;

public class Done {

	
	  public final int id;
	    public Done(int id) { this.id = id; }
	 
	    @Override
	    public String toString() {
	      return String.format("Done(%s)", id);
	    }
	 
	    @Override
	    public boolean equals(Object o) {
	      if (this == o) {
	        return true;
	      }
	      if (o == null || getClass() != o.getClass()) {
	        return false;
	      }
	 
	      Done done = (Done) o;
	 
	      if (id != done.id) {
	        return false;
	      }
	 
	      return true;
	    }
	 
	    @Override
	    public int hashCode() {
	      return id;
	    }
}
