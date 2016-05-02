package com.leetcode.bruceyang.easy;

public class LengthOfLastWord {
	public static class Solution{
		public int lengthOfLastWord(String s) {
			boolean startCount = false;
			char[] array = s.toCharArray();
			int count = 0;
	        for (int i = array.length - 1; i >= 0; i--) {
				if (array[i] != ' '){
					startCount = true;
					count++;
				}else {
					if (startCount){
						return count;
					}
				}
			}
	        
	        return count;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLastWord(""));;
		System.out.println(solution.lengthOfLastWord("3434"));;
		System.out.println(solution.lengthOfLastWord("hello workd"));;
	}
}
