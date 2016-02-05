package com.tarang.practice.cdci.three;

public class ThreeStacks {

	int[] stackPtrs = { -1, -1, -1 };
	int stackCapacity;
	int[] stackBuffer;

	public ThreeStacks(int stackCapacity) {
		this.stackCapacity = stackCapacity;
		stackBuffer = new int[3 * this.stackCapacity];
	}

	public static void main(String[] args) {
		ThreeStacks t = new ThreeStacks(10);
		t.push(1, 10);
		t.push(1, 20);
		t.push(1, 30);
		t.push(2, 40);
		t.push(2, 50);
		t.push(3, 60);
		t.push(3, 70);
		t.pop(1);
		t.pop(1);
		t.peek(1);
		t.pop(1);
		t.pop(2);
		t.pop(2);
		t.pop(2);
		t.pop(3);
		t.pop(3);
		t.pop(3);
		t.peek(1);
	}

	private void pop(int stackNum) {
		if (stackPtrs[stackNum - 1] < 0) {
			System.out.println("UnderFlow..!!!");
			return;
		}
		System.out.println(stackBuffer[getAbsTop(stackNum)]);
		stackPtrs[stackNum - 1]--;
	}

	// returns the existing top position
	private int getAbsTop(int stackNum) {
		return ((stackNum - 1) * stackCapacity) + stackPtrs[stackNum - 1];
	}

	private int peek(int stackNum) {
		if (stackPtrs[stackNum - 1] < 0) {
			System.out.println("Empty Stack..!!");
			return -1;
		} else {
			return stackBuffer[getAbsTop(stackNum)];
		}
	}

	private void push(int stackNum, int val) {
		if (stackPtrs[stackNum - 1] + 1 < stackCapacity) {
			stackBuffer[getAbsTop(stackNum) + 1] = val;
			stackPtrs[stackNum - 1]++;
		} else {
			throw new RuntimeException("Buffer outflow, value : " + val
					+ " not stored in stack : " + stackNum);
		}
	}
}
