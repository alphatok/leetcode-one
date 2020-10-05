package com.leetcode.en.easy;

import org.junit.Assert;

public class SearchInsertPosition {

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums[nums.length - 1] < target){
                return nums.length;
            }

            if (nums.length == 1){
                if (nums[0] >= target) {
                    return 0;
                }else{
                    return 1;
                }
            }

            return binarySearch(nums, 0, nums.length - 1, target);
        }

        private int binarySearch(int[] nums, int from, int to, int target) {
            if (to == from + 1) {
                if (nums[from] >= target) {
                    return from;
                }else if (nums[to] >= target){
                    return to;
                }else{
                    return to + 1;
                }
            }else{
                int mid = (from + to) / 2;

                if (nums[mid] > target){
                    return binarySearch(nums, from, mid, target);
                }else{
                    return binarySearch(nums, mid, to, target);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Assert.assertEquals("", 0, solution.searchInsert(new int[]{1}, 1)); // 0
        Assert.assertEquals("", 0, solution.searchInsert(new int[]{1}, 0)); // 0
        Assert.assertEquals("", 1, solution.searchInsert(new int[]{1}, 2)); // 1
        Assert.assertEquals("", 0, solution.searchInsert(new int[]{1, 2}, 1)); // 0
        Assert.assertEquals("", 1, solution.searchInsert(new int[]{1, 2}, 2)); // 1
        Assert.assertEquals("", 1, solution.searchInsert(new int[]{1, 2, 4}, 2)); // 1
        Assert.assertEquals("", 2, solution.searchInsert(new int[]{1, 2, 4}, 3)); // 2
        Assert.assertEquals("", 2, solution.searchInsert(new int[]{1, 2, 4, 5}, 3)); // 2
        Assert.assertEquals("", 1, solution.searchInsert(new int[]{1, 3, 4, 5}, 2)); // 1
        Assert.assertEquals("", 0, solution.searchInsert(new int[]{1, 2, 4}, 0)); // 0
        Assert.assertEquals("", 3, solution.searchInsert(new int[]{1, 2, 4}, 5)); // 3
    }
}
