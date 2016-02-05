package misc;

public class BSTMaxSum {

	private class TreeNode {
		private int val;
		private TreeNode left = null, right = null;

		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int maxPathSum(TreeNode root) {
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}

	public int calculateSum(TreeNode root, int[] max) {
		if (root == null)
			return 0;

		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int current = Math.max(root.val,
				Math.max(root.val + left, root.val + right));

		// Math.max(current, left + root.val + right) represents the sum when
		// the Node under consideration is the root of the maxsum path and no
		// ancestors of root are there in max sum path
		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

		return current;
	}
}
