package com.leetcode.en.easy;

public class PowerOfFour {
	public static class Solution {
		public boolean isPowerOfFour(int num) {
			return num > 0 && (num & 0x55555555) != 0 && (num & (num - 1)) == 0;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPowerOfFour(1));
		System.out.println(solution.isPowerOfFour(2));
		System.out.println(solution.isPowerOfFour(4));
		System.out.println(solution.isPowerOfFour(16));
		System.out.println(solution.isPowerOfFour(268435456));
		System.out.println(solution.isPowerOfFour(1073741824));
		System.out.println(solution.isPowerOfFour(23));
		System.out.println(solution.isPowerOfFour(167772161));
	}
}
