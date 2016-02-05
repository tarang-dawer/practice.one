package com.tarang.practice.one;

public class HashTable {
	private class Node {
		public Object key;
		public Object value;
		public Node next;

		public Node(Object key, Object value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node[] buckets;
	int tableSize;
	int currSize;

	public HashTable(int tableSize) {
		buckets = new Node[tableSize];
	}

	public void put(Object key, Object value) {

		if (key != null) {
			int hash = (Integer) key % tableSize;

			Node newNode = new Node(key, value);
			newNode.next = buckets[hash];
			buckets[hash] = newNode;

		} else {
			throw new RuntimeException("Key should not be null");
		}

	}

	public Object get(Object key) {
		if (key != null) {
			int hash = (Integer) key % tableSize;
			Node start = buckets[hash];

			while (start != null) {

				if (start.key == key) {
					return start.value;
				}
				start = start.next;
			}

			throw new RuntimeException("Key Not Found");
		} else// where is this else statement?
		{
			throw new RuntimeException("Key should not be null");
		}

	}

	public Object remove(Object key) {
		return null;
	}

}
