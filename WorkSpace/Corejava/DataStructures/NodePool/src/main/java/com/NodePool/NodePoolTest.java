<<<<<<< HEAD
package com.NodePool;

import org.apache.log4j.Logger;

public class NodePoolTest {
	static Logger logger = Logger.getLogger(NodePoolTest.class);

	public static void main(String[] args) {
		NodePoolSortArray tree = new NodePoolSortArray(100);
		int i, n;
		logger.info("Numbers inserted:");
		for (i = 0; i < 10; i++) {
			tree.insert(new Integer(n = (int) (Math.random() * 1000)));
			System.out.print(n + " ");
		}
		logger.info("\nPre-order:");
		tree.print(1);
		logger.info("\nIn-order:");
		tree.print(2);
		logger.info("\nPost-order:");
		tree.print(3);
	}

}
=======
package com.NodePool;

import org.apache.log4j.Logger;

public class NodePoolTest {
	static Logger logger = Logger.getLogger(NodePoolTest.class);

	public static void main(String[] args) {
		NodePoolSortArray tree = new NodePoolSortArray(100);
		int i, n;
		logger.info("Numbers inserted:");
		for (i = 0; i < 10; i++) {
			tree.insert(new Integer(n = (int) (Math.random() * 1000)));
			System.out.print(n + " ");
		}
		logger.info("\nPre-order:");
		tree.print(1);
		logger.info("\nIn-order:");
		tree.print(2);
		logger.info("\nPost-order:");
		tree.print(3);
	}

}
>>>>>>> 90cd61fa7aa17f62cabddcf0daedd981d681e805
