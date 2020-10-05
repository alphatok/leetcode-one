package com.leetcode.en.easy;

import com.alphatok.util.CollectionUtil;

public class RemoveDuplicatesFromSortedArray {
	public static class Solution {
	    public int removeDuplicates(int[] nums) {
	    	if (nums.length <= 1 ){
	    		return nums.length;
	    	}
	    	
	    	boolean initIndex = false;
	        int nextSetIndex = 1;
	        int size = 1;
	        int lastCheck = nums[0];
	        for (int i = 1; i < nums.length; i++) {
				if (nums[i] == lastCheck){
					if (!initIndex){
						nextSetIndex = i;
						initIndex = true;
					}
				}else {
					lastCheck = nums[i];
					nums[nextSetIndex] = lastCheck;
					nextSetIndex++;
					size++;
				}
			}
	        
	        return size;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = new int[]{1, 1, 2, 3,4,5,5,5,5,5,5,9,9};
		System.out.println(solution.removeDuplicates(nums1));
		CollectionUtil.print(nums1);
		int[] nums2 = new int[]{1, 2};
		System.out.println(solution.removeDuplicates(nums2));
		CollectionUtil.print(nums2);
		int[] nums3 = new int[]{};
		System.out.println(solution.removeDuplicates(nums3));
	}
}
