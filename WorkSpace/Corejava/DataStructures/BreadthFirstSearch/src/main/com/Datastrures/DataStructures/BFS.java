<<<<<<< HEAD
package com.Datastrures.DataStructures;

public class BFS extends BinarySearchTree {

	public void breadth_first() {
		ArrayQueue2 q = new ArrayQueue2(10);
		ChildNodes tmp;
		q.insert(getRoot());
		while (!q.isEmpty()) {
			tmp = (ChildNodes) q.remove();
			if (tmp.getLeft() != null)
				q.insert(tmp.getLeft());
			if (tmp.getRight() != null)
				q.insert(tmp.getRight());
			System.out.print(tmp.getData() + " ");
		}

	}
}
=======
package com.Datastrures.DataStructures;

public class BFS extends BinarySearchTree {

	public void breadth_first() {
		ArrayQueue2 q = new ArrayQueue2(10);
		ChildNodes tmp;
		q.insert(getRoot());
		while (!q.isEmpty()) {
			tmp = (ChildNodes) q.remove();
			if (tmp.getLeft() != null)
				q.insert(tmp.getLeft());
			if (tmp.getRight() != null)
				q.insert(tmp.getRight());
			System.out.print(tmp.getData() + " ");
		}

	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
