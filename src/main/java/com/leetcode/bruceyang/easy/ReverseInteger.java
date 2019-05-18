package com.leetcode.bruceyang.easy;

public class ReverseInteger {
	public static class Solution{

	    public int reverse(int x) {
	        
	        if (x > -10 && x < 10){
	        	return x;
	        }
	        
	        String unsignedStr = "";
	        if (x>0){
	        	 unsignedStr = String.valueOf(x);
	        }else {
	        	unsignedStr = String.valueOf(x).substring(1);
			}
	        char[] chArray = unsignedStr.toCharArray();
	        reverse(chArray, 0, chArray.length - 1);
	        StringBuffer buffer = new StringBuffer();
	        for (int i = 0; i < chArray.length; i++) {
	        	buffer.append(chArray[i]);
			}
	        
	        long value = ((x>0)?1:-1)*Long.parseLong(buffer.toString());
	        if (value > Integer.MAX_VALUE){
	        	return 0;
	        }else if (value < Integer.MIN_VALUE ) {
				return 0;
			}else {
				 return (int)value;
			}
	    }

	    private void reverse(char[] nums, int b, int e){
	    	for (; b < e; b++, e--) {
	    		char tmp = nums[b];
				nums[b] = nums[e];
				nums[e] = tmp;
			}
	    }
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(1234567899));
		System.out.println(solution.reverse(-1234567899));
		System.out.println(solution.reverse(-1234));
		System.out.println(solution.reverse(Integer.MAX_VALUE));
		System.out.println(solution.reverse(Integer.MIN_VALUE));
		System.out.println(solution.reverse(+1234));
	}
}
