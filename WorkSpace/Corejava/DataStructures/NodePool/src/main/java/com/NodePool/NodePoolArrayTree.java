<<<<<<< HEAD
package com.NodePool;

import org.apache.log4j.Logger;

public class NodePoolArrayTree {
	static Logger logger = Logger.getLogger(NodePoolArrayTree.class);
	private int numNodes, nextAvail;
	private NodePoolTreeNode[] arrayNodes;
	protected int root;

	private void init() {
		int i;
		root = -1;
		arrayNodes = new NodePoolTreeNode[numNodes];
		nextAvail = 0;
		for (i = 0; i < numNodes; i++)
			arrayNodes[i] = new NodePoolTreeNode(-1, i + 1);
		getNode(i - 1).setRight(-1);
	}

	public NodePoolArrayTree() {
		numNodes = 500;
		init();
	}

	public NodePoolArrayTree(int n) {
		numNodes = n;
		init();
	}

	protected int getNode() {
		int i = nextAvail;
		nextAvail = getNode(nextAvail).getRight();
		if (nextAvail == -1) {
			nextAvail = i;
			return -1;
		}
		return i;
	}

	protected void freeNode(int n) {
		getNode(n).setRight(nextAvail);
		nextAvail = n;
	}

	public boolean isEmpty() {
		return getRoot() == -1;
	}

	public boolean isFull() {
		int i = getNode();
		if (i != -1) {
			freeNode(i);
			return false;
		}
		return true;
	}

	protected Object getData() {
		if (isEmpty())
			return null;
		return getNode(getRoot()).getData();
	}

	protected void setData(Object o) {
		if (isEmpty())
			root = getNode();
		getNode(root).setData(o);
		getNode(root).setLeft(-1);
		getNode(root).setRight(-1);
	}

	protected int getLeft() {
		if (isEmpty())
			return -1;
		return getNode(getRoot()).getLeft();
	}

	protected void setLeft(int n) {
		if (isFull())
			return;
		if (isEmpty()) {
			root = getNode();
			getNode(getRoot()).setRight(-1);
		}
		getNode(getRoot()).setLeft(n);
	}

	protected void setRight(int n) {
		if (isFull())
			return;
		if (isEmpty()) {
			root = getNode();
			getNode(getRoot()).setLeft(-1);
		}
		getNode(getRoot()).setRight(n);
	}

	protected int getRight() {
		if (isEmpty())
			return -1;
		return getNode(root).getRight();
	}

	protected int getRoot() {
		return root;
	}

	protected NodePoolTreeNode getNode(int n) {
		if (n != -1)
			return arrayNodes[n];
		else
			return null;
	}

	protected void insertLeft(int node, Object o) {
		if ((node != -1) && (getNode(node).getLeft() == -1) && !isFull()) {
			int i = getNode();
			getNode(i).setData(o);
			getNode(i).setRight(-1);
			getNode(node).setLeft(i);
		}
	}

	protected void insertRight(int node, Object o) {
		if ((node != -1) && (getNode(node).getRight() == -1) && !isFull()) {
			int i = getNode();
			getNode(i).setData(o);
			getNode(i).setRight(-1);
			getNode(node).setRight(i);
		}
	}

	public void print(int mode) {
		switch (mode) {
		case 1:
			pretrav();
			break;
		case 2:
			intrav();
			break;
		case 3:
			postrav();
			break;
		}
	}

	public void pretrav() {
		pretrav(getRoot());
	}

	private void pretrav(int p) {
		if (p == -1)
			return;
		logger.info(getNode(p).getData() + " ");
		pretrav(getNode(p).getLeft());
		pretrav(getNode(p).getRight());
	}

	public void intrav() {
		intrav(getRoot());
	}

	private void intrav(int p) {
		if (p == -1)
			return;
		intrav(getNode(p).getLeft());
		logger.info(getNode(p).getData() + " ");
		intrav(getNode(p).getRight());
	}

	public void postrav() {
		postrav(getRoot());
	}

	private void postrav(int p) {
		if (p == -1)
			return;
		postrav(getNode(p).getLeft());
		postrav(getNode(p).getRight());
		logger.info(getNode(p).getData() + " ");
	}
}
=======
package com.NodePool;

