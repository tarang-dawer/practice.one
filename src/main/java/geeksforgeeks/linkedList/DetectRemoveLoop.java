package geeksforgeeks.linkedList;

public class DetectRemoveLoop {
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
		DetectRemoveLoop l = new DetectRemoveLoop();
		Node list = l.createLinkedList(array);
		// l.printList(list);
		System.out.println();
		System.out.println("Printing rev list:");
		Node res = l.detectRemoveLoop(list);
		l.printList(res);
		System.out.println();

	}

	private Node detectRemoveLoop(Node start) {
		Node slow = null, fast = null, prev = null, iter = start;
		slow = start;
		fast = start;

		// detect loop by moving two pointers, ist at normal speed, 2nd at twice
		// the speed, both intersect.
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			prev = fast.next;
			fast = prev.next;
			if (slow == fast) {
				break;
			}
		}

		// when iter = sow, the loop is at the 1st node, therefore, point the
		// prev.next at null to break the loop
		while (iter != slow) {
			prev = slow;
			slow = slow.next;
			iter = iter.next;
		}
		prev.next = null;
		return start;
	}

	private Node createLinkedList(int[] array) {
		int size = array.length;

		Node list = null, start = null, loopNode = null, newNode = null;
		while (size > 0) {
			newNode = new Node(array[array.length - size]);
			if (start == null) {
				start = newNode;
			} else {
				list.next = newNode;
			}
			if (size == 5) {
				loopNode = newNode;
			}
			list = newNode;
			size--;
		}
		newNode.next = loopNode;
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
