package com.tarang.practice.cdci.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks {

	private List<Stack<Integer>> setOfStacks;

	private int maxCapacity;

	public SetOfStacks(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		setOfStacks = new ArrayList<Stack<Integer>>(this.maxCapacity);
	}

	private int push(int value) {
		Stack<Integer> currentStack = getCurrentStack();
		if (currentStack == null || isFull()) {
			currentStack = createNewStack();
		}
		System.out.println("\nPushed: " + value);
		return currentStack.push(value);
	}

	private int popAt(int index) {
		Stack<Integer> reqdStack = null;
		try {
			reqdStack = setOfStacks.get(index);
		} catch (Exception e) {
			System.err.println("Sub stack not present");
			return -1;
		}
		if (reqdStack.isEmpty()) {
			System.err.println("Sub stack empty");
			return -1;
		} else {
			int value = reqdStack.pop();
			if (reqdStack.isEmpty()) {
				setOfStacks.remove(reqdStack);
			}
			return value;
		}
	}

	private int pop() {
		Stack<Integer> currentStack = getCurrentStack();
		if (currentStack == null) {
			System.out.println("Underflow..!!");
			return -1;
		}
		if (currentStack.isEmpty()) {
			System.err.println("stack removed");
			setOfStacks.remove(currentStack);
			return pop();
		}
		int value = currentStack.pop();
		System.out.println("\nPopped: " + value);
		return value;
	}

	private int peek() {
		Stack<Integer> currentStack = getCurrentStack();
		if (currentStack == null) {
			System.out.println("Underflow..!!");
		}
		return currentStack.peek();
	}

	private Stack<Integer> getCurrentStack() {
		if (setOfStacks.size() == 0) {
			return null;
		}
		return setOfStacks.get(setOfStacks.size() - 1);
	}

	private Stack<Integer> createNewStack() {
		Stack<Integer> newStack = new Stack<Integer>();
		setOfStacks.add(newStack);
		System.err.println("stack created");
		return newStack;
	}

	private boolean isFull() {
		Stack<Integer> current = getCurrentStack();
		if (current == null)
			return true;
		if (current.size() < maxCapacity)
			return false;
		return true;
	}

	public static void main(String[] args) {
		SetOfStacks s = new SetOfStacks(2);
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		s.push(7);
		s.push(8);
		s.push(9);
		s.push(10);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.popAt(1);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.popAt(1);
		s.pop();// 0
		s.pop();// underflow
		s.pop();// underflow
		s.popAt(1);
	}
}
