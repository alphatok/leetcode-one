package com.leetcode.en.easy;

public class ExcelSheetColumnNumber {
	public static class Solution {
		
	    public int titleToNumber(String s) {
	        int ret = 0;
	        int level = 1;
	    	for (int i = s.length() - 1; i >= 0; i--) {
				int digitalValue = s.charAt(i) - 'A' + 1;
				ret += digitalValue*level;
				level *= 26;
			}
	    	
	    	return ret;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.titleToNumber("A"));
//		System.out.println(solution.titleToNumber("AA"));
		System.out.println(solution.titleToNumber("AB"));
		System.out.println(solution.titleToNumber("CV"));
	}
}
