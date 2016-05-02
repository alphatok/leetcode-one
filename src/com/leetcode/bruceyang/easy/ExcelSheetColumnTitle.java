package com.leetcode.bruceyang.easy;

public class ExcelSheetColumnTitle {
	public static class Solution{

		public static char[] charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	    public String convertToTitle(int n) {
	        StringBuilder buffer = new StringBuilder();
	        while(n > 0){
	        	int k = (n-1) % 26; // 0~25
	        	buffer.append(charSet[k]);
	        	
	        	n = (n-1) / 26;
	        	if (n <= 0){
	        		break;
	        	}
	        }
	        
	        return buffer.reverse().toString();
	    }

	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.convertToTitle(1));
//		System.out.println(solution.convertToTitle(2));
//		System.out.println(solution.convertToTitle(3));
//		System.out.println(solution.convertToTitle(4));
		System.out.println(solution.convertToTitle(26)); // Z
		System.out.println(solution.convertToTitle(27)); // AA
		System.out.println(solution.convertToTitle(100)); // CV
		System.out.println(solution.convertToTitle(23452345)); // AYHHUG
		System.out.println(solution.convertToTitle(5353545)); // KROKO

	}
}
