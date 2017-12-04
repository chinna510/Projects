<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class GenericBinaryTree {
	private ChildNodes root;

	protected ChildNodes getRoot() {
		return root;
	}

	protected void setRoot(ChildNodes r) {
		root = r;
	}

	public GenericBinaryTree() {
		setRoot(null);
	}

	public GenericBinaryTree(Object o) {
		setRoot(new ChildNodes(o));
	}

	public boolean isEmpty() {
		return getRoot() == null;
	}

	public Object getData() {
		if (!isEmpty())
			return getRoot().getData();
		return null;
	}

	public ChildNodes getLeft() {
		if (!isEmpty())
			return getRoot().getLeft();
		return null;
	}

	public ChildNodes getRight() {
		if (!isEmpty())
			return getRoot().getRight();
		return null;
	}

	public void setData(Object o) {
		if (!isEmpty())
			getRoot().setData(o);
	}

	public void insertLeft(ChildNodes p, Object o) {
		if ((p != null) && (p.getLeft() == null))
			p.setLeft(new ChildNodes(o));
	}

	public void insertRight(ChildNodes p, Object o) {
		if ((p != null) && (p.getRight() == null))
			p.setRight(new ChildNodes(o));
	}

	public void print(int mode) {
		if (mode == 1)
			pretrav();
		else if (mode == 2)
			intrav();
		else if (mode == 3)
			postrav();
	}

	public void pretrav() {
		pretrav(getRoot());
	}

	protected void pretrav(ChildNodes p) {
		if (p == null)
			return;
		System.out.print(p.getData() + " ");
		pretrav(p.getLeft());
		pretrav(p.getRight());
	}

	public void intrav() {
		intrav(getRoot());
	}

	protected void intrav(ChildNodes p) {
		if (p == null)
			return;
		intrav(p.getLeft());
		System.out.print(p.getData() + " ");
		intrav(p.getRight());
	}

	public void postrav() {
		postrav(getRoot());
	}

	protected void postrav(ChildNodes p) {
		if (p == null)
			return;
		postrav(p.getLeft());
		postrav(p.getRight());
		System.out.print(p.getData() + " ");
	}
}
=======
package com.Datastrures.DataStructures;

public class GenericBinaryTree {
	private ChildNodes root;

	protected ChildNodes getRoot() {
		return root;
	}

	protected void setRoot(ChildNodes r) {
		root = r;
	}

	public GenericBinaryTree() {
		setRoot(null);
	}

	public GenericBinaryTree(Object o) {
		setRoot(new ChildNodes(o));
	}

	public boolean isEmpty() {
		return getRoot() == null;
	}

	public Object getData() {
		if (!isEmpty())
			return getRoot().getData();
		return null;
	}

	public ChildNodes getLeft() {
		if (!isEmpty())
			return getRoot().getLeft();
		return null;
	}

	public ChildNodes getRight() {
		if (!isEmpty())
			return getRoot().getRight();
		return null;
	}

	public void setData(Object o) {
		if (!isEmpty())
			getRoot().setData(o);
	}

	public void insertLeft(ChildNodes p, Object o) {
		if ((p != null) && (p.getLeft() == null))
			p.setLeft(new ChildNodes(o));
	}

	public void insertRight(ChildNodes p, Object o) {
		if ((p != null) && (p.getRight() == null))
			p.setRight(new ChildNodes(o));
	}

	public void print(int mode) {
		if (mode == 1)
			pretrav();
		else if (mode == 2)
			intrav();
		else if (mode == 3)
			postrav();
	}

	public void pretrav() {
		pretrav(getRoot());
	}

	protected void pretrav(ChildNodes p) {
		if (p == null)
			return;
		System.out.print(p.getData() + " ");
		pretrav(p.getLeft());
		pretrav(p.getRight());
	}

	public void intrav() {
		intrav(getRoot());
	}

	protected void intrav(ChildNodes p) {
		if (p == null)
			return;
		intrav(p.getLeft());
		System.out.print(p.getData() + " ");
		intrav(p.getRight());
	}

	public void postrav() {
		postrav(getRoot());
	}

	protected void postrav(ChildNodes p) {
		if (p == null)
			return;
		postrav(p.getLeft());
		postrav(p.getRight());
		System.out.print(p.getData() + " ");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
