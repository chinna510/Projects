<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class ArrayList2 {
	protected Object[] array;
	protected int start, end, number;

	public ArrayList2(int maxsize) {
		array = new Object[maxsize];
		start = end = number = 0;
	}

	public boolean isEmpty() {
		return number == 0;
	}

	public boolean isFull() {
		return number >= array.length;
	}

	public int size() {
		return number;
	}

	public void insert(Object o) {
		if (number < array.length) {
			array[start = (++start % array.length)] = o;
			number++;
		}
	}

	public void insertEnd(Object o) {
		if (number < array.length) {
			array[end] = o;
			end = (--end + array.length) % array.length;
			number++;
		}
	}

	public Object remove() {
		if (isEmpty())
			return null;
		number--;
		int i = start;
		start = (--start + array.length) % array.length;
		return array[i];
	}

	public Object removeEnd() {
		if (isEmpty())
			return null;
		number--;
		return array[end = (++end % array.length)];
	}

	public Object peek(int n) {
		if (n >= number)
			return null;
		return array[(end + 1 + n) % array.length];
	}
}
=======
package com.Datastrures.DataStructures;

public class ArrayList2 {
	protected Object[] array;
	protected int start, end, number;

	public ArrayList2(int maxsize) {
		array = new Object[maxsize];
		start = end = number = 0;
	}

	public boolean isEmpty() {
		return number == 0;
	}

	public boolean isFull() {
		return number >= array.length;
	}

	public int size() {
		return number;
	}

	public void insert(Object o) {
		if (number < array.length) {
			array[start = (++start % array.length)] = o;
			number++;
		}
	}

	public void insertEnd(Object o) {
		if (number < array.length) {
			array[end] = o;
			end = (--end + array.length) % array.length;
			number++;
		}
	}

	public Object remove() {
		if (isEmpty())
			return null;
		number--;
		int i = start;
		start = (--start + array.length) % array.length;
		return array[i];
	}

	public Object removeEnd() {
		if (isEmpty())
			return null;
		number--;
		return array[end = (++end % array.length)];
	}

	public Object peek(int n) {
		if (n >= number)
			return null;
		return array[(end + 1 + n) % array.length];
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
