package com.leetcode.bruceyang.medium;

import com.leetcode.bruceyang.util.CollectionUtil;

public class CountingBits {
	public static class Solution {

		public int[] countBits(int num) {
			if (num < 0) {
				return new int[] {};
			}
			if (num == 0) {
				return new int[] { 0 };
			}
			if (num == 1) {
				return new int[] { 0, 1 };
			}
			int[] ret = new int[num + 1];
			ret[0] = 0;
			ret[1] = 1;

			int pow = 2;
			int nextPow = pow << 1;
			for (int i = 2; i <= num; i++) {
				if (i >= pow && i < nextPow) {
					ret[i] = ret[i - pow] + 1;
				} else if (i == nextPow) {
					pow = nextPow;
					nextPow = pow << 1;
					ret[i] = 1;
				}
			}
			
			return ret;
		}
	}

	public static void main(String[] args) {
		CollectionUtil.print(new Solution().countBits(5));
		CollectionUtil.print(new Solution().countBits(10));
	}
}
