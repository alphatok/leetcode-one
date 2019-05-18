package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.util.CollectionUtil;

public class RotateArray {
	public static class Solution{

	    public void rotate(int[] nums, int k) {
	    	int n = nums.length;
	    	int step = k % n;
	        if (n <= 1 || step == 0){
	        	return;
	        }
	        
	        /**twice rotate back to origin order*/
	        reverse(nums, 0, n - step - 1);
	        reverse(nums, n - step, n - 1);
	        reverse(nums, 0, n - 1);
	    }

	    
	    private void reverse(int[] nums, int b, int e){
	    	for (; b < e; b++, e--) {
				int tmp = nums[b];
				nums[b] = nums[e];
				nums[e] = tmp;
			}
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		solution.rotate(nums, 9);
		CollectionUtil.print(nums);
	}
}
