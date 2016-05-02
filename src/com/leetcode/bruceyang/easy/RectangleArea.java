package com.leetcode.bruceyang.easy;

public class RectangleArea {
	public static class Solution {
		
		/**不一定有交点，可能是嵌套*/
	    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	        int sum = (C-A)*(D-B) + (G-E)*(H-F);
	        int rightX = Math.min(C, G);
	        int rightY = Math.min(D, H);
	        int leftX = Math.max(A, E);
	        int leftY = Math.max(B, F);
	        int overlap = (rightX - leftX) * (rightY - leftY);
	        if (rightX > leftX && rightY > leftY){
	        	return sum - overlap;
	        }else {
				return sum;
			}
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2)); // 16
		System.out.println(solution.computeArea(-2, -2, 2, 2, -1, -1, 1, 1)); // 16
	}
}
