package com.leetcode.en.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
	 
	private static Map<Character, Boolean> typeMap = new HashMap<Character, Boolean>(3);
	private static Map<Character, Character> matchMap = new HashMap<Character, Character>(3);
	static{
		typeMap.put('(', Boolean.TRUE);
		typeMap.put('[', Boolean.TRUE);
		typeMap.put('{', Boolean.TRUE);
		typeMap.put(')', Boolean.FALSE);
		typeMap.put(']', Boolean.FALSE);
		typeMap.put('}', Boolean.FALSE);
		
		matchMap.put('(', ')');
		matchMap.put('[', ']');
		matchMap.put('{', '}');
	}
	 
	public static class Solution {
	    public boolean isValid(String s) {
	       StringBuilder stack = new StringBuilder();
	       for(int i = 0 ; i < s.length(); i++){
	    	   char srcCh = s.charAt(i);
	    	   if (typeMap.get(srcCh)){
	    		   stack.append(srcCh);
	    	   }else{
	    		   if (stack.length() == 0){
	    	    	   return false;
	    	       }
	    		   if (matchMap.get(stack.charAt(stack.length() - 1)) == srcCh){
	    			   stack.setLength(stack.length() - 1);
	    		   }else{
	    			   return false;
	    		   }
	    	   }
	       }
	       
	       if (stack.length() == 0){
	    	   return true;
	       }
	       return false;
	   }
	}
	
	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.isValid(""));
		System.out.println(solution.isValid("[]"));
		System.out.println(solution.isValid("["));
		System.out.println(solution.isValid("]"));
		System.out.println(solution.isValid("()"));
		System.out.println(solution.isValid("{}"));
		System.out.println(solution.isValid("{}()"));
		System.out.println(solution.isValid("{()}"));
		System.out.println(solution.isValid("{(})"));
	}
}
