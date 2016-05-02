package com.leetcode.bruceyang.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.leetcode.bruceyang.util.CollectionUtil;

public class ValidAnagram {
	public static class Solution {
	    public boolean isAnagram(String s, String t) {
	    	int lengthA = s.length();
	        int lengthB = t.length();
	        if (lengthA != lengthB){
	        	return false;
	        }
	        
	        List<String> a = Arrays.asList(s.split(""));
	        List<String> b = Arrays.asList(t.split(""));
	        Collections.sort(a);
	        Collections.sort(b);
	        CollectionUtil.print(a);
	        CollectionUtil.print(b);
	        for (int i = 0; i < lengthB; i++) {
				if (!a.get(i).equals(b.get(i))){
					return false;
				}
			}
	        return true;
	    }
	}
	public static class Solution2 {
		public boolean isAnagram(String s, String t) {
			int lengthA = s.length();
			int lengthB = t.length();
			if (lengthA != lengthB){
				return false;
			}
			Map<Character, Integer> aMap = new HashMap<>(lengthA);
			Map<Character, Integer> bMap = new HashMap<>(lengthB);
			for (int i = 0; i < s.length(); i++) {
				Integer aCount = aMap.get(s.charAt(i));
				if (aCount == null){
					aMap.put(s.charAt(i), 1);
				}else {
					aMap.put(s.charAt(i), aCount.intValue() + 1);
				}
				Integer bCount = bMap.get(t.charAt(i));
				if (bCount == null){
					bMap.put(t.charAt(i), 1);
				}else {
					bMap.put(t.charAt(i), bCount.intValue() + 1);
				}
			}
			
			
			for(Entry<Character, Integer> entry : aMap.entrySet()){
				Integer aCount = entry.getValue();
				Integer bCount = bMap.get(entry.getKey());
				if (bCount == null || aCount.intValue() != bCount.intValue()){
					return false;
				}
			}
			
			return true;
		}
	}
	
	public static class Solution3 {
		public boolean isAnagram(String s, String t) {
			int lengthA = s.length();
			int lengthB = t.length();
			if (lengthA != lengthB){
				return false;
			}
			int[] a = new int[26];
			int[] b = new int[26];
			for (int i = 0; i < s.length(); i++) {
				a[s.charAt(i) - 'a']++;
				b[t.charAt(i) - 'a']++;
			}
			
			for (int i = 0; i < 26; i++) {
				if (a[i]!=b[i]){
					return false;
				}
			}
			return true;
			
		}
	}
	public static class Solution4 {
		public boolean isAnagram(String s, String t) {
			char[] a = s.toCharArray();
			char[] b = t.toCharArray();
			
			Arrays.sort(b);
			Arrays.sort(a);
			
			return Arrays.equals(a, b);
		}
	}
	
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.isAnagram("car", "tar"));
		/*s = "anagram", t = "nagaram", return true.
				s = "rat", t = "car", return false.*/
		System.out.println(solution.isAnagram("anagram", "nagaram"));
		System.out.println(solution.isAnagram("rat", "car"));
		System.out.println(solution.isAnagram("", ""));
	}
}
