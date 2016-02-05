package com.tarang.practice.cdci.two;

public class LoopedLinkedList {

	private class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		LoopedLinkedList l = new LoopedLinkedList();
		Node start = l.createLoopedLinkedList();
		System.out.println("Printing circular linked list");
		// l.printList(start);
		l.findLoopStartAndLength(start);

	}

	private void findLoopStartAndLength(Node start) {
		Node n1 = null, n2 = null;
		n1 = n2 = start;
		int size = 0;
		while (n2 != null && n2.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
			if (n1 == n2) {
				break;
			}
		}
		Node collidingPt = n1;

		n1 = start;
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		System.out.println("Loop begin: " + n2.value);
		n1 = n1.next;
		while (n1 != n2) {
			n1 = n1.next;
			size++;
		}
		System.out.println("Loop size: " + ++size);

	}

	private Node createLoopedLinkedList() {
		Node start = null, next = null, loopstart = null;
		start = new Node(0);
		next = new Node(1);
		start.next = next;
		next.next = new Node(2);
		next = next.next;
		next.next = new Node(3);
		next = next.next;
		next.next = new Node(4);
		next = next.next;
		loopstart = next;
		next.next = new Node(5);
		next = next.next;
		next.next = new Node(6);
		next = next.next;
		next.next = new Node(7);
		next = next.next;
		next.next = new Node(8);
		next = next.next;
		next.next = loopstart;
		return start;
	}

	private void printList(Node start) {
		while (start != null) {
			System.out.print(start.value + " ");
			start = start.next;
		}

	}

}
