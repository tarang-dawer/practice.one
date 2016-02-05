package com.tarang.practice.cdci.one;

import java.util.HashSet;
import java.util.Set;

public class StringUniqueCharsCheck {

	public static Set<Character> set = new HashSet<Character>();

	public static void main(String[] args) {
		String uniqueCharString = "tarzng ls";

		boolean check = checkCharUnique(uniqueCharString);
		if (check) {
			System.out.println("String has unique chars");
		} else {
			System.out.println("Not unique");
		}
	}

	private static boolean checkCharUnique(String uniqueCharString) {
		for (int i = 0; i < uniqueCharString.length(); i++) {
			if (set.contains(uniqueCharString.charAt(i)))
				return false;
			else
				set.add(uniqueCharString.charAt(i));
		}
		return true;
	}
}
