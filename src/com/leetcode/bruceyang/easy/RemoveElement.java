package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.util.CollectionUtil;

public class RemoveElement {
	public static class Solution {
	    public int removeElement(int[] nums, int val) {
	        int i = 0; int j = nums.length - 1;
	        int size = 0;
	        for (; j >= i;) {
				if (nums[i] != val){
					i++;
					size++;
					continue;
				}
				
				if (nums[j] == val){
					j--;
					continue;
				}
				
				nums[i] = nums[j];
				i++;
				j--;
				size++;
			}
	        
	        return size;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{3,2,2,3};
		System.out.println(solution.removeElement(nums, 3));
		int[] nums1 = new int[]{3,2,2,3, 2,3,4,5,2,4,5,3};
		System.out.println(solution.removeElement(nums1, 3));
		CollectionUtil.print(nums1);
		int[] nums2 = new int[]{3};
		System.out.println(solution.removeElement(nums2, 3));
		CollectionUtil.print(nums2);
		int[] nums3 = new int[]{4};
		System.out.println(solution.removeElement(nums3, 3));
		CollectionUtil.print(nums3);
	}
}
