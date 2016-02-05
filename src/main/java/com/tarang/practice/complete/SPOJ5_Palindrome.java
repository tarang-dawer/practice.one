package com.tarang.practice.complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SPOJ5_Palindrome {

	public static void main(String[] args) throws IOException {

		SPOJ5_Palindrome test = new SPOJ5_Palindrome();
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String line;
		int totalInputs = -1;
		if ((line = stdin.readLine()) != null && line.length() != 0) {
			if (totalInputs == -1) {
				totalInputs = Integer.parseInt(line);
			}
		}
		for (int i = 1; i <= totalInputs; i++) {
			if ((line = stdin.readLine()) != null && line.length() != 0) {
				test.generateGreaterPalindrome(line);
			}
			System.out.println(" ");
		}

		System.exit(0);
	}

	private void generateGreaterPalindrome(String string) {
		int length = string.length();
		// int position;
		StringBuilder srb = new StringBuilder();
		if (length % 2 == 0) {
			// even nmbr digits
			for (int i = 0; i < length / 2; i++) {
				if (string.charAt(i) != string.charAt(length - i)) {
					srb.append(Integer.valueOf(string.charAt(i)) < Integer
							.valueOf(string.charAt(length - i)) ? Integer
							.valueOf(string.charAt(length - i)) : Integer
							.valueOf(string.charAt(i)));
					// position = length - i;
					// break;
				} else {
					srb.append(string.charAt(i));
				}
			}
			for (int j = srb.length(); j > 0; j--) {
				srb.append(srb.charAt(j));
			}
		} else {
			// odd number digits
			for (int i = 0; i < (length - 1) / 2; i++) {
				if (string.charAt(i) != string.charAt(length - i)) {
					srb.append(Integer.valueOf(string.charAt(i)) < Integer
							.valueOf(string.charAt(length - i)) ? Integer
							.valueOf(string.charAt(length - i)) : Integer
							.valueOf(string.charAt(i)));
					// position = length - i;
					// break;
				} else {
					srb.append(string.charAt(i));
				}
			}
			srb.append(string.charAt((length + 1) / 2));
			for (int j = srb.length() - 1; j > 0; j--) {
				srb.append(srb.charAt(j));
			}
		}

		System.out.println(srb.toString());
	}
}

