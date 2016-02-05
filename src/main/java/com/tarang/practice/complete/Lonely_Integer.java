package com.tarang.practice.complete;

import java.util.Arrays;
import java.util.Scanner;

public class Lonely_Integer {
	static int lonelyinteger(int[] a) {
		Arrays.sort(a);
		if (a.length % 2 == 0) {
			System.out.println("Invalid Input");
			System.exit(-1);
		}
		if (a.length == 1)
			return a[0];

		for (int i = 0; i < a.length - 1;) {
			if (a[i] == a[i + 1])
				i = i + 2;
			else
				return a[i];
		}
		return a[a.length - 1];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		// System.out.println("Initiating...");
		int _a_size = Integer.parseInt(in.nextLine());
		int[] _a = new int[_a_size];
		int _a_item;
		String next = in.nextLine();
		String[] next_split = next.split(" ");

		for (int _a_i = 0; _a_i < _a_size; _a_i++) {
			_a_item = Integer.parseInt(next_split[_a_i]);
			_a[_a_i] = _a_item;
		}

		res = lonelyinteger(_a);
		System.out.println(res);

	}
}
