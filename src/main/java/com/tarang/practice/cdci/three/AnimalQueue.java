package com.tarang.practice.cdci.three;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalQueue {

	int order;
	private Queue<Dog> dogQueue = null;
	private Queue<Cat> catQueue = null;

	public AnimalQueue() {
		dogQueue = new LinkedList();
		catQueue = new LinkedList();
		this.order = 0;
	}

	private abstract class Animal {
		private int order;
		private String name;

		public Animal(String name) {
			this.name = name;
		}

		public boolean isOlderThan(Animal a) {
			return this.order < a.order;
		}
	}

	public class Dog extends Animal {

		public Dog(String name) {
			super(name);
		}

	}

	public class Cat extends Animal {

		public Cat(String name) {
			super(name);
		}

	}

	public static void main(String[] args) {

		AnimalQueue a = new AnimalQueue();

		a.enqueue(a.new Dog("d"));
		a.enqueue(a.new Cat("c"));
		a.enqueue(a.new Dog("o"));
		a.enqueue(a.new Cat("a"));
		a.enqueue(a.new Dog("g"));
		a.enqueue(a.new Cat("t"));
		System.out.println(a.dequeueAny().name);
		System.out.println(((Animal) a.dequeueCat()).name);
		System.out.println(((Animal) a.dequeueDog()).name);
		System.out.println(a.dequeueAny().name);
		System.out.println(((Animal) a.dequeueDog()).name);
		System.out.println(((Animal) a.dequeueCat()).name);
	}

	public void enqueue(Animal a) {
		a.order = order + 1;
		order++;
		if (a instanceof Dog)
			dogQueue.add((Dog) a);
		else
			catQueue.add((Cat) a);
	}

	public Dog dequeueDog() {
		return dogQueue.poll();
	}

	public Cat dequeueCat() {
		return catQueue.poll();
	}

	public Animal dequeueAny() {
		if (dogQueue.isEmpty()) {
			return dequeueCat();
		}
		if (catQueue.isEmpty()) {
			return dequeueDog();
		}

		Dog currentDog = dogQueue.peek();
		Cat currentCat = catQueue.peek();

		if (currentDog.isOlderThan(currentCat)) {
			return dequeueDog();
		} else {
			return dequeueCat();
		}
	}

}