import org.apache.log4j.Logger;

public class NodePoolArrayTree {
	static Logger logger = Logger.getLogger(NodePoolArrayTree.class);
	private int numNodes, nextAvail;
	private NodePoolTreeNode[] arrayNodes;
	protected int root;

	private void init() {
		int i;
		root = -1;
		arrayNodes = new NodePoolTreeNode[numNodes];
		nextAvail = 0;
		for (i = 0; i < numNodes; i++)
			arrayNodes[i] = new NodePoolTreeNode(-1, i + 1);
		getNode(i - 1).setRight(-1);
	}

	public NodePoolArrayTree() {
		numNodes = 500;
		init();
	}

	public NodePoolArrayTree(int n) {
		numNodes = n;
		init();
	}

	protected int getNode() {
		int i = nextAvail;
		nextAvail = getNode(nextAvail).getRight();
		if (nextAvail == -1) {
			nextAvail = i;
			return -1;
		}
		return i;
	}

	protected void freeNode(int n) {
		getNode(n).setRight(nextAvail);
		nextAvail = n;
	}

	public boolean isEmpty() {
		return getRoot() == -1;
	}

	public boolean isFull() {
		int i = getNode();
		if (i != -1) {
			freeNode(i);
			return false;
		}
		return true;
	}

	protected Object getData() {
		if (isEmpty())
			return null;
		return getNode(getRoot()).getData();
	}

	protected void setData(Object o) {
		if (isEmpty())
			root = getNode();
		getNode(root).setData(o);
		getNode(root).setLeft(-1);
		getNode(root).setRight(-1);
	}

	protected int getLeft() {
		if (isEmpty())
			return -1;
		return getNode(getRoot()).getLeft();
	}

	protected void setLeft(int n) {
		if (isFull())
			return;
		if (isEmpty()) {
			root = getNode();
			getNode(getRoot()).setRight(-1);
		}
		getNode(getRoot()).setLeft(n);
	}

	protected void setRight(int n) {
		if (isFull())
			return;
		if (isEmpty()) {
			root = getNode();
			getNode(getRoot()).setLeft(-1);
		}
		getNode(getRoot()).setRight(n);
	}

	protected int getRight() {
		if (isEmpty())
			return -1;
		return getNode(root).getRight();
	}

	protected int getRoot() {
		return root;
	}

	protected NodePoolTreeNode getNode(int n) {
		if (n != -1)
			return arrayNodes[n];
		else
			return null;
	}

	protected void insertLeft(int node, Object o) {
		if ((node != -1) && (getNode(node).getLeft() == -1) && !isFull()) {
			int i = getNode();
			getNode(i).setData(o);
			getNode(i).setRight(-1);
			getNode(node).setLeft(i);
		}
	}

	protected void insertRight(int node, Object o) {
		if ((node != -1) && (getNode(node).getRight() == -1) && !isFull()) {
			int i = getNode();
			getNode(i).setData(o);
			getNode(i).setRight(-1);
			getNode(node).setRight(i);
		}
	}

	public void print(int mode) {
		switch (mode) {
		case 1:
			pretrav();
			break;
		case 2:
			intrav();
			break;
		case 3:
			postrav();
			break;
		}
	}

	public void pretrav() {
		pretrav(getRoot());
	}

	private void pretrav(int p) {
		if (p == -1)
			return;
		logger.info(getNode(p).getData() + " ");
		pretrav(getNode(p).getLeft());
		pretrav(getNode(p).getRight());
	}

	public void intrav() {
		intrav(getRoot());
	}

	private void intrav(int p) {
		if (p == -1)
			return;
		intrav(getNode(p).getLeft());
		logger.info(getNode(p).getData() + " ");
		intrav(getNode(p).getRight());
	}

	public void postrav() {
		postrav(getRoot());
	}

	private void postrav(int p) {
		if (p == -1)
			return;
		postrav(getNode(p).getLeft());
		postrav(getNode(p).getRight());
		logger.info(getNode(p).getData() + " ");
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
