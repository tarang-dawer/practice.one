package com.tarang.practice.complete;

import java.io.*;
import java.util.*;

public class SameGenerationNodes {

	private static class TreeNode {
		String name;
		TreeNode left;
		TreeNode right;

		TreeNode(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) throws IOException {

		TreeNode tree = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;

		// a->b,a->c,b->d,b->e,c->f,c->g,2
		while ((s = in.readLine()) != null) {

			String[] ancestorList = s.split(",");

			int numberOfAncestorPairs = ancestorList.length - 1;
			int level = Integer.valueOf(ancestorList[numberOfAncestorPairs]);

			for (int i = 0; i < numberOfAncestorPairs; i++) {
				String[] pair = ancestorList[i].split("->");
				String parent = pair[0];
				String child = pair[1];
				tree = addToTree(tree, parent, child);
			}

			// printTree
			// printTree(tree);
			List<String> nodeList = new ArrayList<String>();
			printSameLevelNodes(tree, level, nodeList);
			System.out.println(nodeList.toString());

		}
	}

	public static void printTree(TreeNode tree) {
		if (tree != null) {

			System.out.println(tree.name);
			printTree(tree.left);
			printTree(tree.right);
		}
	}

	public static TreeNode addToTree(TreeNode tree, String parent, String child) {
		if (tree == null) {
			tree = new TreeNode(parent);
			tree.left = new TreeNode(child);
			return tree;
		} else if (tree.name.equals(parent)) {
			if (tree.left == null) {
				tree.left = new TreeNode(child);
			} else {
				tree.right = new TreeNode(child);
			}
		} else if (tree.left.name.equals(parent)) {
			addToTree(tree.left, parent, child);
		} else if (tree.right.name.equals(parent)) {
			addToTree(tree.right, parent, child);
		}
		return tree;

	}

	public static void printSameLevelNodes(TreeNode tree, int level,
			List nodeList) {
		if (tree != null) {
			if (level == 0) {
				nodeList.add(tree.name);
				return;
			} else {
				printSameLevelNodes(tree.left, level - 1, nodeList);
				printSameLevelNodes(tree.right, level - 1, nodeList);
			}
		}

	}
}
