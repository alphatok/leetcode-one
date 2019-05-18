package com.leetcode.bruceyang.easy;

public class IntegerToRoman {
	public static class Solution {
		
		static String[][] cache = new String[5][10];
		static{
			cache[1] = new String[]{"", "I", "II", "III", "VI", "V", "IV", "IIV", "IIIV", "XI"};
			cache[2] = new String[]{"", "X", "XX", "XXX", "LX", "L", "XL", "XXL", "XXXL", "CX"};
			cache[3] = new String[]{"", "C", "CC", "CCC", "DC", "D", "CD", "CCD", "CCCD", "MC"};
			cache[4] = new String[]{"", "M", "MM", "MMM", "", "", "", "", "", ""};
		}
		
	    public String intToRoman(int num) {
	    	if (num > 3999){
	    		return "";
	    	}
	        StringBuilder buffer = new StringBuilder(30);
	        
	        int digitLevel = 1;
	        while( num > 0){
	        	buffer.append(cache[digitLevel++][num % 10]);
	        	num = num / 10;
	        }
	        
	        return buffer.reverse().toString();
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.intToRoman(1));
//		System.out.println(solution.intToRoman(9));
//		System.out.println(solution.intToRoman(90));
//		System.out.println(solution.intToRoman(10));
//		System.out.println(solution.intToRoman(99));
		System.out.println(solution.intToRoman(101));
		System.out.println(solution.intToRoman(1001));
		System.out.println(solution.intToRoman(566));
		System.out.println(solution.intToRoman(621));
		System.out.println(solution.intToRoman(1996));
		System.out.println(solution.intToRoman(2016));
		System.out.println(solution.intToRoman(3678));
		
//		System.out.println(solution.romanToInt("DLXVI")); // 566
//		System.out.println(solution.romanToInt("DCXXI")); // 621
//		System.out.println(solution.romanToInt("MCMXCVI")); // 1996
//		System.out.println(solution.romanToInt("MCCMXCVI")); // 2016
//		System.out.println(solution.romanToInt("MMMDCLXXVIII")); //3678
	}
}
