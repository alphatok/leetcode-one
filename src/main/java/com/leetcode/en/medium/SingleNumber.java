package com.leetcode.en.medium;

public class SingleNumber {
	public static class Solution {
		/**
		 * Given an array of integers, every element appears twice except for
		 * one. Find that single one.
		 */
		public int singleNumber(int[] nums) {
			int result = nums[0];
			for (int i = 1; i < nums.length; i++) {
				result ^= nums[i];
			}

			return result;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().singleNumber(new int[] { 1, 3, 4, 6, 7, 3, 4, 6, 7, 9, 1 }));
	}
}
