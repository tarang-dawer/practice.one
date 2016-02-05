package com.tarang.practice.cdci.two;

import java.util.Random;

public class PartitionLinkedList {

	public class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		PartitionLinkedList p = new PartitionLinkedList();
		System.out.println("Old List");
		Node start = p.createLinkedList(10);
		p.printList(start);
		System.out.println("\nNew List");
		Node newList = p.partitionList(start, 50);
		p.printList(newList);

	}

	private Node partitionList(Node start, int x) {
		if (start == null)
			return null;

		Node small = null, smallPtr = null, large = null, largePtr = null;
		while (start != null) {
			if (start.value < x) {
				if (small == null) {
					small = start;
					start = start.next;
					small.next = null;
					smallPtr = small;
				} else {
					smallPtr.next = start;
					start = start.next;
					smallPtr = smallPtr.next;
					smallPtr.next = null;
				}

			} else {
				if (large == null) {
					large = start;
					start = start.next;
					large.next = null;
					largePtr = large;
				} else {
					largePtr.next = start;
					start = start.next;
					largePtr = largePtr.next;
					largePtr.next = null;
				}
			}
		}
		smallPtr.next = large;
		return small;
	}

	private Node createLinkedList(int n) {
		Node start = null, list = null;
		Random r = new Random();
		for (int i = n; i > -1; i--) {
			Node a = new Node(r.nextInt(90));
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

	private void printList(Node start) {
		while (start != null) {
			System.out.print(start.value + " ");
			start = start.next;
		}

	}
}
