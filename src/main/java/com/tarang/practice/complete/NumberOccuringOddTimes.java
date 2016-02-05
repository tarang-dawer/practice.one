package com.tarang.practice.complete;

public class NumberOccuringOddTimes {
	public static void main(String[] args) throws java.lang.Exception {
		int ar[] = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		int n = ar.length;
		System.out.println(getOddOccurrence(ar, n));
	}

	public static int getOddOccurrence(int ar[], int ar_size) {
		int i;
		int res = 0;
		for (i = 0; i < ar_size; i++)
			res = res ^ ar[i];

		return res;
	}
}