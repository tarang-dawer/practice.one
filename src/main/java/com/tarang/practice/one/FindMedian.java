package com.tarang.practice.one;

//find median of two sorted arrays
public class FindMedian {
	public static void main(String[] args) {
		FindMedian f = new FindMedian();

		int[] a = { 1 };
		int[] b = { 1 };
		float x = f.findMedian(a, b);
		System.out.println(x);
	}

	public float findMedian(int[] a, int[] b) {
		if (a.length == 0 && b.length == 0)
			return -1.0f;
		else if (b.length == 0)
			return getSingleArrayMedian(a);
		else if (a.length == 0)
			return getSingleArrayMedian(b);

		int total = a.length + b.length;
		boolean odd = false;

		if (total % 2 != 0)
			odd = true;
		// loop till total/2
		int aPtr = 0, bPtr = 0;

		int median1 = -1, median2 = -1;
		for (int i = 0; i < total / 2 + 1; i++) {
			median2 = median1;
			if (aPtr < a.length && bPtr < b.length) {
				if (a[aPtr] < b[bPtr]) {
					median1 = a[aPtr];
					aPtr++;
				} else {
					median1 = b[bPtr];
					bPtr++;
				}
			} else if (aPtr < a.length) {
				median1 = a[aPtr];
				aPtr++;
			} else {// bPtr<b.length
				median1 = b[bPtr];
				bPtr++;
			}
		}
		if (odd) {
			return (float) median1;
		}
		return (float) ((median1 + median2) * 0.5);
	}

	private float getSingleArrayMedian(int[] a) {
		if (a.length % 2 != 0)
			return (float) a[a.length / 2];
		else
			return (float) (0.5 * (a[a.length / 2] + a[a.length / 2 - 1]));
	}
}