package com.leetcode.en.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public static class Solution {
	    public List<String> summaryRanges(int[] nums) {
	        List<String> list = new ArrayList<String>(nums.length);
	        if (nums.length == 0){
	        	return list;
	    	}else if (nums.length == 1) {
				list.add(nums[0] + "");
				return list;
			}
	        
	        StringBuilder range = null;
	        boolean rangeStarted = false;
	        for (int i = 0; i < nums.length;i++) {
	        	if (rangeStarted){ // continue pre element
	        		if (nums.length - i > 1){
	        			if (nums[i+1] - nums[i] == 1){
	        				continue;
	        			}else{
	        				range.append("->").append(nums[i] + "");
		        			list.add(range.toString());
		        			
		        			range = new StringBuilder();
		        			rangeStarted = false;
	        			}
	        		}else if (nums.length - i == 1){
	        			range.append("->").append(nums[i] + "");
	        			list.add(range.toString());
	        		}
	        	}else{
	        		range = new StringBuilder();
	        		if (i >= 0 && i < nums.length -1){
	        			if (nums[i+1] - nums[i] == 1){
	        				range.append(nums[i] + "");
	    	        		rangeStarted = true;
	        			}else {
	        				list.add("" + nums[i]);
		        			rangeStarted = false;
		        			range = new StringBuilder();
						}
	        		}else if (i == 0){
	        			if (nums[i+1] - nums[i] == 1){
	        				range.append(nums[i] + "");
	    	        		rangeStarted = true;
	        			}else {
	        				list.add("" + nums[i]);
		        			rangeStarted = false;
		        			range = new StringBuilder();
						}
	        		}else if (i == nums.length -1) {
	        			list.add("" + nums[i]);
					}
	        	}
			}
	        
	        return list;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.summaryRanges(new int[]{})); // ["0->2","4->5","7"].
		System.out.println(solution.summaryRanges(new int[]{1}));
		System.out.println(solution.summaryRanges(new int[]{0,1}));
		System.out.println(solution.summaryRanges(new int[]{1,3}));
		System.out.println(solution.summaryRanges(new int[]{1,9}));
		System.out.println(solution.summaryRanges(new int[]{1,5,9}));
		System.out.println(solution.summaryRanges(new int[]{1,2,3}));
		System.out.println(solution.summaryRanges(new int[]{1,2,6,7}));
		System.out.println(solution.summaryRanges(new int[]{1, 3,4, 9}));
		System.out.println(solution.summaryRanges(new int[]{0,1,2,4,5,7})); // ["0->2","4->5","7"].
	}
}
