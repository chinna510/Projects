<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class ArrayQueue2 {
	protected Object[] array;
	protected int start, end;
	protected boolean full;

	public ArrayQueue2(int maxsize) {
		array = new Object[maxsize];
		start = end = 0;
		full = false;
	}

	public boolean isEmpty() {
		return ((start == end) && !full);
	}

	public void insert(Object o) {
		if (!full)
			array[start = (++start % array.length)] = o;
		if (start == end)
			full = true;
	}

	public Object remove() {
		if (full)
			full = false;
		else if (isEmpty())
			return null;
		return array[end = (++end % array.length)];
	}
}
=======
package com.Datastrures.DataStructures;

public class ArrayQueue2 {
	protected Object[] array;
	protected int start, end;
	protected boolean full;

	public ArrayQueue2(int maxsize) {
		array = new Object[maxsize];
		start = end = 0;
		full = false;
	}

	public boolean isEmpty() {
		return ((start == end) && !full);
	}

	public void insert(Object o) {
		if (!full)
			array[start = (++start % array.length)] = o;
		if (start == end)
			full = true;
	}

	public Object remove() {
		if (full)
			full = false;
		else if (isEmpty())
			return null;
		return array[end = (++end % array.length)];
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
