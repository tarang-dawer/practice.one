package com.tarang.practice.cdci.one;

//assuming chars are ascii
public class Permutation {

	public static void main(String[] args) {

		Permutation p = new Permutation();
		String a="abcde";
		String b="bcaed";
		if (p.chechPermutation(a, b)) {
			System.out.println("Two strings are a permutation of each other");
		} else {
			System.out.println("Not a permutation");
		}
	}

	private boolean chechPermutation(String s, String t) {

		if (s.length() != t.length())
			return false;

		int[] chars = new int[256];
		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i)]++;
		}
		for (int i = 0; i < t.length(); i++) {
			if (--chars[t.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}

}
