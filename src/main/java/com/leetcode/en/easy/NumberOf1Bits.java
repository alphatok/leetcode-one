package com.leetcode.en.easy;

public class NumberOf1Bits {
	public static class Solution {
	    // you need to treat n as an unsigned value
		// https://en.wikipedia.org/wiki/Hamming_weight better solution here
	    public int hammingWeight(int n) {
	        int count = 0;
	        while(n!=0){
	        	count += n&1;
	        	n >>>= 1;
	        }
	        
	        return count;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.hammingWeight(1));
		System.out.println(solution.hammingWeight(11));
		System.out.println(solution.hammingWeight(128));
		System.out.println(solution.hammingWeight(129));
	}
}
