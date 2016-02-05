package geeksforgeeks.arrays;

public class SearchSortedRotatedArray {

	public static void main(String[] args) {
		SearchSortedRotatedArray s = new SearchSortedRotatedArray();

		int[] arr = { 2, 3, 4, 5, 1 };
		int pos = s.binarySearch(arr, 1, 0, arr.length - 1);
		if (pos == -1) {
			System.out.println("Element not present");
			System.exit(-1);
		}
		System.out.println("Element is at position: " + pos + " ,element: "
				+ arr[pos]);

	}

	private int binarySearch(int[] arr, int element, int start, int end) {
		int pos = -1;
		boolean firstHalfSorted = false;
		if (start <= end) {
			int mid = (start + end) / 2;

			if (arr[start] <= arr[mid]) {
				firstHalfSorted = true;
			}
			if (element == arr[mid]) {
				return mid;
			} else if (firstHalfSorted) {
				if (element >= arr[start] && element <= arr[mid - 1])
					pos = binarySearch(arr, element, start, mid - 1);
				else
					pos = binarySearch(arr, element, mid + 1, end);

			} else {
				if (element >= arr[mid + 1] && element <= arr[end])
					pos = binarySearch(arr, element, mid + 1, end);
				else
					pos = binarySearch(arr, element, start, mid - 1);
			}
			return pos;
		}
		return -1;
	}

}
