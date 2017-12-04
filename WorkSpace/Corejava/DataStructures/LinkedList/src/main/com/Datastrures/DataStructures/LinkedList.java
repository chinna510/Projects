<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class LinkedList {
	protected Childnode head;
	protected int number;

	public LinkedList() {
		head = null;
		number = 0;
	}

	public int size() {
		return number;

	}

	public boolean isEmpty() {
		return head == null;

	}

	public void insert(Object obj) {
		head = new Childnode(obj, head);
		number++;
	}

	public Object remove() {
		if (isEmpty())
			return null;
		Childnode tmp = head;
		head = tmp.getNext();
		number--;
		return tmp.getData();
	}

	public void insertEnd(Object obj) {
		if (isEmpty())
			insert(obj);
		else {
			Childnode t = head;
			while (t.getNext() != null)
				t = t.getNext();
			Childnode tmp = new Childnode(obj, t.getNext());
			t.setNext(tmp);
			number++;
		}
	}

	public Object removeEnd() {
		if (isEmpty())
			return null;
		if (head.getNext() == null)
			return remove();
		Childnode t = head;
		while (t.getNext().getNext() != null)

			t = t.getNext();

		Object obj = t.getNext().getData();
		t.setNext(t.getNext().getNext());
		number--;
		return obj;
	}

	public Object peek(int n) {
		Childnode t = head;
		for (int i = 0; i < n && t != null; i++)
			t = t.getNext();
		return t.getData();
	}
}
=======
package com.Datastrures.DataStructures;

public class LinkedList {
	protected Childnode head;
	protected int number;

	public LinkedList() {
		head = null;
		number = 0;
	}

	public int size() {
		return number;

	}

	public boolean isEmpty() {
		return head == null;

	}

	public void insert(Object obj) {
		head = new Childnode(obj, head);
		number++;
	}

	public Object remove() {
		if (isEmpty())
			return null;
		Childnode tmp = head;
		head = tmp.getNext();
		number--;
		return tmp.getData();
	}

	public void insertEnd(Object obj) {
		if (isEmpty())
			insert(obj);
		else {
			Childnode t = head;
			while (t.getNext() != null)
				t = t.getNext();
			Childnode tmp = new Childnode(obj, t.getNext());
			t.setNext(tmp);
			number++;
		}
	}

	public Object removeEnd() {
		if (isEmpty())
			return null;
		if (head.getNext() == null)
			return remove();
		Childnode t = head;
		while (t.getNext().getNext() != null)

			t = t.getNext();

		Object obj = t.getNext().getData();
		t.setNext(t.getNext().getNext());
		number--;
		return obj;
	}

	public Object peek(int n) {
		Childnode t = head;
		for (int i = 0; i < n && t != null; i++)
			t = t.getNext();
		return t.getData();
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
