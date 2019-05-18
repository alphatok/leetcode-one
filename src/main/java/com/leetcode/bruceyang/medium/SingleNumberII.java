package com.leetcode.bruceyang.medium;

public class SingleNumberII {
	public static class Solution {

		/**
		 * Given an array of integers, every element appears three times except
		 * for one. Find that single one.
		 */
		public int singleNumber(int[] nums) {
			int sums[] = new int[32];
			int result = 0;
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < nums.length; j++) {
					sums[i] += (nums[j] >> i) & 1;
				}
				
				result |= (sums[i] % 3) << i;
			}

			return result;
		}
	}
	
	public static class Solution2 {
		public int singleNumber(int[] nums) {
			int one = 0, two = 0, three = 0;
			for (int i = 0; i < nums.length; i++) {
				one = one ^ nums[i];
				two = two | (one & nums[i]);
				three = ((two & one));
				one &= ~three;
				two &= ~three;
				System.out.println(three+"," + two + "," + one);
			}
			
			return one;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().singleNumber(new int[]{3,2,2,2}));
		System.out.println(new Solution2().singleNumber(new int[]{3,2,2,2}));
		System.out.println(new Solution2().singleNumber(new int[]{3,2,2,2,5,5,5}));
		System.out.println(new Solution2().singleNumber(new int[]{3,2,2,2,5,5,5,7,7,7}));
	}
}
