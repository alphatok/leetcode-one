package com.leetcode.bruceyang.easy;

public class ReverseVowelsOfString {
	public static class Solution {
		public static boolean[] vowels = new boolean[300];
		static{
			vowels['a'] = true;
			vowels['o'] = true;
			vowels['e'] = true;
			vowels['i'] = true;
			vowels['u'] = true;
			vowels['A'] = true;
			vowels['O'] = true;
			vowels['E'] = true;
			vowels['I'] = true;
			vowels['U'] = true;
		}
	    public String reverseVowels(String s) {
	    	if (s == null){
	    		return null;
	    	}
	    	
	        char[] arr = s.toCharArray();
	        int maxIndex = arr.length - 1;
	        int i = maxIndex, j = 0;
	        while (i > j) {
	        	while (i>=0 && !vowels[arr[i]]){
	        		i--;
	        	}
	        	
	        	while (j <= maxIndex && !vowels[arr[j]]){
	        		j++;
	        	}
	        	
	        	if (i>= 0 && j <= maxIndex && i > j ){
	        		char tmp = arr[i];
		        	arr[i] = arr[j];
		        	arr[j] = tmp;
		        	i--;
		        	j++;
	        	}
	        }
	        
	        
	        return new String(arr);
	    }
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Solution().reverseVowels(null));
		System.out.println(new Solution().reverseVowels(""));
		System.out.println(new Solution().reverseVowels("hello"));
		System.out.println(new Solution().reverseVowels("sddsaeksdjhk"));
		
	}
}
