package geeksforgeeks.arrays;

public class Median2SortedArrays {
	public static void main(String[] args) {
		int a[] = { 3, 6, 8, 10, 13 };
		int b[] = { 3, 4, 5, 5, 9, 11 };
		// 3 3 4 5 5 6 8 9 10 11 13

		Median2SortedArrays m = new Median2SortedArrays();
		float med;
		if ((a.length + b.length) % 2 != 0) // odd
			med = m.getMedian((a.length + b.length) / 2, a, 0, a.length - 1, b,
					0, b.length - 1);
		else { // even
			med = (float) ((m.getMedian((a.length + b.length) / 2, a, 0,
					a.length - 1, b, 0, b.length - 1) + m.getMedian(
					(a.length + b.length) / 2 - 1, a, 0, a.length - 1, b, 0,
					b.length - 1)) * 0.5);
		}
		System.out.println("Median is : " + med);

	}

	private float getMedian(int midPos, int[] a, int aStart, int aEnd, int[] b,
			int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		if (aLen == 0)
			return b[bStart + midPos];
		if (bLen == 0)
			return a[aStart + midPos];
		if (midPos == 0)
			return a[aStart] < b[bStart] ? a[aStart] : b[bStart];

		int aMid = aLen * midPos / (aLen + bLen);
		int bMid = midPos - aMid - 1; // midPos - (aLen * midPos / (aLen+bLen))
										// = midPos * bLen / (aLen+bLen)

		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (a[aMid] > b[bMid]) {
			midPos = midPos - (bMid - bStart + 1); // b/2+b/2 + a/2+a/2=>
													// b/2+a/2 => mid pt gets
													// shifted by b/2
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			midPos = midPos - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		return getMedian(midPos, a, aStart, aEnd, b, bStart, bEnd);
		/*
		 * int aPos = -1, bPos = -1, aMed = -1, bMed = -1;
		 * 
		 * aPos = aStart + (aEnd - aStart) / 2; bPos = bStart + (bEnd - bStart)
		 * / 2;
		 * 
		 * if ((aEnd - aStart) % 2 == 0) aMed = a[aPos]; else { aMed = (a[aPos]
		 * + a[aPos + 1]) / 2; // aPos++; } if ((bEnd - bStart) % 2 == 0) bMed =
		 * b[bPos]; else { bMed = (b[bPos] + b[bPos + 1]) / 2; // bPos++; } if
		 * (aMed == bMed) return aMed; else if (aMed < bMed) { return
		 * getMedian(a, aPos + 1, aEnd, b, bStart, bPos - 1); } else { return
		 * getMedian(a, aStart, aPos - 1, b, bPos + 1, bEnd); }
		 */

	}

}
