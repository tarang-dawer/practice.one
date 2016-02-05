package geeksgorgeeks.doublyLinkedLists;

public class ReverseDoublyList {

	private class Node {
		int val;
		Node prev;
		Node next;

		public Node(int val) {
			this.val = val;
			this.prev = null;
			this.next = null;
		}

	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		ReverseDoublyList l = new ReverseDoublyList();
		Node list = l.createLinkedList(array);
		l.printList(list);
		System.out.println();
		System.out.println("Printing rev list:");
		Node res = l.reverseDoublyList(list);
		l.printList(res);
		System.out.println();
	}

	private Node reverseDoublyList(Node start) {
		if (start == null)
			return null;

		Node temp = null;

		temp = start.next;
		start.next = start.prev;
		start.prev = temp;

		Node res = reverseDoublyList(temp);
		if (res == null)
			return start;
		return res;
	}

	private Node createLinkedList(int[] array) {
		int size = array.length;

		Node list = null, start = null, newNode = null;
		while (size > 0) {
			newNode = new Node(array[array.length - size]);
			if (start == null) {
				start = newNode;
			} else {
				newNode.prev = list;
				list.next = newNode;
			}
			// if (size == 5) {
			// loopNode = newNode;
			// }
			list = newNode;
			size--;
		}
		// newNode.next = loopNode;
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
