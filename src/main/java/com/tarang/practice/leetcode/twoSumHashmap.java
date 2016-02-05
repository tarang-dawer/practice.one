package com.tarang.practice.leetcode;

import java.util.HashMap;

public class twoSumHashmap {

	public int[] twoSum(int[] nums, int target) {
		int diff;
		int index[] = new int[2];
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			diff = target - nums[i];
			index[0] = i + 1;
			if (hm.get(diff) != null) {
				index[1] = hm.get(diff) + 1;
				if (index[0] == index[1]) {
					continue;
				}
				return index;
			}
		}
		return null;
	}
}