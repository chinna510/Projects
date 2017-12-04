<<<<<<< HEAD
package com.NodePool;

public class NodePoolTreeNode {
	private Object data;
	private int left;
	private int right;

	public NodePoolTreeNode() {
		left = right = -1;
		data = null;
	}

	public NodePoolTreeNode(int l, int r) {
		left = l;
		right = r;
		data = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object o) {
		data = o;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int l) {
		left = l;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int r) {
		right = r;
	}

	public String toString() {
		return new String(data.toString());
	}
}
=======
package com.NodePool;

public class NodePoolTreeNode {
	private Object data;
	private int left;
	private int right;

	public NodePoolTreeNode() {
		left = right = -1;
		data = null;
	}

	public NodePoolTreeNode(int l, int r) {
		left = l;
		right = r;
		data = null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object o) {
		data = o;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int l) {
		left = l;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int r) {
		right = r;
	}

	public String toString() {
		return new String(data.toString());
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
