package com.tarang.practice.cdci.three;

import java.util.Stack;

//queue using two stacks
public class MyQueue {

	private Stack<Integer> newStack, oldStack;

	public MyQueue() {
		this.newStack = new Stack<Integer>();
		this.oldStack = new Stack<Integer>();
	}

	public static void main() {

	}

	public int size() {
		return newStack.size() + oldStack.size();
	}

	public void push(int val) {
		this.newStack.push(val);
	}

	public int remove() {
		shiftStacks();
		return oldStack.pop();
	}

	public int peek() {
		shiftStacks();
		return oldStack.peek();
	}

	private void shiftStacks() {
		if (oldStack.isEmpty()) {
			while (!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
		return;
	}

}
