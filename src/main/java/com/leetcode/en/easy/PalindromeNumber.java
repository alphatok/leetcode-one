package com.leetcode.en.easy;

public class PalindromeNumber {
	public static class Solution {
		
		/**Determine whether an integer is a palindrome. Do this without extra space(stack).*/
	    public boolean isPalindrome(int x) {
	    	if (x<0){
	    		return false;
	    	}else if (x < 10) {
				return true;
			}
	    	
	        int base = 1;
	        while(x / base >= 10){
	        	base *= 10;
	        }
	        
	        int tmp = x;
	        while (tmp > 0){
	        	int left = tmp / base;
	        	int right = tmp % 10;
	        	if (left != right){
	        		return false;
	        	}
	        	
	        	tmp = tmp - left * base - right;
	        	tmp /= 10;
	        	base /= 100;
	        }
	        
	        return true;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.isPalindrome(1));
//		System.out.println(solution.isPalindrome(10));
//		System.out.println(solution.isPalindrome(11));
		System.out.println(solution.isPalindrome(121));
//		System.out.println(solution.isPalindrome(1221));
//		System.out.println(solution.isPalindrome(12821));
//		System.out.println(solution.isPalindrome(12823));
//		System.out.println(solution.isPalindrome(12841));
		System.out.println(solution.isPalindrome(1000021));
//		System.out.println(solution.isPalindrome(-2147483648));
	}
}
