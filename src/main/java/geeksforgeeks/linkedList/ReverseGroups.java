package geeksforgeeks.linkedList;

public class ReverseGroups {
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
		ReverseGroups l = new ReverseGroups();
		Node list = l.createLinkedList(array);
		l.printList(list);
		System.out.println();
		System.out.println("Printing rev list:");
		Node res = l.reverseGroups(list,2);
		l.printList(res);
		System.out.println();

	}

	private Node reverseGroups(Node start, int groupSize) {

		int size = groupSize;
		Node iter = start, prev = null;
		if (iter == null)
			return null;
		while (iter != null && size-- > 0) {
			prev = iter;
			iter = iter.next;
		}
		prev.next = null;
		Node rev = reverse(start);
		Node rest = reverseGroups(iter, groupSize);
		iter = rev;

		while (iter != null) {
			prev = iter;
			iter = iter.next;
		}
		prev.next = rest;
		return rev;
	}

	private Node reverse(Node start) {
		Node iter = start, next = null, prev = null;
		if (start == null)
			return null;
		while (iter != null) {
			next = iter.next;
			iter.next = prev;
			prev = iter;
			iter = next;
		}
		return prev;

		// Node next = iter.next, current = iter;
		// current.next = null;
		// while (next != null) {
		// Node fwd = next.next;
		// next.next = current;
		// current = next;
		// next = fwd;
		// }
		// return current;
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

	private void printList(Node start) {
		Node list = start;
		while (list != null) {
			System.out.print(" " + list.val);
			list = list.next;
		}

	}
}
