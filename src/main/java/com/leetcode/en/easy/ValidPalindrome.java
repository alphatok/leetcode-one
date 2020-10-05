package com.leetcode.en.easy;

public class ValidPalindrome {
	public static class Solution {
		
	    public boolean isPalindrome(String s) {
	    	if (s.length() <= 1){
	    		return true;
	    	}
	    	
	    	int i = 0, j = s.length() - 1;
	    	while(i < j){
	    		char a = s.charAt(i);
	    		if (!isAlphaNumeric(a)){
	    			i++;
	    			continue;
	    		}
	    		char b = s.charAt(j);
	    		if (!isAlphaNumeric(b)){
	    			j--;
	    			continue;
	    		}
	    		
	    		if (toLowerCase(a) == toLowerCase(b)){
	    			i++;
	    			j--;
	    		}else {
	    			return false;
				}
	    	}
	    	
	    	return true;
	    }
	    
	    public boolean isAlphaNumeric(char x){
	    	if ((x >= '0' && x <= '9')
	    			|| (x >= 'a' && x <= 'z')
	    			|| (x >= 'A' && x <= 'Z')){
	    		return true;
	    	}else {
				return false;
			}
	    }
	    
	    public char toLowerCase(char x){
	    	if (x >= 'a' && x <= 'z'){
	    		return (char) (x-32);
	    	}
	    	
	    	return x;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome("0P"));
		System.out.println(solution.isPalindrome(""));
		System.out.println(solution.isPalindrome("a"));
		System.out.println(solution.isPalindrome("aa"));
		System.out.println(solution.isPalindrome("aa "));
		System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(solution.isPalindrome("race a car"));
		System.out.println(solution.isPalindrome("aba"));
	}
}
