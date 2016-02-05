package com.tarang.practice.one;

public class RecursiveMedian {
	public static void main(String[] args) {
		RecursiveMedian r = new RecursiveMedian();

		int[] a = { 1, 2, 4 };
		int[] b = { 1 };
		float x = 0.0f;
		int total = a.length + b.length;
		if (total % 2 != 0)
			x = r.findMedian(a, 0, a.length - 1, b, 0, b.length - 1,
					(a.length + b.length) / 2);
		else if (total != 0 && total % 2 == 0)
			x = (float) (0.5 * (r.findMedian(a, 0, a.length - 1, b, 0,
					b.length - 1, total / 2) + r.findMedian(a, 0, a.length - 1,
					b, 0, b.length - 1, total / 2 - 1)));
		System.out.println(x);
	}

	private float findMedian(int[] a, int aStart, int aEnd, int[] b,
			int bStart, int bEnd, int mid) {
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return b[bStart + mid];
		if (bLen == 0)
			return a[aStart + mid];
		if (mid == 0)
			return a[aStart] < b[bStart] ? a[aStart] : b[bStart];

		// i+j=mid i=aMid,j=bMid -> bMid=mid-aMid;
		int aMid = aLen * mid / (aLen + bLen); // a's middle count
		int bMid = mid - aMid - 1; // b's middle count

		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (a[aMid] > b[bMid]) {
			mid = mid - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			mid = mid - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}

		return findMedian(a, aStart, aEnd, b, bStart, bEnd, mid);
	}
}
