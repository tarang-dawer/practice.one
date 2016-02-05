package com.tarang.practice.cdci.three;

import java.util.Stack;

public class SortStack {

	private Stack<Integer> mainStack = null, sortedStack = null;

	public SortStack() {
		mainStack = new Stack<Integer>();
		sortedStack = new Stack<Integer>();
	}

	public static void main(String[] args) {
		SortStack s = new SortStack();
		s.fillStack();
		s.sortStack();
		s.printStack();
	}

	private void printStack() {
		System.out.println("Printing sorted stack");
		while (!sortedStack.isEmpty()) {
			System.out.print(sortedStack.pop() + " ");
		}

	}

	private void sortStack() {
		int temp;

		while (!mainStack.isEmpty()) {
			temp = mainStack.pop();
			while (!sortedStack.isEmpty() && sortedStack.peek() >= temp) {
				mainStack.push(sortedStack.pop());
			}
			sortedStack.push(temp);
		}

	}

	private void fillStack() {
		mainStack.push(9);
		mainStack.push(6);
		mainStack.push(4);
		mainStack.push(5);
		mainStack.push(2);
		mainStack.push(7);
		mainStack.push(0);
		mainStack.push(3);
		mainStack.push(1);
		mainStack.push(8);
	}

}
