package com.leetcode.en.easy;

public class FactorialTrailingZeroes {
	public static class Solution {
		public int trailingZeroes(int n) {
			int ret = 0;
			while (n > 0) {
				ret += n / 5;
				n /= 5;
			}

			return ret;
		}
	}

	public static void main(String[] args) {
		 System.out.println(new Solution().trailingZeroes(25));
		 System.out.println(new Solution().trailingZeroes(5));
		 System.out.println(new Solution().trailingZeroes(10));
		 System.out.println(new Solution().trailingZeroes(15));
		 System.out.println(new Solution().trailingZeroes(250));

		// 对n!做质因数分解n!=2x*3y*5z*...
		//
		// 显然0的个数等于min(x,z)，并且min(x,z)==z
		//
		// 证明：
		//
		// 对于阶乘而言，也就是1*2*3*...*n
		// [n/k]代表1~n中能被k整除的个数
		// 那么很显然
		// [n/2] > [n/5] (左边是逢2增1，右边是逢5增1)
		// [n/2^2] > [n/5^2](左边是逢4增1，右边是逢25增1)
		// ……
		// [n/2^p] > [n/5^p](左边是逢2^p增1，右边是逢5^p增1)
		// 随着幂次p的上升，出现2^p的概率会远大于出现5^p的概率。
		// 因此左边的加和一定大于右边的加和，也就是n!质因数分解中，2的次幂一定大于5的次幂
		
		
		// 又j均由1-N中5的倍数所提供，如果该数仅为5的倍数则贡献1，若为25的倍数则贡献2.
		// 而1-N中，5的倍数个数为|_N/5_|，|_ _|表示取下整数。
		// 又1-N中，25的倍数个数为|_N/25_|.需要注意到的是|_N/5_|已经包含了|_N/25_|。又25的倍数贡献了2，所以考虑到避免重复计算，则N!的素数分解中5的指数j为：
		// j = |_N/5_|+|_N/25_|+|_N/5^3_|+...
		int N = 0;
		for (int i = 2; i <= N; i++) {
			while (N % i == 0) {
				System.out.println(i);
				N = N / i;
			}
		}
		if (N > 1) {
			System.out.println(N);
		}
	}
}
