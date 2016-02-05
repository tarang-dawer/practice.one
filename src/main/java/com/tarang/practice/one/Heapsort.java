package com.tarang.practice.one;

public class Heapsort {

	public static int[] maxHeapify(int[] inputArray, int rootNodeID) {

		int largest = rootNodeID;
		int temp;
		if (rootNodeID > 0) {
			if (inputArray[2 * rootNodeID - 1] > inputArray[rootNodeID]) {
				largest = 2 * rootNodeID - 1;
			}

			if (inputArray[2 * rootNodeID] > inputArray[largest]) {
				largest = 2 * rootNodeID;
			}
			if (largest != rootNodeID) {
				// exchange the parent-child elements
				temp = inputArray[rootNodeID];
				inputArray[rootNodeID] = inputArray[largest];
				inputArray[largest] = temp;
			}
			inputArray = maxHeapify(inputArray,
					(int) Math.floor(rootNodeID / 2));
		}
		return inputArray;

	}

	public static int[] heapSort(int[] inputArray) {
		// build a max heap out of the array

		return buildMaxHeap(inputArray, inputArray.length);
		// extract the largest element and put it on last and then again call
		// maxheapify

	}

	public static int[] buildMaxHeap(int[] inputArray, int end) {
		for (int i = (int) Math.floor(end / 2); i >= 0; i--) {
			inputArray = maxHeapify(inputArray, i);
		}
		return inputArray;
	}

	public static void main(String[] args) {

		int inputArray[] = { 8, 3, 9, 4, 7, 1, 5 };

		int sortedArray[] = heapSort(inputArray);
		for (int i = 0; i < inputArray.length; i++)
			System.out.println(sortedArray[i]);
	}
}
