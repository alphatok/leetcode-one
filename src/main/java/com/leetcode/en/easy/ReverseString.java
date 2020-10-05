package com.leetcode.en.easy;

public class ReverseString {
	public static class Solution {
	    public String reverseString(String s) {
	    	if (s == null){
	    		return null;
	    	}
	        StringBuilder builder = new StringBuilder(s.length());
	        char[] arr = s.toCharArray();
	        for (int i = arr.length - 1; i  >= 0; i--) {
				builder.append(arr[i]);
			}
	        
	        return builder.toString();
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().reverseString(null));
		System.out.println(new Solution().reverseString(""));
		System.out.println(new Solution().reverseString("hello"));
		System.out.println(new Solution().reverseString("sdds ksdjhk"));
	}
}
