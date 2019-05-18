package com.leetcode.bruceyang.easy;

public class PowerOfTwo {
	public static class Solution {
	    public boolean isPowerOfTwo(int n) {
	    	if (n <= 0){
	    		return false;
	    	}
	        return (n & (n - 1)) == 0;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPowerOfTwo(0));
		System.out.println(solution.isPowerOfTwo(1));
		System.out.println(solution.isPowerOfTwo(2));
		System.out.println(solution.isPowerOfTwo(4));
		System.out.println(solution.isPowerOfTwo(5));
		System.out.println(solution.isPowerOfTwo(128));
	}
}
