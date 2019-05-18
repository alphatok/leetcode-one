package com.leetcode.bruceyang.easy;

public class ZigZagConversion {
	public static class Solution {
		
		/**
		 * 
		 *	P   A   H   N
		 *	A P L S I I G
		 *	Y   I   R
		 *
		 *  X Z T R
		 *	Y D W
		 *
		 *  D     D     D     D
		 *  D   D D   D D   D D
		 *  D D   D D   D D   D
		 *  D     D     D     D
		 *  
		 *  ���忴
		 *  i + (2*numRows - 2)
		 *  
		 *  0     6     12
		 *  1   5 7   1113
		 *  2 4   8 10  14
		 *  3     9     15
		 **/
	    public String convert(String s, int numRows) {
	    	if (numRows == 1){
	    		return s;
	    	}
	    	
	    	int n = s.length();
	    	StringBuilder buffer = new StringBuilder(n);
	    	int groupCount = (2*(numRows) - 2);
	    	for(int i = 0; i < numRows; i++){
	    		for (int j = i; j < n; j+=groupCount) {
    				buffer.append(s.charAt(j));  // ÿһ����һ�������Ԫ��
	    			int loopStep = (2*(numRows - i) - 2);
	    			if (loopStep>0 && loopStep < groupCount && loopStep+j < n){
	    				buffer.append(s.charAt(loopStep+j));   // б���ϵ�Ԫ��
	    			}
				}
	    		
	    	}
	    	return buffer.toString();
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
		System.out.println(solution.convert("0123456789", 4)); 
		System.out.println(solution.convert("ABC", 2)); // "ACB"
	}
}
