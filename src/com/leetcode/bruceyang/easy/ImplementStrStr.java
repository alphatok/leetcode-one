package com.leetcode.bruceyang.easy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ImplementStrStr {
	public static class Solution {
		/**
		 * for each letter, prefix equals suffix(length = num), then move back (n - num) 
		 * where letters mismatched
		 * ABCDABDX
		 * 00001200
		 * 
		 * AB..AB.
		 * 
		 * ABCDABDEFD
		 * // ABABABCDABABABDEX
		 * // 00123420123456420
		 *          C ABAB's prefix&suffix(4 chars before c equals 4 chars start from zero)
		 * http://www.cnblogs.com/c-cloud/p/3224788.html
		 **/
		private void prepareKmpArray(int[] shiftTable, String needle){
			int shift = 0; // chars shift back (also the index(start from need zero))
			shiftTable[0] = 0; // first char
			for (int i = 1; i < needle.length(); i++) { // start from the second
				if (needle.charAt(i) != needle.charAt(shift)){
					if (shift > 0){
						// reset shift(start index from needle)
						shift = shiftTable[shift - 1]; // 
					}else {
						// still zero
					}
				}
				
				if (needle.charAt(i) == needle.charAt(shift)){
					shift++;
				}
				shiftTable[i] = shift;
			}
		}
		
	    public int strStr(String haystack, String needle) {
	    	if (needle.length() == 0){
	    		return 0;
	    	}
	    	
	    	if (needle.length() > haystack.length()){
	    		return -1;
	    	}
	    	
	    	int[] shift = new int[needle.length()];
			prepareKmpArray(shift, needle);
//			CollectionUtil.print(shift);
	    	int q = 0, index = -1;
	    	for (int i = 0; i < haystack.length(); ++i) {
				if (haystack.charAt(i) == needle.charAt(q)){
					q++;
				}else {
					if (q > 0){
						q = shift[q - 1];
						i--;
					}
				}
				
				if (q == needle.length()){
					index = i - needle.length() + 1;
					break;
				}
			}
	    	
			return index;
	    }
	}
	
	
	public static class SolutionBm{
		public int strStr(String haystack, String needle){
			if (needle.length() == 0){
				return 0;
			}
			
			Map<Character, Integer> shiftMap = new HashMap<>();
			
			// last occurence of char
			for (int i = 0; i < needle.length(); i++) {
				shiftMap.put(needle.charAt(i), i);
			}
			
			int m = needle.length();
			int n = haystack.length();
			
			int i = m - 1;
			int j = m - 1;
			while( i <= n - 1){
				if (haystack.charAt(i) == needle.charAt(j)){
					if ( j == 0){
						return i;
					}else{
						j--;
						i--;
					}
				}else {
					int shift = -1;
					if (shiftMap.containsKey(haystack.charAt(i))){
						shift = shiftMap.get(haystack.charAt(i));
					}
					i += m - Math.min(j, 1+ shift); // j + 1前面 
					j = m - 1;
				}
			}
			
			return -1;
		}
	}
	
	@SuppressWarnings("unused")
	private static void solution(){
		Solution solution = new Solution();//ABCDABD
		System.out.println(solution.strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
		// ABCDABCDEFG
		// 00001234000
//		System.out.println(solution.strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABCDEFG"));
		// ABABABCDABABABDEX
		// 00123420123456420
		// 
//		System.out.println(solution.strStr("BBC ABCDAB ABCDABCDABDE", "ABABABCDABABABDEX"));
//		System.out.println(solution.strStr("abcdefg", "bcd"));
//		System.out.println(solution.strStr("abdcdefg", "bcd"));
//		System.out.println(solution.strStr("abcdefg", "efg"));
		System.out.println(solution.strStr("abcdefg", ""));
		System.out.println(solution.strStr("mississippi", "issip"));
		
//		System.out.println("sdfasd".indexOf(""));
	}
	
	static Map<String, String> testCases = new HashMap<>();
	static{
		testCases.put("", "");
//		testCases.put("34563453456345hdfhgdffffffffffffffffffffffffffgdfghdfgh 456354ethdfhgdfg"
//				+ "dfnalsdjflasjdfoajsdfoan,niovnandfklandsfgaklsndfgasdfnalsdjflasjdfoajsdfoan,niovnandfklandsfgaklsndfgasdfnalsdjflasjdfoajsdfoan"
//				+ ",niovnandfklandsfgaklsndfgasdfnalsdjflasjdfoajsdfoan,niovnandfklandsfgaklsndfgasdfnalsdjflasjdfoajsdfoan,"
//				+ "niovnandfklandsfgaklsndfgasdfnalsdjflasjdfoajsdfoan,niovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdf"
//				+ "niovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdf"
//				+ "niovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdf"
//				+ "niovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdf"
//				+ "niovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdf"
//				+ "niovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfghjkl", "gasdfniovnandfklandsfgaklsndfgasdfniovnandfklandsfgaklsndfgasdfniovna");
//		testCases.put("mississippi", "issip");
//		testCases.put("34563456345", "245");
//		testCases.put("3563456345634563", "345");
//		testCases.put("3634563456373657456hfgfjfghj", "4");
//		testCases.put("kiasdbkjdic ksk5e344fff", "4");
//		testCases.put("23444452gesdfghdfhge3hdhdfghdfg dfghdfghdfghdfhg2", "2534"); // 5234
//		testCases.put("23444452gesdfghdfhge3hdhdfghdfg dfghdfghdfghdfhgsdaf", "4452"); // 5234
//		testCases.put("23444444444444444444444452gesdfghdfhge3hdhdfghdfg dfghdfghdfghdfhg", "25345234"); // 5234
	}
	
	private static void solutionBm(){
		
		SolutionBm solution = new SolutionBm();
		for (Entry<String, String> entry : testCases.entrySet()) {
			Date start = new Date();
			System.out.println(solution.strStr(entry.getKey(), entry.getValue()));
			System.out.println("strstr"+(new Date().getTime() - start.getTime()));
			start = new Date();
			System.out.println(entry.getKey().indexOf(entry.getValue()));
			System.out.println("indexOf"+(new Date().getTime() - start.getTime()));
		}
		
	}
	public static void main(String[] args) {
		solutionBm();
	}
}
