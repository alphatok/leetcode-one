package com.leetcode.bruceyang.easy;

public class StringToInteger {
	public static class Solution {
		public int myAtoi(String str) {
			str = trimValid(str);
			return parseAsInt(str);
		}
		
		private int parseAsInt(String str) {
			long value= 0;
			boolean negative = false;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '-'){
					negative = true;
				}else if (ch >= '0' && ch <= '9') {
					value = 10 * value + (ch - '0');
					if (negative) {
						if (-value < Integer.MIN_VALUE){
							return Integer.MIN_VALUE;
						}
					}else {
						if (value > Integer.MAX_VALUE){
							return Integer.MAX_VALUE;
						}
					}
				}
			}
			
			return (int)value*(negative ? -1:1);
		}

		public String trimValid(String str){
			int i = 0;
			str = str.trim();
			int end = str.length();
			boolean signFlag = false; // ��⵽��ű�־(ֻ����һ����ű�־������Ϊ0�����λ֮����������)
			for (;i < str.length(); i++) {
				char ch = str.charAt(i);
				if ((ch >= '0' && ch <= '9') ){
					continue;
				}else if (ch == '+' || ch == '-') {
					if (signFlag){
						end = i;
						break;
					}else {
						signFlag = true;
					}
				}else{
					end = i;
					break;
				}
			}
			
			return str.substring(0, end).trim();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.myAtoi("-0004a"));
		System.out.println(solution.myAtoi("-+--0004"));
		System.out.println(solution.myAtoi("-1"));
		System.out.println(solution.myAtoi("  1"));
		System.out.println(solution.myAtoi("+-12"));  // 0
		System.out.println(solution.myAtoi("- 21"));  // 0
		System.out.println(solution.myAtoi("-"));
		System.out.println(solution.myAtoi("  a143"));
		System.out.println(solution.myAtoi("  3435a 1"));
		System.out.println(solution.myAtoi("-1"));
		System.out.println(solution.myAtoi("0"));
		System.out.println(solution.myAtoi("2145575756757557"));
		System.out.println(solution.myAtoi("0002145575756757557"));
		System.out.println(solution.myAtoi("0002145575756757557"));
		System.out.println(solution.myAtoi("-2145575756757557"));
	}
}
