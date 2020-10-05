package com.leetcode.en.easy;

public class PlusOne {
	public static class Solution {

		/**[1,5]->[1,6]*/
		public int[] plusOne(int[] digits) {
			if (digits.length == 0) {
				return new int[] { 1 };
			}

			digits[digits.length -1] = digits[digits.length - 1] + 1;
			boolean leek = false;
			for (int i = digits.length - 1; i >= 0; i--) {
				int value = digits[i] + (leek ? 1 : 0);
				if (value > 9) {
					leek = true;
					digits[i] = value % 10;
				} else {
					leek = false;
					digits[i] = value;
				}
			}

			// ���λ��λ
			if (leek){
				int[] newDigits = new int[digits.length + 1];
				for (int i = digits.length-1; i >= 0; i--) {
					newDigits[i+1] = digits[i];
				}
				
				newDigits[0] = 1;
				return newDigits;
			}
			
			return digits;  
		}

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] digits = new int[] {8, 9, 9, 9 };
		digits = solution.plusOne(digits);
	}
}
