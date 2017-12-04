<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class BinaryTreeComparision implements Comparable {
	int i;

	public BinaryTreeComparision() {

	}

	public BinaryTreeComparision(int j) {

		set(j);
	}

	public int get() {
		return i;
	}

	public void set(int j) {
		i = j;
	}

	@Override
	public String toString() {
		return "" + get();
	}

	public int compareTo(Object o) {
		if (o instanceof BinaryTreeComparision)
			if (get() > ((BinaryTreeComparision) o).get())
				return 1;
			else if (get() < ((BinaryTreeComparision) o).get())
				return -1;
		return 0;
	}

}
=======
package com.Datastrures.DataStructures;

public class BinaryTreeComparision implements Comparable {
	int i;

	public BinaryTreeComparision() {

	}

	public BinaryTreeComparision(int j) {

		set(j);
	}

	public int get() {
		return i;
	}

	public void set(int j) {
		i = j;
	}

	@Override
	public String toString() {
		return "" + get();
	}

	public int compareTo(Object o) {
		if (o instanceof BinaryTreeComparision)
			if (get() > ((BinaryTreeComparision) o).get())
				return 1;
			else if (get() < ((BinaryTreeComparision) o).get())
				return -1;
		return 0;
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
