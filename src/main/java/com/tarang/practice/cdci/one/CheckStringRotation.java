package com.tarang.practice.cdci.one;

public class CheckStringRotation {

	public static void main(String[] args) {

		CheckStringRotation c = new CheckStringRotation();
		String s1 = "waterbottle";
		String s2 = "erbottlewat";

		if (c.isRotation(s1, s2)) {
			System.out.println("Is a rotation");
		} else {
			System.out.println("Is not a rotation");
		}
	}

	private boolean isRotation(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() > 0) {
			return isSubstring(s1 + s1, s2);
		}
		return false;
	}

	private boolean isSubstring(String string, String s2) {
		if (string.contains(s2)) {
			return true;
		}
		return false;
	}

}
