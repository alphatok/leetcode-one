package com.leetcode.en.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {
	public static class Solution {
	    public int majorityElement(int[] nums) {
	    	Map<Integer, Integer> countMap = new HashMap<>(nums.length);
	        for (int i = 0; i < nums.length; i++) {
				Integer value = countMap.get(nums[i]);
				if(null == value){
					countMap.put(nums[i], 1);
				}else {
					countMap.put(nums[i], value.intValue()+1);
				}
			}
	        
	        int result = -1;
	        int max = 0;
	        for (Entry<Integer, Integer> entry : countMap.entrySet()) {
				if (entry.getValue().intValue() > max){
					result = entry.getKey().intValue();
					max = entry.getValue().intValue();
				}
			}
	        
	        return result;
	    }
	}
	public static class Solution2 {
		public int majorityElement(int[] nums) {
			int possible = 0;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (count == 0){
					count++;
					possible = nums[i];
				}else {
					if (possible == nums[i]){
						count++;
					}else {
						count--;
					}
				}
			}
			
			return possible;
		}
	}
	
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.majorityElement(new int[]{1,2,2,1,2,3,3,3,3,3,3,3,3,2,2}));
		System.out.println(solution.majorityElement(new int[]{6,5,5}));
		System.out.println(solution.majorityElement(new int[]{4,5,4}));
	}
}
