package com.tarang.practice.cdci.two;

public class RemoveDuplicatesLinkedList {

	private class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		RemoveDuplicatesLinkedList r = new RemoveDuplicatesLinkedList();
		Node start = r.createLinkedList(10);
		System.out.println("Old List");
		r.printList(start);

		Node noDupes = r.removeDuplicates(start);
		System.out.println("\nNew List");
		r.printList(noDupes);

	}

	private void printList(Node start) {
		while (start != null) {
			System.out.print(start.value + " ");
			start = start.next;
		}

	}

	private Node removeDuplicates(Node list) {
		// if empty list, then return null
		if (list == null) {
			return null;
		}

		Node listStart = null;
		listStart = list;

		// if list contains only 1 element, then no duplicates
		if (list.next == null) {
			return listStart;
		}

		// continue till the next element is null
		while (list.next != null) {
			if (list.value == list.next.value) {
				// same value, so skip this element
				list.next = list.next.next;
			} else {
				list = list.next;
			}

		}
		return listStart;
	}

	private Node createLinkedList(int n) {
		return createLinkedList();
		// Node start = null, list = null;
		//
		// for (int i = 0; i < n; i++) {
		// Node a = new Node(i / 2);
		// a.next = null;
		// if (list != null) {
		// list.next = a;
		// list = a;
		// } else {
		// start = list = a;
		// }
		// }
		//
		// return start;

	}

	private Node createLinkedList() {
		Node start = new Node(0);
		Node a = start;
		start.next = new Node(0);
		start = start.next;
		start.next = new Node(3);
		start = start.next;
		start.next = new Node(3);
		start = start.next;
		start.next = new Node(3);
		start = start.next;
		start.next = new Node(3);
		start = start.next;
		return a;
	}
}
