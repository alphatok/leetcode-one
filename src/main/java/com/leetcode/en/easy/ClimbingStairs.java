package com.leetcode.en.easy;

public class ClimbingStairs {
	public static class Solution {
		
	    public int climbStairs(int n) {
	        if (n < 0){
	        	return 0;
	        }else if (n <= 2) {
				return n;
			}else {
				int f[] = new int[n+1];
				f[1] = 1;
				f[2] = 2;
				int tmp = 3;
				while(tmp <= n){
					f[tmp] = f[tmp - 1] + f[tmp -2];
					tmp++;
				}
				
				return f[n];
			}
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().climbStairs(1));
		System.out.println(new Solution().climbStairs(2));
		System.out.println(new Solution().climbStairs(3));
		System.out.println(new Solution().climbStairs(4));
		System.out.println(new Solution().climbStairs(4));
	}
}
