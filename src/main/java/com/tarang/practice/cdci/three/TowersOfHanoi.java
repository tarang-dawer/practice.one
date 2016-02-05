package com.tarang.practice.cdci.three;

import java.util.Stack;

public class TowersOfHanoi {

	private Stack<Integer> disks;
	private int towerIndex;

	public TowersOfHanoi(int towerNo) {
		disks = new Stack<Integer>();
		towerIndex = towerNo;
	}

	public static void main(String[] args) {
		// number of disks
		TowersOfHanoi[] towers = new TowersOfHanoi[3];
		int n = 4;
		// create 3 towers
		for (int i = 0; i < 3; i++) {
			towers[i] = new TowersOfHanoi(i);
		}

		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}

		towers[0].moveDisks(n, towers[2], towers[1]);
	}

	// move n disks to destination using buffer
	private void moveDisks(int n, TowersOfHanoi destination,
			TowersOfHanoi buffer) {
		if (n <= 0)
			return;
		moveDisks(n - 1, buffer, destination);
		moveTopDisk(destination);
		buffer.moveDisks(n - 1, destination, this);
	}

	private void moveTopDisk(TowersOfHanoi destination) {
		int topDisk = disks.pop();
		destination.add(topDisk);
		System.out.println("Disk : " + topDisk + " added to tower "
				+ destination.towerIndex);
	}

	private void add(int i) {
		if (!disks.isEmpty() && disks.peek() <= i) {
			System.err.println("Error placing disk : " + i + " in the tower "
					+ towerIndex);
		} else {
			disks.push(i);
		}

	}
}
