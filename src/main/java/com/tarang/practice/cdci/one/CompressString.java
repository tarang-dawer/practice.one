package com.tarang.practice.cdci.one;

import java.util.LinkedList;
import java.util.List;

public class CompressString {

	public static void main(String[] args) {
		String s = "aabbbccccaa";

		System.out.println(compress(s));
	}

	private static String compress(String s) {
		List<Character> list = new LinkedList<Character>();
		StringBuffer sb = new StringBuffer();
		char lastchar = s.charAt(0);
		int lastcount = 1;
		list.add(lastchar);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == lastchar)
				lastcount++;
			else {
				sb.append(lastchar).append(lastcount);
				lastchar = s.charAt(i);
				lastcount = 1;
			}
		}
		sb.append(lastchar).append(lastcount);
		return sb.toString();
	}
}
