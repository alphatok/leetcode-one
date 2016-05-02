package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.util.CollectionUtil;

public class RangeSumQueryImmutable {
	public static class NumArray {

		private static int[] cache = null;
		
		public NumArray(int[] nums) {
			if (null == nums || nums.length == 0){
				cache = new int[]{0};
				return;
			}
			
			CollectionUtil.print(nums);
			cache = new int[nums.length];
			cache[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				cache[i] = cache[i - 1] + nums[i];
			}
			
			CollectionUtil.print(cache);
		}

		public int sumRange(int i, int j) {
			int lastIndex = cache.length - 1;
			i = (i < 0) ? 0 : i;
			i = (i > lastIndex) ? lastIndex : i;
			j = (j < 0) ? 0 : j;
			j = (j > lastIndex) ? lastIndex : j;
			if (i == 0){
				return cache[j];
			}else {
				return cache[j] - cache[i -1];
			}
		}
	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);

	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });
		System.out.println(numArray.sumRange(0, 0));
		System.out.println(numArray.sumRange(0, 1));
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
	}
}
