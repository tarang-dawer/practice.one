package com.tarang.practice.leetcode;

/**
 * Definition for singly-linked list.
 */

public class addTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0, carry = 0;
		ListNode result = null, start = null, digitResult = null;
		while (l1 != null && l2 != null) {
			sum = l1.val + l2.val + carry;
			carry = 0;
			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			}
			digitResult = new ListNode(sum);
			digitResult.next = null;
			if (result != null) {
				result.next = digitResult;
				result=result.next;
			} else {
				result = start = digitResult;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {

			sum = l1.val + carry;
			carry = 0;
			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			}
			digitResult = new ListNode(sum);
			digitResult.next = null;
			if (result != null) {
				result.next = digitResult;
				result=result.next;
			} else {
				result = start = digitResult;
			}
			l1 = l1.next;

		}
		while (l2 != null) {

			sum = l2.val + carry;
			carry = 0;
			if (sum > 9) {
				sum = sum % 10;
				carry = 1;
			}
			digitResult = new ListNode(sum);
			digitResult.next = null;
			if (result != null) {
				result.next = digitResult;
				result=result.next;
			} else {
				result = start = digitResult;
			}
			l2 = l2.next;
		}
		if(carry==1)
		{
			digitResult = new ListNode(carry);
			digitResult.next = null;
			result.next=digitResult;
			result=result.next;
			
		}
		return start;

	}
}