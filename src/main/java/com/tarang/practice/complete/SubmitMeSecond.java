package com.tarang.practice.complete;

import java.util.Scanner;

public class SubmitMeSecond {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// get the number of lines
		int num = sc.nextInt();

		for (int i = 0; i < num; i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			System.out.println(a + b);
		}

	}
}
