<<<<<<< HEAD
package com.Datastrures.DataStructures;

import org.apache.log4j.Logger;

public class BFSTest {
	static Logger logger = Logger.getLogger(BFSTest.class);

	public static void main(String[] args) {
		BFS tree = new BFS();
		BinaryTreeComparision n;
		int i;
		logger.info("Numbers inserted:");
		for (i = 0; i < 10; i++) {
			tree.insert(n = new BinaryTreeComparision(
					(int) (Math.random() * 1000)));
			logger.debug(n + " ");
		}
		logger.info("\nPre-order:");
		tree.print(1);
		logger.info("\nIn-order:");
		tree.print(2);
		logger.info("\nPost-order:");
		tree.print(3);
		logger.info("\nBreadth-First:");
		tree.breadth_first();
	}
}
=======
package com.Datastrures.DataStructures;

import org.apache.log4j.Logger;

public class BFSTest {
	static Logger logger = Logger.getLogger(BFSTest.class);

	public static void main(String[] args) {
		BFS tree = new BFS();
		BinaryTreeComparision n;
		int i;
		logger.info("Numbers inserted:");
		for (i = 0; i < 10; i++) {
			tree.insert(n = new BinaryTreeComparision(
					(int) (Math.random() * 1000)));
			logger.debug(n + " ");
		}
		logger.info("\nPre-order:");
		tree.print(1);
		logger.info("\nIn-order:");
		tree.print(2);
		logger.info("\nPost-order:");
		tree.print(3);
		logger.info("\nBreadth-First:");
		tree.breadth_first();
	}
}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
