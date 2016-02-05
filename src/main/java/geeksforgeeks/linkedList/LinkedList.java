package geeksforgeeks.linkedList;

public class LinkedList {

	private class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		LinkedList l = new LinkedList();
		Node list = l.createLinkedList(array);
		l.printList(list);
		System.out.println();
		list = l.insert(9, list);
		l.printList(list);
		System.out.println();
		list = l.insertAtPos(10, 1, list);
		l.printList(list);
		System.out.println();
		l.delete(9, list);
		l.printList(list);
		System.out.println();
		l.deleteAtPos(1, list);
		l.printList(list);
		System.out.println();
		System.out.println("Iterative reverse");
		Node rev = null;
		rev = list = l.iterReverse(list);
		l.printList(rev);
		System.out.println();
		System.out.println("Recursive reverse");
		list = rev = l.recReverse(list);
		l.printList(rev);
		System.out.println();
		list = l.createLinkedList(array);
		l.swapElements(4, 7, list);
		l.printList(list);

		int[] arrayNew = { 9, 10, 11, 12, 13, 14, 15, 16 };
		// LinkedList l1 = new LinkedList();
		Node list1 = l.createLinkedList(array);
		System.out.println();
		System.out.println("Merging sorted lists");
		Node res = l.mergeSortedLists(list, list1);
		l.printList(res);
		System.out.println();

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

			Node l = sortedList;
			if (sortedList != start)
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

	private Node recReverse(Node start) {

		Node first = start;
		if (first == null)
			return null;
		else if (first.next == null)
			return first;

		Node restRev = recReverse(start.next);
		Node iter = restRev;
		while (iter.next != null)
			iter = iter.next;
		iter.next = first;
		first.next = null;
		return restRev;

	}

	private Node iterReverse(Node start) {
		Node iter = start;
		if (iter == null)
			return iter;
		Node next = iter.next, current = iter;
		current.next = null;
		while (next != null) {
			Node fwd = next.next;
			next.next = current;
			current = next;
			next = fwd;
		}
		return current;
	}

	private void swapElements(int a, int b, Node start) {
		Node iter = start, prev = null, aPrev = null, bPrev = null;
		while (iter != null) {
			if (iter.val == a) {
				aPrev = prev;
			}
			if (iter.val == b) {
				bPrev = prev;
			}
			prev = iter;
			iter = iter.next;
		}
		if (aPrev == null || bPrev == null) {
			System.out.println("Incorrect input");
			return;
		} else {
			Node tempA = null, tempB = null, aNext = null, bNext = null;
			tempA = aPrev.next;
			aNext = tempA.next;
			tempB = bPrev.next;
			bNext = tempB.next;

			aPrev.next = tempB;
			tempB.next = aNext;
			bPrev.next = tempA;
			tempA.next = bNext;

			return;
		}

	}

	private void delete(int val, Node list) {
		Node prev = list, iter = list;
		if (iter == null)
			return;

		while (iter.val != val) {
			prev = iter;
			iter = iter.next;
		}
		prev.next = iter.next;
	}

	private void deleteAtPos(int pos, Node list) {
		Node prev = list, iter = list;
		if (iter == null)
			return;
		// int counter = 0;

		if (pos == 0) {
			list = list.next;
		} else {
			while (pos-- != 0) {
				prev = iter;
				iter = iter.next;
			}
			prev.next = iter.next;
		}
	}

	private Node insert(int val, Node list) {
		if (list == null)
			return new Node(val);

		Node prev = null, iter = list;
		while (iter != null) {
			prev = iter;
			iter = iter.next;
		}
		prev.next = new Node(val);
		return list;

	}

	private Node insertAtPos(int val, int pos, Node list) {
		if (list == null)
			return new Node(val);
		if (pos == 0) {
			Node newNode = new Node(val);
			newNode.next = list;
			list = newNode;
			return list;
		}

		int counter = 0;
		Node prev = null, iter = list;
		while (counter != pos) {
			prev = iter;
			iter = iter.next;
			counter++;
		}
		prev.next = new Node(val);
		prev = prev.next;
		prev.next = iter;
		return list;

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
