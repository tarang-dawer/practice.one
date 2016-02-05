package com.tarang.practice.cdci.one;

public class ReplaceWhiteSpace {

	public static void main(String[] args) {

		ReplaceWhiteSpace r = new ReplaceWhiteSpace();
		String a = "My Name Jhonny";
		System.out.println(r.replaceWhiteSpace(a));
	}

	private String replaceWhiteSpace(String a) {
		int len = a.length();
		int whitespaces = 0;
		for (int i = 0; i < len; i++) {
			if (a.charAt(i) == ' ') {
				whitespaces++;
			}
		}

		int newlen = len + 2 * whitespaces;

		char[] newA = new char[newlen];
		for (int i = len - 1; i > -1; i--) {
			if (a.charAt(i) == ' ') {
				newA[newlen - 1] = '0';
				newA[newlen - 2] = '2';
				newA[newlen - 3] = '%';
				newlen -= 3;
			} else {
				newA[newlen - 1] = a.charAt(i);
				newlen--;
			}
		}
		return new String(newA);
	}
}
