<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class BinarySearchTree extends GenericBinaryTree {
	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(Object o) {
		super(o);
	}

	public void print() {
		print(2);
	}

	public void insert(Comparable o) {
		ChildNodes t, q;
		for (q = null, t = getRoot(); t != null
				&& o.compareTo(t.getData()) != 0; q = t, t = o.compareTo(t
				.getData()) < 0 ? t.getLeft() : t.getRight())
			;
		if (t != null)
			return;
		else if (q == null)
			setRoot(new ChildNodes(o));
		else if (o.compareTo(q.getData()) < 0)
			insertLeft(q, o);
		else
			insertRight(q, o);
	}
}
=======
package com.Datastrures.DataStructures;

public class BinarySearchTree extends GenericBinaryTree {
	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(Object o) {
		super(o);
	}

	public void print() {
		print(2);
	}

	public void insert(Comparable o) {
		ChildNodes t, q;
		for (q = null, t = getRoot(); t != null
				&& o.compareTo(t.getData()) != 0; q = t, t = o.compareTo(t
				.getData()) < 0 ? t.getLeft() : t.getRight())
			;
		if (t != null)
			return;
		else if (q == null)
			setRoot(new ChildNodes(o));
		else if (o.compareTo(q.getData()) < 0)
			insertLeft(q, o);
		else
			insertRight(q, o);
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
