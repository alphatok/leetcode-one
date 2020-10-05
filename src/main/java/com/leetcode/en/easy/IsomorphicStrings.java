package com.leetcode.en.easy;

import java.util.HashMap;
import java.util.Map;

import com.alphatok.util.CollectionUtil;

public class IsomorphicStrings {
	public static class Solution {
	    public boolean isIsomorphic(String s, String t) {
	        Map<Character, Character> map = new HashMap<Character, Character>(s.length());
	        Map<Character, Character> reverseMap = new HashMap<Character, Character>(s.length());
	        for (int i = 0; i < s.length(); i++) {
	        	Character chS = s.charAt(i);
	        	Character chT = t.charAt(i);
	        	Character ch1 = map.get(chS);
	        	if (ch1 != null){
	        		if (ch1 != chT){
	        			return false;	
	        		}
	        	}else if (ch1 == null) {
	        		Character ch2 = reverseMap.get(chT);
	        		if (ch2 != null && ch2 != chS){
	        			return false;
	        		}
	        		
	        		map.put(chS, chT);
					reverseMap.put(chT, chS);
				}
			}
	        
	        return true;
	    }
	    
	    public boolean isIsomorphic2(String s, String t) {
	    	int[] index = new int[256];
	    	int[] reverseIndex = new int[256];
	    	int uniq = 1000;
	    	
	    	CollectionUtil.print(index);
	    	for (int i = 0; i < s.length(); i++) {
				int ch1 = s.charAt(i) - ' ';
				int ch2 = t.charAt(i) - ' ';
				if (index[ch1] != 0){
					if (index[ch1] != reverseIndex[ch2]){
						return false;
					}
				}else {
					if (reverseIndex[ch2] != 0 && index[ch1] != reverseIndex[ch2]){
						return false;
					}
					
					index[ch1] = uniq;
					reverseIndex[ch2] = uniq;
					uniq++;
				}
			}
	    	
	    	
	        return true;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isIsomorphic("egg", "add"));
		System.out.println(solution.isIsomorphic("foo", "bar"));
		System.out.println(solution.isIsomorphic("paper", "title"));
		System.out.println(solution.isIsomorphic("ab", "aa"));
		
		System.out.println(solution.isIsomorphic2("egg", "add"));
		System.out.println(solution.isIsomorphic2("foo", "bar"));
		System.out.println(solution.isIsomorphic2("paper", "title"));
		System.out.println(solution.isIsomorphic2("ab", "aa"));
		System.out.println(solution.isIsomorphic2("qwertyuiop[]asdfghjkl;'\\zxcvbnm,./", "',.pyfgcrl/=aoeuidhtns-\\;qjkxbmwvz"));
	}
	
	
}
