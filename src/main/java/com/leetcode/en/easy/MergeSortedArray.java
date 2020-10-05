package com.leetcode.en.easy;

import com.alphatok.util.CollectionUtil;

public class MergeSortedArray {
	public static class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			for (int i = m - 1; i >= 0; i--) {
				nums1[i + n] = nums1[i];
			}

			int i = n, j = 0, p = 0;
			for (; i < m + n && j < n;) {
				if (nums1[i] <= nums2[j]) {
					nums1[p] = nums1[i];
					p++;
					i++;
				} else {
					nums1[p] = nums2[j];
					p++;
					j++;
				}
			}

			if (j == n) {
				for (int j2 = i; j2 < m + n; ) {
					nums1[p] = nums1[j2];
					p++;
					j2++;
				}
			} else if (i == m + n) {
				for (int j2 = j; j2 < n; ) {
					nums1[p] = nums2[j2];
					p++;
					j2++;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int m = 4;
		int[] nums2 = new int[] { 1, 2, 4, 10 };
		int[] nums1 = new int[m + nums2.length];
		nums1[0] = 1;
		nums1[1] = 2;
		nums1[2] = 3;
		nums1[3] = 9;
		solution.merge(nums1, m, nums2, nums2.length);
		CollectionUtil.print(nums1);
	}
}
