package geeksforgeeks.bst;

/* package whatever; // don't place package name! */

/* Name of the class has to be "Main" only if the class is public. */
class SuccessorPredecessor {
	static int successor, predecessor;

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
		successor = -1;
		predecessor = -1;

		SuccessorPredecessor sp = new SuccessorPredecessor();

		Node root = sp.createTree();

		sp.successorPredecessor(root, 1);
		if (predecessor != -1) {
			System.out.println("Predecessor : " + predecessor);
		} else {
			System.out.println("No predecessors");
		}
		if (successor != -1) {
			System.out.println("Successor : " + successor);
		} else {
			System.out.println("No successor");
		}
	}

	public Node createTree() {
		Node root = null;
		root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		return root;
	}

	public void successorPredecessor(Node root, int key) {

		if (root == null) {
			System.out.println("No successor & predecessors");
			return;
		} else if (root.val == key) {
			if (root.left != null) {
				Node pre = root.left;
				while (pre.right != null) {
					pre = pre.right;
				}
				predecessor = pre.val;
			}

			if (root.right != null) {
				Node suc = root.right;
				while (suc.left != null) {
					suc = suc.left;
				}
				successor = suc.val;
			}
		} else if (root.val < key) {
			predecessor = root.val;
			successorPredecessor(root.right, key);
		} else {
			successor = root.val;
			successorPredecessor(root.left, key);

		}
	}
}