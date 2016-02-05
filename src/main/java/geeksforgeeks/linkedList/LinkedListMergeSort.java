package geeksforgeeks.linkedList;

public class LinkedListMergeSort {

	private class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		int[] array = { 8, 5, 2, 7, 6, 4, 3, 1 };
		LinkedListMergeSort l = new LinkedListMergeSort();
		Node list = l.createLinkedList(array);
		l.printList(list);
		System.out.println();
		Node res = l.mergeSort(list);
		l.printList(res);
		System.out.println();

	}

	private Node mergeSort(Node list) {

		Node sortedFirst = null, sortedSecond = null, partition = null;
		if (list == null || list.next == null)
			return list;

		partition = partitionList(list);
		sortedFirst = mergeSort(list);
		sortedSecond = mergeSort(partition);
		return mergeSortedLists(sortedFirst, sortedSecond);

	}

	private Node mergeSortedLists(Node list, Node newList) {

		Node sortedList = null, start = null;

		if (list != null && newList != null) {
			if (list.val < newList.val) {
				sortedList = mergeSortedLists(list.next, newList);
				start = list;
			} else {
				sortedList = mergeSortedLists(list, newList.next);
				start = newList;
			}
			start.next = sortedList;

			return start;

		} else if (list == null) {
			return newList;
		} else if (newList == null) {
			return list;
		} else {
			return null;
		}
	}

	private Node partitionList(Node list) {
		Node slow = list, fast = list, prev = null;
		while (slow != null && fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;
		return slow;
	}

	private Node createLinkedList(int[] array) {
		int size = array.length;

		Node list = null, start = null;
		while (size > 0) {
			Node newNode = new Node(array[array.length - size]);
			if (start == null) {
				start = newNode;
			} else {
				list.next = newNode;
			}
			list = newNode;
			size--;
		}
		return start;
	}

	private void printList(Node list) {
		int size1 = 0, size2 = 0;
		size1 = findIterativeLength(list);
		size2 = findRecursiveLength(list);
		while (list != null) {
			System.out.print(" " + list.val);
			list = list.next;
		}
		boolean res = false;
		if (size1 == size2)
			res = true;
		System.out.print("\tBoth sizes are " + res + ", Size: " + size2);

	}

	private int findRecursiveLength(Node list) {
		if (list != null)
			return findRecursiveLength(list.next) + 1;
		return 0;
	}

	private int findIterativeLength(Node list) {
		Node iter = list;
		int size = 0;
		while (iter != null) {
			size++;
			iter = iter.next;
		}
		return size;
	}

}
