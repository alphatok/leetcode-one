package com.leetcode.bruceyang.easy;

public class HouseRobber {
	public static class Solution {
		public int rob(int[] nums) {
			if (nums.length == 0) {
				return 0;
			} else if (nums.length == 1) {
				return nums[0];
			} else if (nums.length == 2) {
				return nums[0] > nums[1] ? nums[0] : nums[1];
			} else {
				int[] best = new int[nums.length];
				best[0] = nums[0];
				best[1] = nums[0] > nums[1] ? nums[0] : nums[1];
				for (int i = 2; i < nums.length; i++) {
					int a = best[i - 2] + nums[i];
					int b = best[i - 1];
					best[i] = a > b ? a : b;
				}
				
				return best[nums.length - 1];
			}
			
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().rob(new int[]{1,2,3,4,1,3,9,5,1,4,6}));
		System.out.println(new Solution().rob(new int[]{1}));
		System.out.println(new Solution().rob(new int[]{1,3,1}));
		System.out.println(new Solution().rob(new int[]{1,1,1}));
		System.out.println(new Solution().rob(new int[]{1,4,2,1}));
		System.out.println(new Solution().rob(new int[]{1,4,4,3}));
	}
}
