package geeksforgeeks.bst;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Successor {

	static int successor = -1;

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

		Successor ib = new Successor();

		Node root = ib.createTree();
		ib.getSuccessor(root, 4);
		System.out.println("given tree is a BST : " + successor);
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

	public void getSuccessor(Node root, int key) {
		if (root == null)
			successor = -1;

		else if (key < root.val) {
			successor = root.val;
			getSuccessor(root.left, key);
		} else if (key > root.val) {

			getSuccessor(root.right, key);
		}

		else {
			if (root.right == null)
				return;
			else {
				Node suc = root.right;
				while (suc.right != null) {
					suc = suc.right;
				}
				successor = suc.val;
			}
		}
	}
}