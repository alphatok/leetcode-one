package com.leetcode.bruceyang.easy;

public class LongestCommonPrefix {
	public static class Solution {
	    public String longestCommonPrefix(String[] strs) {
	    	if (null == strs || strs.length == 0){
	    		return "";
	    	}
	    	
	    	if (strs.length == 1){
	    		return strs[0];
	    	}
	    	
	    	StringBuilder builder = new StringBuilder();
	    	builder.append(strs[0]);
	    	int maxCommonPrefixLength = builder.length();
	        for (int i = 1; i < strs.length; i++) {
				String str = strs[i];
				maxCommonPrefixLength = (str.length() < maxCommonPrefixLength) ? str.length() : maxCommonPrefixLength;
				builder.setLength(maxCommonPrefixLength);
				
				for(int j = 0; j < maxCommonPrefixLength; j++){
					if (str.charAt(j) != builder.charAt(j)){
						maxCommonPrefixLength = j;
						builder.setLength(maxCommonPrefixLength);
					}
				}
				
				if (maxCommonPrefixLength == 0){
					break;
				}
			}
	        
	        
	        return builder.toString();
	    }
	}
	
	
	public static void main(String[] args) {
//		System.out.println(new Solution().longestCommonPrefix(new String[]{"abc", "abc", "abc", "abc", "a"}));
		System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow","flight"})); //["flower","flow","flight"]  "fl"
	}
}
