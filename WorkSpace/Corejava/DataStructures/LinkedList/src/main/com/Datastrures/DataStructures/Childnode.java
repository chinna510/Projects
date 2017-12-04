<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class Childnode {

	protected Object data;
	protected Childnode next;
	public Childnode() {
		data=null;
		next=null;
	}
	
	public Childnode(Object data, Childnode next) {

		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Childnode getNext() {
		return next;
	}

	public void setNext(Childnode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Childnode [data=" + data + ", next=" + next + "]";
	}

}
=======
package com.Datastrures.DataStructures;

public class Childnode {

	protected Object data;
	protected Childnode next;
	public Childnode() {
		data=null;
		next=null;
	}
	
	public Childnode(Object data, Childnode next) {

		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Childnode getNext() {
		return next;
	}

	public void setNext(Childnode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Childnode [data=" + data + ", next=" + next + "]";
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
