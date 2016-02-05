package com.tarang.practice.cdci.two;

import java.util.Random;

public class AddLinkedListsSerialOrder {
	private class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		AddLinkedListsSerialOrder a = new AddLinkedListsSerialOrder();
		System.out.println("1st num");
		Node n1 = a.createLinkedList(3);
		a.printList(n1);
		System.out.println("\n2nd num");
		Node n2 = a.createLinkedList(6);
		a.printList(n2);
		System.out.println("\nAddition result");
		Node res = a.addLinkedLists(n1, n2);
		a.printList(res);

	}

	private Node addLinkedLists(Node n1, Node n2) {
		Node ptr1 = n1, ptr2 = n2;
		int reqdZeros = 0;
		int a = 0, b = 0;
		while (ptr1 != null) {
			a++;
			ptr1 = ptr1.next;
		}
		while (ptr2 != null) {
			b++;
			ptr2 = ptr2.next;
		}
		if (a > b)// n1 is of greater length than n2
		{
			reqdZeros = a - b;
			// pad n2 with reqdZeros
			n2 = addZeroNodes(n2, reqdZeros);
		} else if (b > a) {
			reqdZeros = b - a;
			// pad n1 with reqdZeros
			n1 = addZeroNodes(n1, reqdZeros);
		}

		Node res = null, start = null;
		int carry = 0, result = 0;
		return addRecursively(n1, n2, 0);
	}

	private Node addRecursively(Node n1, Node n2, int recursiveDepth) {
		if (n1 == null || n2 == null)
			return null;

		Node res = null;
		if (n1.next != null && n2.next != null) {
			res = addRecursively(n1.next, n2.next, recursiveDepth+1);
		} else {
			// last node
			return new Node(n1.value + n2.value);
		}
		int carry = 0;
		if (res.value > 9) {
			res.value = res.value - 10;
			carry = 1;
		}
		int result = n1.value + n2.value + carry;

		boolean rootcall = false;

		// determine if the extra digit needs be added to the answer
		if (recursiveDepth == 0) {
			rootcall = true;
		}
		if (rootcall) {
			if (result > 9) {
				Node res1 = new Node(result % 10);
				res1.next = res;
				Node res2 = new Node(1);
				res2.next = res1;
				return res2;
			}
		}
		Node res1 = new Node(result);
		res1.next = res;
		return res1;

	}

	private Node addZeroNodes(Node n, int reqdZeros) {

		Node start = null, list = null;
		for (int i = 0; i < reqdZeros; i++) {
			Node zero = new Node(0);
			if (start == null) {
				start = list = zero;
			} else {
				list.next = zero;
				list=list.next;
			}
		}
		list.next = n;
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
