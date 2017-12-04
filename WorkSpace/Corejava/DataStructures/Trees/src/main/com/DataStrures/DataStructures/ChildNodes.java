<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class ChildNodes {
	protected Object data;
	protected ChildNodes left, right;

	public ChildNodes() {
		data = null;
		left = right = null;
	}

	public ChildNodes(Object d) {
		data = d;
		left = right = null;
	}

	public void setLeft(ChildNodes l) {
		left = l;
	}

	public void setRight(ChildNodes r) {
		right = r;
	}

	public void setData(Object d) {
		data = d;
	}

	public ChildNodes getLeft() {
		return left;
	}

	public ChildNodes getRight() {
		return right;
	}

	public Object getData() {
		return data;
	}

	public String toString() {
		return "" + data;
	}
}
=======
package com.Datastrures.DataStructures;

public class ChildNodes {
	protected Object data;
	protected ChildNodes left, right;

	public ChildNodes() {
		data = null;
		left = right = null;
	}

	public ChildNodes(Object d) {
		data = d;
		left = right = null;
	}

	public void setLeft(ChildNodes l) {
		left = l;
	}

	public void setRight(ChildNodes r) {
		right = r;
	}

	public void setData(Object d) {
		data = d;
	}

	public ChildNodes getLeft() {
		return left;
	}

	public ChildNodes getRight() {
		return right;
	}

	public Object getData() {
		return data;
	}

	public String toString() {
		return "" + data;
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
