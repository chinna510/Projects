<<<<<<< HEAD
package com.NodePool;

public class NodePoolSortArray extends NodePoolArrayTree {
	public NodePoolSortArray() {
		super();
	}

	public NodePoolSortArray(int n) {
		super(n);
	}

	public void print() {
		print(2);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(Comparable obj) {
		int t, q = -1;
		t = getRoot();
		while (t != -1 && !(obj.equals(getNode(t).getData()))) {
			q = t;
			if (obj.compareTo(getNode(t).getData()) < 0)
				t = getNode(t).getLeft();
			else
				t = getNode(t).getRight();
		}
		if (t != -1)
			return;
		if (q == -1) {
			setData(obj);
			return;
		}
		if (obj.compareTo(getNode(q).getData()) < 0)
			insertLeft(q, obj);
		else
			insertRight(q, obj);
	}

}
=======
package com.NodePool;

public class NodePoolSortArray extends NodePoolArrayTree {
	public NodePoolSortArray() {
		super();
	}

	public NodePoolSortArray(int n) {
		super(n);
	}

	public void print() {
		print(2);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(Comparable obj) {
		int t, q = -1;
		t = getRoot();
		while (t != -1 && !(obj.equals(getNode(t).getData()))) {
			q = t;
			if (obj.compareTo(getNode(t).getData()) < 0)
				t = getNode(t).getLeft();
			else
				t = getNode(t).getRight();
		}
		if (t != -1)
			return;
		if (q == -1) {
			setData(obj);
			return;
		}
		if (obj.compareTo(getNode(q).getData()) < 0)
			insertLeft(q, obj);
		else
			insertRight(q, obj);
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
