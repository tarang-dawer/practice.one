package geeksforgeeks.linkedList;

public class RotateLinkedList {
	private class Node {
		int val;
		int carry;
		Node next;

		public Node(int val, int carry) {
			this.val = val;
			this.carry = carry;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		RotateLinkedList l = new RotateLinkedList();
		Node num = l.createLinkedList(array);
		l.printList(num);
		System.out.println();
		Node res = l.rotateList(num, 3);
		l.printList(res);
		System.out.println();

	}

	private Node rotateList(Node start, int num) {
		Node iter = start, prev = null;
		while (num-- > 0) {
			prev = iter;
			iter = iter.next;
		}
		prev.next = null;
		Node newStart = iter;
		if (iter != null) {
			while (iter.next != null) {
				iter = iter.next;
			}
			iter.next = start;
			return newStart;
		} else {
			return null;
		}

	}

	private Node createLinkedList(int[] array) {
		int size = array.length;

		Node list = null, start = null;
		while (size > 0) {
			Node newNode = new Node(array[array.length - size], 0);
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
