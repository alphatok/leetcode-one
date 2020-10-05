package com.leetcode.en.easy;

public class AddDigits {
	public static class Solution {
	    public int addDigits(int num) {
	    	if (num < 10){
	    		return num;
	    	}
	    	int sum = 0;
	        while(num>=10){
	        	int next = num/10;
	        	sum += num - next*10;
	        	if (next >= 10){
	        		num = next;
	        	}else {
	        		sum += next;
	        		if (sum >= 10){
	        			num = sum;
	        			sum = 0;
	        		}else {
						break;
					}
				}
	        }
	        
	        return sum;
	    }
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().addDigits(4));
		System.out.println(new Solution().addDigits(38));
		System.out.println(new Solution().addDigits(329));
	}
}
