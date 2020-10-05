package com.leetcode.en.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public static class Solution {
	    public boolean containsDuplicate(int[] nums) {
	        Set<Integer> set = new HashSet<Integer>(nums.length);
	        for (int i = 0; i < nums.length; i++) {
				if (set.contains(nums[i])){
					return true;
				}else{
					set.add(nums[i]);
				}
			}
	        
	        return false;
	    }
	}
	
	public static class Solution2 {
		public boolean containsDuplicate(int[] nums) {
			Set<Integer> set = new HashSet<Integer>(nums.length);
			for (int a : nums) {
				if (!set.add(a)){
					return true;
				}
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.containsDuplicate(new int[]{1,2,3,4}));
		System.out.println(solution.containsDuplicate(new int[]{1,2,3,3}));
		Solution2 solution2 = new Solution2();
		System.out.println(solution2.containsDuplicate(new int[]{1,2,3,4}));
		System.out.println(solution2.containsDuplicate(new int[]{1,2,3,3}));
	}
}
