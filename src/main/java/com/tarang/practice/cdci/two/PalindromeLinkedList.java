package com.tarang.practice.cdci.two;

import java.util.Stack;

public class PalindromeLinkedList {

	private class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		PalindromeLinkedList p = new PalindromeLinkedList();
		Node start = p.createPalindromeList();
		p.printList(start);
		boolean check = p.checkPalindromeList(start);
		if (check) {
			System.out.println("List is a palindrome");
		} else {
			System.out.println("List is a not palindrome");
		}
	}

	private boolean checkPalindromeList(Node start) {

		Stack<Integer> s = new Stack<Integer>();
		Node n1 = null, n2 = null;
		n1 = n2 = start;

		while (n2 != null && n2.next != null) {
			s.push(n1.value);
			n1 = n1.next;
			n2 = n2.next.next;
		}

		// if odd number of values, skip middle element
		if (n2 != null) {
			n1 = n1.next;
		}

		while (n1 != null) {
			if (n1.value != s.pop().intValue()) {
				return false;
			}
			n1 = n1.next;
		}
		return true;
	}

	private Node createPalindromeList() {
		Node start = null, next = null;
		start = new Node(0);
		next = new Node(1);
		start.next = next;
		next.next = new Node(2);
		next = next.next;
		next.next = new Node(3);
		next = next.next;
		next.next = new Node(4);
		next = next.next;
		next.next = new Node(3);
		next = next.next;
		next.next = new Node(2);
		next = next.next;
		next.next = new Node(1);
		next = next.next;
		next.next = new Node(0);
		next = next.next;
		next.next = null;
		return start;
	}

	private void printList(Node start) {
		while (start != null) {
			System.out.print(start.value + " ");
			start = start.next;
		}

	}
}
