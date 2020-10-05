package com.leetcode.en.easy;

public class NimGame {
	public static class Solution {
	    public boolean canWinNim(int n) {
	        return (n & 0x3) != 0;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().canWinNim(1));
		System.out.println(new Solution().canWinNim(4));
		System.out.println(new Solution().canWinNim(5));
	}
}
