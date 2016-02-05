package com.tarang.practice.leetcode;

import java.util.HashMap;

public class lengthOfLongestSubstring {

	public static void main(String[] args) {
		lengthOfLongestSubstring lols = new lengthOfLongestSubstring();
		String s = "abcdefghamby";// 10
		String s1 = "abcdefghambc";// 9
		String s2 = "abcdefghembc";// 8
		int l = lols.lengthOfLongestSubstring(s);
		System.out.println("abc".length());
		System.out.println("length : " + l);
	}

	public int lengthOfLongestSubstring(String s) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		int rightPointer = 0, leftPointer = rightPointer - 1, answer = 0;
		while (rightPointer != s.length()) {
			Integer previousOccurrence = map.put(s.charAt(rightPointer),
					rightPointer);
			if (previousOccurrence != null) {
				leftPointer = Math.max(leftPointer, previousOccurrence);
			}
			answer = Math.max(answer, rightPointer - leftPointer);
			rightPointer++;
		}
		return answer;
	}
}