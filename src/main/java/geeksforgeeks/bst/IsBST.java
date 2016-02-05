package geeksforgeeks.bst;

class IsBST {
	private class Node {
		int val;
		Node right, left;

		private Node(int val) {
			this.val = val;
			right = null;
			left = null;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		IsBST ib = new IsBST();

		Node root = ib.createTree();

		System.out.println("given tree is a BST : "
				+ ib.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

	public Node createTree() {
		Node root = null;
		root = new Node(1);
		root.left = new Node(1);
		// root.right = new Node(5);
		// root.left.left = new Node(1);
		// root.right.left = new Node(3);
		return root;
	}

	public boolean isBST(Node root, int min, int max) {
		if (root == null)
			return true;
		return ((root.val < max) && (root.val > min)
				&& isBST(root.left, min, root.val) && isBST(root.right,
					root.val, max));

	}
}