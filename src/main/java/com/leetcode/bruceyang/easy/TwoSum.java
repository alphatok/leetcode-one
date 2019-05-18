package com.leetcode.bruceyang.easy;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.bruceyang.util.CollectionUtil;

public class TwoSum {
	public static class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        int[] ret = new int[2];

	        Map<Integer, Integer> map = new HashMap<>(nums.length);
	        for (int i = 0; i < nums.length; i++) {
				if (map.containsKey(target- nums[i])){
					ret = new int[]{map.get(target-nums[i]), i};
					break;
				}else {
					map.put(nums[i], i);
				}
			}
	        
	        return ret;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		CollectionUtil.print(solution.twoSum(new int[]{}, 1));
		CollectionUtil.print(solution.twoSum(new int[]{2,3,4,5,5}, 9));
		CollectionUtil.print(solution.twoSum(new int[]{-3,4,5, 90}, 1));
		CollectionUtil.print(solution.twoSum(new int[]{-129, 130}, 1));
	}
}
