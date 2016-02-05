package com.tarang.practice.cdci.three;

import java.util.Stack;

public class MinTrackingStack extends Stack<Integer> {

	Stack<Integer> minStack;

	public MinTrackingStack() {
		super();
		minStack = new Stack<Integer>();
	}

	public static void main(String[] args) {
		MinTrackingStack m = new MinTrackingStack();
		System.out.println("Value pushed : " + m.push(10));
		System.out.println("Value pushed : " + m.push(20));
		System.out.println("Value pushed : " + m.push(5));
		System.out.println("Value pushed : " + m.push(3));
		System.out.println("Value pushed : " + m.push(7));
		System.out.println("Value pushed : " + m.push(12));
		System.out.println("Value popped : " + m.pop());
		System.out.println("Value popped : " + m.pop());
		System.out.println("Value popped : " + m.pop());
		System.out.println("Value popped : " + m.pop());
		System.out.println("Value popped : " + m.pop());
		System.out.println("Value popped : " + m.pop());
		System.out.println("Value popped : " + m.pop());
		System.out.println("Value popped : " + m.pop());

	}

	public int push(int val) {
		if (min() > val) {
			minStack.push(val);
		}
		return super.push(val);

	}

	public Integer min() {
		if (super.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return minStack.peek();
		}
	}

	public Integer pop() {
		if (!super.isEmpty()) {
			int poppedVal = super.pop();
			int minVal = min();
			if (minVal == poppedVal) {
				minVal = minStack.pop();
			}
			System.out.println("popped Value : " + poppedVal
					+ ", Minval on stack now: " + min());
			return poppedVal;
		}
		throw new RuntimeException("Empty Stack");
	}
}
