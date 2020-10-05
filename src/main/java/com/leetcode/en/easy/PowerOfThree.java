package com.leetcode.en.easy;

public class PowerOfThree {
	public static class Solution {
		public boolean isPowerOfThree(int n) {
			if (n <= 0) {
				return false;
			}

			double lg = Math.log(n) / Math.log(3);
			return Math.abs(lg - Math.round(lg)) < 0.00000000001f;
		}
	}

	public static class Solution2 {
		public boolean isPowerOfThree(int n) {
			return Integer.toString(n, 3).matches("10*");
		}
	}

	public static class Solution3 {
		public boolean isPowerOfThree(int n) {
			int[] all = { 1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969,
					14348907, 43046721, 129140163, 387420489, 1162261467 };
			for (int i = 0; i < all.length; i++) {
				if (all[i] == n) {
					return true;
				}
			}

			return false;
		}
	}

	public static class Solution4 {
		public boolean isPowerOfThree(int n) {
			return n > 0 && 1162261467 % n == 0;
		}
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.isPowerOfThree(1));
		System.out.println(solution.isPowerOfThree(2));
		System.out.println(solution.isPowerOfThree(3));
		System.out.println(solution.isPowerOfThree(27));
		System.out.println(solution.isPowerOfThree(3 ^ 10));
		System.out.println(solution.isPowerOfThree(3 ^ 125));

		System.out.println(Integer.toString(1, 3));
		System.out.println(Integer.toString(2, 3));
		System.out.println(Integer.toString(3, 3));
		System.out.println(Integer.toString(4, 3));
		System.out.println(Integer.toString(9, 3));
		System.out.println(Integer.toString(27, 3));

	}
}
