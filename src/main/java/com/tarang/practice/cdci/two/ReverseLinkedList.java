package com.tarang.practice.cdci.two;

import java.util.Random;

public class ReverseLinkedList {

	private class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		System.out.println("list");
		Node n1 = r.createLinkedList(5);
		r.printList(n1);
		System.out.println("\nreversed list");
		n1 = r.reverseLinkedList(n1);
		r.printList(n1);
	}

	private Node reverseLinkedList(Node n1) {
		Node start = null, next = null, traverse = null;

		next = start = traverse = n1;
		traverse = next.next;
		start.next = null;

		while (traverse != null) {
			next = traverse.next;
			traverse.next = start;
			start=traverse;
			traverse = next;
		}

		return start;
	}

	private Node createLinkedList(int n) {
		Node start = null, list = null;
		Random r = new Random();
		for (int i = n; i > 0; i--) {
			Node a = new Node(r.nextInt(9));
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
