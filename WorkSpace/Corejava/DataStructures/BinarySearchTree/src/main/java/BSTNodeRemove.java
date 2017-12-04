import org.apache.log4j.Logger;

public class BSTNodeRemove {
	public BSTNodeRemove left, right;
	public Comparable data;
	static Logger logger = Logger.getLogger(BSTNodeRemove.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BSTNodeRemove tree_AddNumber(BSTNodeRemove r, Comparable n) {
		if (r == null) {
			r = new BSTNodeRemove();
			r.left = r.right = null;
			r.data = n;
		} else if (r.data.compareTo(n) < 0)
			r.right = tree_AddNumber(r.right, n);
		else if (r.data.compareTo(n) > 0)
			r.left = tree_AddNumber(r.left, n);
		return r;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static BSTNodeRemove tree_removeNumber(BSTNodeRemove r, Comparable n) {
		if (r != null) {
			if (r.data.compareTo(n) < 0) {
				r.right = tree_removeNumber(r.right, n);
			} else if (r.data.compareTo(n) > 0) {
				r.left = tree_removeNumber(r.left, n);
			} else {
				if (r.left == null && r.right == null) {
					r = null;
				} else if (r.left != null && r.right == null) {
					r = r.left;
				} else if (r.right != null && r.left == null) {
					r = r.right;
				} else {
					if (r.right.left == null) {
						r.right.left = r.left;
						r = r.right;
					} else {
						BSTNodeRemove q, p = r.right;
						while (p.left.left != null)
							p = p.left;
						q = p.left;
						p.left = q.right;
						q.left = r.left;
						q.right = r.right;
						r = q;
					}
				}
			}
		}
		return r;
	}

	public static void tree_InOrderPrint(BSTNodeRemove r) {
		if (r != null) {
			tree_InOrderPrint(r.left);
			logger.debug(" " + r.data);
			tree_InOrderPrint(r.right);
		}
	}

	public static void main(String[] args) {
		BSTNodeRemove tree = null;
		int[] numbers = { 56, 86, 71, 97, 82, 99, 65, 36, 16, 10, 28, 52, 46 };
		logger.info("inserting: ");
		for (int i = 0; i < numbers.length; i++) {
			Integer n = new Integer(numbers[i]);
			logger.debug(" " + n);
			tree = tree_AddNumber(tree, n);
		}
		logger.info("\ntree: ");
		tree_InOrderPrint(tree);
		for (int j = 0; j < numbers.length; j++) {
			Integer n = new Integer(numbers[j]);
			logger.debug("\nremove: " + n + " tree: ");
			tree = tree_removeNumber(tree, n);
			tree_InOrderPrint(tree);
		}
		logger.info("\ndone ;-)");
	}
}
