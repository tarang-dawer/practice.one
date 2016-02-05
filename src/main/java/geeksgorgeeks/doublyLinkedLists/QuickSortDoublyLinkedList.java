//package geeksgorgeeks.doublyLinkedLists;
//
//import geeksgorgeeks.doublyLinkedLists.ReverseDoublyList.Node;
//
//public class QuickSortDoublyLinkedList {
//
//	private class Node {
//		int val;
//		Node prev, next;
//
//		public Node(int val) {
//			this.val = val;
//			this.prev = null;
//			this.next = null;
//		}
//	}
//
//	public static void main(String[] args) {
//		int[] array = { 8, 2, 6, 4, 3, 1, 7, 5 };
//		QuickSortDoublyLinkedList l = new QuickSortDoublyLinkedList();
//		Node list = l.createLinkedList(array);
//		l.printList(list);
//		System.out.println();
//		System.out.println("Printing rev list:");
//		Node res = l.quickSort(list);
//		l.printList(res);
//		System.out.println();
//	}
//
//	private Node quickSort(Node list) {
//		Node pivot = partition(list);
//		quickSort(list);
//		quickSort(pivot);
//
//		Node iter = list;
//		if (iter != null) {
//			while (iter.next != null) {
//				iter = iter.next;
//			}
//			iter.next = pivot;
//			return list;
//		} else
//			return pivot;
//	}
//
//	private Node partition(Node start) {
//		Node iter = start, pivot = null;
//		if (start == null)
//			return start;
//		while (iter.next != null) {
//			iter = iter.next;
//		}
//		pivot = iter;
//		iter = start;
//		while (iter != pivot) {
//			if(iter.val<pivot.val)
//			{
//				Node temp=iter;
//			}
//		}
//	}
//
//	private Node createLinkedList(int[] array) {
//		int size = array.length;
//
//		Node list = null, start = null, newNode = null;
//		while (size > 0) {
//			newNode = new Node(array[array.length - size]);
//			if (start == null) {
//				start = newNode;
//			} else {
//				newNode.prev = list;
//				list.next = newNode;
//			}
//			// if (size == 5) {
//			// loopNode = newNode;
//			// }
//			list = newNode;
//			size--;
//		}
//		// newNode.next = loopNode;
//		return start;
//	}
//
//	private void printList(Node start) {
//		Node list = start;
//		while (list != null) {
//			System.out.print(" " + list.val);
//			list = list.next;
//		}
//
//	}
//}
