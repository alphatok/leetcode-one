package com.leetcode.bruceyang.easy;

public class HappyNumber {
	public static class Solution {
	    public boolean isHappy(int n) {
	        int tmp = n;
	        int square = 0;
	        while(square != 1){
	        	
	        	square = 0;
	        	while(tmp > 0){
	        		int digit = tmp%10;
		        	square += digit*digit;
		        	tmp = tmp/10;
	        	}
	        	if (square < 10){
	        		break;
	        	}
	        	tmp = square;
	        }
	        
	        if (square == 1){
	        	return true;
	        }else {
				return false;
			}
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.isHappy(19));
//		System.out.println(solution.isHappy(1));
//		System.out.println(solution.isHappy(100));
//		System.out.println(solution.isHappy(68));
		System.out.println(solution.isHappy(69));
		System.out.println(solution.isHappy(619));
		System.out.println(solution.isHappy(710));
//		System.out.println(solution.isHappy(70));
	}
}
