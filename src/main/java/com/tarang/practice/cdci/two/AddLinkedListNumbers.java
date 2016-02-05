package com.tarang.practice.cdci.two;

import java.util.Random;

public class AddLinkedListNumbers {

	private class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		AddLinkedListNumbers a = new AddLinkedListNumbers();
		System.out.println("1st num");
		Node n1 = a.createLinkedList(3);
		a.printList(n1);
		System.out.println("\n2nd num");
		Node n2 = a.createLinkedList(3);
		a.printList(n2);
		System.out.println("\nAddition result");
		Node res = a.addLinkedLists(n1, n2);
		a.printList(res);
	}

	public Node addLinkedLists(Node n1, Node n2) {
		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;
		Node res = null, start = null;
		int carry = 0, result = 0;

		while (n1 != null && n2 != null) {
			result = n1.value + n2.value + carry;
			if (result > 9) {
				carry = 1;
				result = result - 10;
			} else {
				carry = 0;
			}
			if (res == null) {
				res = new Node(result);
				res.next = null;
				start = res;
			} else {
				res.next = new Node(result);
				res = res.next;
			}
			if (n1 != null)
				n1 = n1.next;
			if (n2 != null)
				n2 = n2.next;
		}
		if (n1 != null) {
			result = n1.value + carry;
			if (result > 9) {
				carry = 1;
				result = result - 10;
			} else {
				carry = 0;
			}

			res.next = new Node(result);
			res = res.next;

		}
		if (n2 != null) {
			result = n2.value + carry;
			if (result > 9) {
				carry = 1;
				result = result - 10;
			} else {
				carry = 0;
			}

			res.next = new Node(result);
			res = res.next;

		}
		if (carry == 1) {
			res.next = new Node(carry);
			res = res.next;
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
