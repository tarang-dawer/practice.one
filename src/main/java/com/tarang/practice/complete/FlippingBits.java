package com.tarang.practice.complete;

import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			long num = in.nextLong();
			double result = 0;
			for (int i = 0; i < 32; i++) {
				if (num != 0) {
					if (num % 2 == 0) {
						result += Math.pow(2, i);
					}
				} else {
					result += Math.pow(2, i);
				}
				num = num / 2;
			}
			System.out.println((long) result);
		}
	}
}