package com.leetcode.bruceyang.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public static class Solution {
		
		/**char length ==  word length*/
		/**be careful the tail of str processment*/
	    public boolean wordPattern(String pattern, String str) {
	        int wordStartIndex = 0;
	        int patternIndex = 0;
	        String[] map = new String[256];
	        Map<String, Character> rmap = new HashMap<String, Character>(pattern.length());
	        for (int i = 0; i <= str.length(); i++) {
	        	if (i < str.length()){
	        		Character ch = str.charAt(i);
	        		if (ch != ' '){
						continue;
					}
	        	}
				
				String word = str.substring(wordStartIndex, i);
				i++;
				wordStartIndex = i;
				if (pattern.length() - 1 < patternIndex){
					return false;
				}
				Character chPattern = pattern.charAt(patternIndex);
				String mapWord = map[chPattern - ' '];
				if (mapWord == null){
					Character rch = rmap.get(word);
					if (rch != null && rch != chPattern){
						return false;
					}
					map[chPattern - ' '] = word;
					rmap.put(word, chPattern);
				}else {
					// compare
					for (int j = 0; j < mapWord.length() && j < word.length(); j++) {
						if (mapWord.charAt(j) != word.charAt(j)){
							return false;
						}
					}
				}
				
				patternIndex++;
			}
	        
	        return patternIndex == pattern.length();
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.wordPattern("", ""));
		System.out.println(solution.wordPattern("a", "ab"));// true
		System.out.println(solution.wordPattern("abba", "dog cat cat dog"));// true
		System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
		System.out.println(solution.wordPattern("jquery", "jquery"));
		System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(solution.wordPattern("abba", "dog dog dog dog"));// false
		System.out.println(solution.wordPattern("a", "xxsdd sd"));
	}
}
