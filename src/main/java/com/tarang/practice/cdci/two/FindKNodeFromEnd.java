package com.tarang.practice.cdci.two;

public class FindKNodeFromEnd {

	private class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		FindKNodeFromEnd f = new FindKNodeFromEnd();
		Node start = f.createLinkedList(10);
		f.printList(start);
		Node node = f.getLastKnode(start, 9);
		System.out.println("\n");
		f.printList(node);
	}

	private void printList(Node start) {
		while (start != null) {
			System.out.print(start.value + " ");
			start = start.next;
		}

	}

	private Node getLastKnode(Node start, int k) {
		Node p1 = null, p2 = null;
		if (start == null) {
			return null;
		}
		p1 = p2 = start;

		for (int i = 0; i < k; i++) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;

		}
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	private Node createLinkedList(int n) {
		Node start = null, list = null;

		for (int i = 0; i < n; i++) {
			Node a = new Node(i / 2);
			a.next = null;
			if (list != null) {
				list.next = a;
				list = a;
			} else {
				start = list = a;
			}
		}

		return start;
	}
}
