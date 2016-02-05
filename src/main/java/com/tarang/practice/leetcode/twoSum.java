package com.tarang.practice.leetcode;

public class twoSum {

	public int[] twoSum(int[] nums, int target) {
		int diff;
		int index[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			diff = target - nums[i];
			index[0] = i + 1;
			for (int j = 0; j < nums.length; j++) {
				if (j == i)
					continue;
				if (diff == nums[j]) {
					index[1] = j + 1;
					return index;
				}
			}
		}
		return null;
	}
}