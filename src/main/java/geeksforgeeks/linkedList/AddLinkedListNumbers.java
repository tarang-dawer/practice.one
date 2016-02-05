package geeksforgeeks.linkedList;

public class AddLinkedListNumbers {

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
		int[] array = { 1, 2, 3 };
		int[] array1 = { 4, 5, 6 };
		AddLinkedListNumbers l = new AddLinkedListNumbers();
		Node num1 = l.createLinkedList(array);
		Node num2 = l.createLinkedList(array1);
		// l.printList(list);
		System.out.println();
		System.out.println("Printing rev list:");
		// Node res = l.addNums(num1,num2);
		Node res1 = l.addRevNums(num1, num2);
		// l.printList(res);
		l.printList(res1);
		System.out.println();

	}

	private Node addRevNums(Node num1, Node num2) {

		checkAndPadNumbers(num1, num2);
		int sum, carry;
		if (num1.next == null && num2.next == null) {
			Node carryNode = null;
			sum = num1.val + num2.val;
			carry = sum / 10;
			sum = sum % 10;
			if (carry > 0)
				carryNode = new Node(1, 0);
			Node sumNode = new Node(sum, 0);
			sumNode.next = carryNode;
			return sumNode;
		} else {
			Node trailSum = addRevNums(num1.next, num2.next);
			sum = num1.val + num2.val + trailSum.carry;
			carry = sum / 10;
			sum = sum % 10;
			Node sumNode = new Node(sum, carry);
			sumNode.next = trailSum;
			return sumNode;
		}
	}

	private void checkAndPadNumbers(Node num1, Node num2) {
		int len1 = 0, len2 = 0;
		Node iter1 = num1, iter2 = num2, prev1 = null, prev2 = null;
		while (iter1 != null) {
			len1++;
			prev1 = iter1;
			iter1 = iter1.next;
		}
		while (iter2 != null) {
			len2++;
			prev2 = iter2;
			iter2 = iter2.next;
		}
		if (len1 == len2)
			return;
		else if (len1 > len2) {
			// pad num2
			int diff = len1 - len2;
			while (diff-- > 0) {
				Node padNode = new Node(0, 0);
				prev2.next = padNode;
			}
		} else {
			// pad num1
			int diff = len2 - len1;
			while (diff-- > 0) {
				Node padNode = new Node(0, 0);
				prev1.next = padNode;
			}
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
