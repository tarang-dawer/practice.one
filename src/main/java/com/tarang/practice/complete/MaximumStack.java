package com.tarang.practice.complete;

public class MaximumStack {

	private int sizeMain = -1;
	// private int sizeMax = 0;
	private int mainStack[];
	private int maxStack[];

	private static final int DEFAULT_CAPACITY = 10;

	public MaximumStack() {
		mainStack = new int[DEFAULT_CAPACITY];
		maxStack = new int[DEFAULT_CAPACITY];
	}

	public void push(int x) {
		// push the element on main stack, compare it with the top element of
		// maxstack, if bigger then push it also on maxstack otherwise push the
		// already top element of the maxstack on the
		// maxstack again
		// if (sizeMain < DEFAULT_CAPACITY) {

		int element;
		try {
			element = returnTop(maxStack);
			if (x < element) {
				pushPreviousOnMax(x, element);
				// pushMaxStack(element);
			} else {
				pushNewOnBoth(x);
			}
		} catch (RuntimeException rte) {
			// stack underflow
			// System.out.println(rte.getMessage());
			pushNewOnBoth(x);
		}

	}

	// }(x);
	private void pushNewOnBoth(int x) {
		if (sizeMain < DEFAULT_CAPACITY) {
			mainStack[++sizeMain] = x;
			maxStack[sizeMain] = x;
			return;
		}
		throw new RuntimeException("Stack already full");

	}

	private void pushPreviousOnMax(int x, int element) {
		if (sizeMain < DEFAULT_CAPACITY) {
			mainStack[++sizeMain] = x;
			maxStack[sizeMain] = element;
			return;
		}
		throw new RuntimeException("Stack already full");

	}

	public int pop() {
		if (sizeMain > -1)
			return mainStack[sizeMain--];
		throw new RuntimeException("Stack Underflow");
	}

	/*
	 * public int pop(int[] stack) { if (sizeMain > 0) return stack[--sizeMain];
	 * throw new RuntimeException("Underflow"); }
	 */
	/*
	 * private void push(int x, int[] stack) { if (sizeMain < DEFAULT_CAPACITY)
	 * { stack[++sizeMain] = x; return; } throw new
	 * RuntimeException("Stack already full"); }
	 */

	public int returnTop(int[] stack) {
		if (sizeMain > 0)
			return stack[sizeMain];
		throw new RuntimeException("Empty Stack");

	}

	public int returnMax() {
		if (sizeMain > -1)
			return maxStack[sizeMain];
		throw new RuntimeException("Stack Underflow");
	}

	public static void main(String[] args) {

		int[] array = { 1, 5, 4, 3, 6, 2 };
		MaximumStack ms = new MaximumStack();
		for (int i = 0; i < array.length; i++) {
			try {
				ms.push(array[i]);
			} catch (RuntimeException rte) {
				System.out
						.println("Error while pushing  : " + rte.getMessage());
			}

			System.out.println("Maximum Value till now: " + ms.returnMax());
		}

		// ms.showStack();
		System.out.println("Popped Value " + ms.pop());
		System.out.println("Maximum Value now: " + ms.returnMax());

		System.out.println("Popped Value " + ms.pop());
		System.out.println("Maximum Value now: " + ms.returnMax());

		System.out.println("Popped Value " + ms.pop());
		System.out.println("Maximum Value now: " + ms.returnMax());
	}

	/*
	 * private void showStack() { System.out.println("\n\n Main Stack"); for
	 * (int i = 0; i <= sizeMain; i++) System.out.println(mainStack[i]);
	 * 
	 * System.out.println("\n\n Max Stack"); for (int i = 0; i <= sizeMain; i++)
	 * System.out.println(maxStack[i]);
	 * 
	 * }
	 */
}
