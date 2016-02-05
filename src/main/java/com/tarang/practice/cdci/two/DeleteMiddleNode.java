package com.tarang.practice.cdci.two;

//access given to only the middle node

public class DeleteMiddleNode {

	private class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		DeleteMiddleNode d = new DeleteMiddleNode();
		Node start = d.createLinkedList(10);
		d.printList(start);
		Node node = d.deleteMiddleNode(start.next.next.next.next);
		System.out.println("\n");
		d.printList(start);
	}

	private void printList(Node start) {
		while (start != null) {
			System.out.print(start.value + " ");
			start = start.next;
		}

	}

	private Node deleteMiddleNode(Node middle) {
		if (middle == null || middle.next == null)
			return null;

		middle.value = middle.next.value;
		middle.next = middle.next.next;
		return middle;
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
