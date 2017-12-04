<<<<<<< HEAD
package com.Datastrures.DataStructures;

import org.apache.log4j.Logger;

public class BinaryTreeTest {

	static Logger logger = Logger.getLogger(BinaryTreeTest.class);

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		BinaryTreeComparision n;
		int i;
		logger.info("\nNumbers inserted:");
		for (i = 0; i < 10; i++) {
			tree.insert(n = new BinaryTreeComparision(
					(int) (Math.random() * 1000)));
			logger.debug(n + " ");
		}
		logger.info("\nPre-order : ");
		tree.print(1);
		logger.info("\nIn-order  : ");
		tree.print();
		logger.info("\nPost-order : ");
		tree.print(3);
	}
}
=======
package com.Datastrures.DataStructures;

import org.apache.log4j.Logger;

public class BinaryTreeTest {

	static Logger logger = Logger.getLogger(BinaryTreeTest.class);

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		BinaryTreeComparision n;
		int i;
		logger.info("\nNumbers inserted:");
		for (i = 0; i < 10; i++) {
			tree.insert(n = new BinaryTreeComparision(
					(int) (Math.random() * 1000)));
			logger.debug(n + " ");
		}
		logger.info("\nPre-order : ");
		tree.print(1);
		logger.info("\nIn-order  : ");
		tree.print();
		logger.info("\nPost-order : ");
		tree.print(3);
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
