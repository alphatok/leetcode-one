package com.leetcode.en.easy;

import com.alphatok.util.CollectionUtil;

public class MoveZeroes {
	public static class Solution {
		public void moveZeroes(int[] nums) {
			boolean indexInit = false;
			int firstZeroIndex = -1;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					if (indexInit) {
						nums[firstZeroIndex] = nums[i];
						nums[i] = 0;
						firstZeroIndex++;
					}
				} else {
					if (!indexInit) {
						indexInit = true;
						firstZeroIndex = i;
					}
				}
			}
		}
	}

	public static class Solution2 {
		public void moveZeroes(int[] nums) {
			int i = 0;
			int j = 0;
			while (j < nums.length) {
				if (nums[j] != 0) {
					if (j != i) {
						nums[i++] = nums[j];
						nums[j] = 0;
					} else {
						++i;
					}
				}
				++j;
			}
		}
	}

	public static class Solution3 {
		public void moveZeroes(int[] nums) {
			int count = 0; // Count of non-zero elements

			// Traverse the array. If element encountered is non-
			// zero, then replace the element at index 'count'
			// with this element
			for (int i = 0; i < nums.length; i++)
				if (nums[i] != 0)
					nums[count++] = nums[i]; // here count is
												// incremented

			// Now all non-zero elements have been shifted to
			// front and 'count' is set as index of first 0.
			// Make all elements 0 from count to end.
			while (count < nums.length)
				nums[count++] = 0;
		}
	}

	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		int[] nums = new int[] { 0, 1, 0, 3, 12, 0, 0, 13, 45 };
		solution.moveZeroes(nums);
		CollectionUtil.print(nums);
		int[] nums1 = new int[] { 3, 12 };
		solution.moveZeroes(nums1);
		CollectionUtil.print(nums1);
		int[] nums2 = new int[] { 0, 0, 0, 0, 0, 1 };
		solution.moveZeroes(nums2);
		CollectionUtil.print(nums2);
	}
}
