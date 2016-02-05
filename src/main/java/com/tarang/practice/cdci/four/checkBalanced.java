package com.tarang.practice.cdci.four;

public class checkBalanced {

	private class TreeNode {
		int value;
		TreeNode right;
		TreeNode left;

		private TreeNode(int val, TreeNode l, TreeNode r) {
			this.value = val;
			this.left = l;
			this.right = r;
		}
	}

	public static void main(String[] args) {
		checkBalanced c = new checkBalanced();
		TreeNode root = c.createTree();
		System.out.println(c.isBalanced(root));

	}

	private TreeNode createTree() {
		TreeNode r1 = new TreeNode(3, null, null);
		TreeNode r2 = new TreeNode(4, null, null);
		TreeNode l1 = new TreeNode(5, null, null);
		TreeNode l2 = new TreeNode(6, null, null);
		TreeNode r = new TreeNode(1, r1, r2);
		TreeNode l = new TreeNode(2, l1, l2);
		TreeNode root = new TreeNode(0, l, r);
		return root;
	}

	public static boolean isBalanced(TreeNode root) {
		if (checkHeight(root) == -1) {
			return false;
		} else {
			return true;
		}
	}

	private static int checkHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}

		int heightDiff = leftHeight - rightHeight;

		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
}
