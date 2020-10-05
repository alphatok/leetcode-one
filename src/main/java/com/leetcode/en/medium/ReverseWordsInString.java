package com.leetcode.en.medium;

public class ReverseWordsInString {
	public static class Solution {
	    /**
	     * @param s
	     * @return
	     */
	    /**
	     * @param s
	     * @return
	     */
	    public String reverseWords(String s) {
	        if (s == null || s.length() == 0){
	        	return s;
	        }
	        
	        StringBuilder builder = new StringBuilder(s.length());
	        char[] chs = s.toCharArray();
	        int indexEnd = Integer.MAX_VALUE;
	        int indexStart = Integer.MAX_VALUE;
	        boolean words = false;
	        for (int i = chs.length - 1; i >= 0; i--) {
				if (chs[i] != ' '){
					if (words){
						indexStart = i;
					}else {
						words = true;
						indexEnd =  i;
						indexStart = i;
					}
				}else {
					if (words){
						if (builder.length() > 0){
							builder.append(" ").append(s.substring(indexStart, indexEnd + 1));	
						}else {
							builder.append(s.substring(indexStart, indexEnd + 1));
						}
						
						words = false;
					}
				}
			}
	        
	        if (words){
				if (builder.length() > 0){
					builder.append(" ").append(s.substring(indexStart, indexEnd + 1));	
				}else {
					builder.append(s.substring(indexStart, indexEnd + 1));
				}
				
				words = false;
			}
	        
	        return builder.toString();
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.reverseWords("the sky is blue")); // blue is sky the
//		System.out.println(solution.reverseWords("  "));
		System.out.println(solution.reverseWords("a"));
//		System.out.println(solution.reverseWords(" a b c "));
//		System.out.println(solution.reverseWords("    the sky is  blue ")); // blue is sky the
	}
}
