package com.leetcode.bruceyang.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
	public static class Solution {
		public boolean containsNearbyDuplicate(int[] nums, int k) {
			// k should greater than zero
			Set<Integer> span = new HashSet<Integer>(k);
			int start = 0; 
			int end = 0;
			for (int i = 0; i < nums.length; i++) {
				int current = nums[i];
				if ( !span.contains(current)){
					span.add(current);
					end++;
				}else {
					return true;
				}
				
				if (end - start > k){
					span.remove(nums[start]);
					start++;
					
				}
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.containsNearbyDuplicate(new int[]{1}, 1));
//		System.out.println(solution.containsNearbyDuplicate(new int[]{2,2,4,5,6}, 1));
//		System.out.println(solution.containsNearbyDuplicate(new int[]{2,3,4,2,6,7}, 3));
//		System.out.println(solution.containsNearbyDuplicate(new int[]{3,4,4,5}, 1));
//		System.out.println(solution.containsNearbyDuplicate(new int[]{3,4,6,5}, 1));
		System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,1}, 1));
	}
}
