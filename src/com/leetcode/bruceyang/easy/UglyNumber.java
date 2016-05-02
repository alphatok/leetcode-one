package com.leetcode.bruceyang.easy;

public class UglyNumber {
	public static class Solution {
		public boolean isUgly(int num) {
			if (num == 0) {
				return false;
			}

			while (num % 2 == 0) {
				num /= 2;
			}
			while (num % 3 == 0) {
				num /= 3;
			}
			while (num % 5 == 0) {
				num /= 5;
			}

			return num == 1;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.isUgly(1));
		System.out.println(solution.isUgly(2));
		System.out.println(solution.isUgly(3));
		System.out.println(solution.isUgly(5));
		System.out.println(solution.isUgly(4));
		System.out.println(solution.isUgly(6));
		System.out.println(solution.isUgly(14));
	}
}
