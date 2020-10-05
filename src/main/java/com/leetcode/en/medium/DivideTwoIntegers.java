package com.leetcode.en.medium;

public class DivideTwoIntegers {
	public static class Solution {
		public int divide(int dividend, int divisor) {
			long dd = dividend;
			long dr = divisor;
			if (dr == 0L) {
				return Integer.MAX_VALUE;
			}

			long sign = 1;
			if (dd < 0L) {
				sign = -1L;
				dd = -1L * dd;
			}
			if (dr < 0L) {
				sign *= -1L;
				dr = -1L * dr;
			}
			long shift = 1;
			long b2 = dr;
			do {
				long tmp = b2 << 1;
				if (tmp > dd){
					break;
				}else {
					shift <<= 1;
					b2 = tmp;
				}
			} while (true);
			
			long count = 0;
			while (dd >= dr) {
				while (dd >= b2){
					dd -= b2;
					count += shift;
				}
				
				b2 >>= 1;
				shift >>= 1;
			}
			
			count *= sign;
			if (count > Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}else if (count < Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			}else {
				return (int)count;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.divide(24, 12));
		System.out.println(solution.divide(36, 12));
		System.out.println(solution.divide(60, 12));
		System.out.println(solution.divide(240, 12));
		System.out.println(solution.divide(241, 12));
		System.out.println(solution.divide(0, 12));
		System.out.println(solution.divide(0, -12));
		System.out.println(solution.divide(3, -12));
		System.out.println(solution.divide(36, -12));
		System.out.println(solution.divide(37, -12));
		System.out.println(solution.divide(-37, 12));
		System.out.println(solution.divide(-137, 12));
		System.out.println(solution.divide(-137, 0));
		System.out.println(solution.divide(Integer.MIN_VALUE, -1));
		System.out.println(solution.divide(Integer.MIN_VALUE, 1));
	}
}
