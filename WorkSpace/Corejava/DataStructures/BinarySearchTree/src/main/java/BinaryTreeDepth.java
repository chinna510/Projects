import org.apache.log4j.Logger;

public class BinaryTreeDepth {
	static Logger logger = Logger.getLogger(BinaryTreeDepth.class);
	public BinaryTreeDepth left, right;
	public Integer data;
	private static int tree_depth, curr_depth = 0;
	public static int[] numbers = { 7, 3, 11, 2, 5, 9, 12, 4, 6, 8, 10 };

	public static BinaryTreeDepth add(BinaryTreeDepth r, Integer n) {
		if (r == null) {
			r = new BinaryTreeDepth();
			r.left = r.right = null;
			r.data = n;
		} else if (r.data.compareTo(n) < 0)
			r.right = add(r.right, n);
		else
			r.left = add(r.left, n);
		return r;
	}

	public static void print(BinaryTreeDepth r) {
		if (r != null) {
			print(r.left);
			logger.info(" " + r.data);
			print(r.right);
		}
	}

	public static void _getdepth(BinaryTreeDepth r) {
		if (r != null) {
			curr_depth++;
			if (curr_depth > tree_depth)
				tree_depth = curr_depth;
			_getdepth(r.left);
			_getdepth(r.right);
			curr_depth--;
		}
	}

	public static int getdepth(BinaryTreeDepth r) {
		tree_depth = 0;
		_getdepth(r);
		return tree_depth;
	}

	public static void main(String[] args) {
		BinaryTreeDepth tree = null;
		logger.info("inserting: ");
		for (int i = 0; i < numbers.length; i++) {
			Integer n = new Integer(numbers[i]);
			logger.info(" " + n);
			tree = add(tree, n);
		}
		logger.info("\ntree: ");
		print(tree);
		logger.info("\ndepth: " + getdepth(tree));
		logger.info("\ndone ;-)");
	}
}
