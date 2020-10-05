package com.leetcode.en.easy;

public class BestTimeBuyAndSellStock {
	public static class Solution {
	    public int maxProfit(int[] prices) {
	    	if (prices.length <= 1){
	    		return 0;
	    	}
	    	
	    	int min = prices[0];
	    	int maxProfit = 0;
	    	for (int i = 1; i < prices.length; i++) {
	    		min = min <= prices[i] ? min : prices[i];
	    		maxProfit = maxProfit > (prices[i] - min) ? maxProfit:(prices[i] - min);
			}
	    	
	    	return maxProfit;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().maxProfit(new int[]{1, 9, 1, 1, 5}));
		System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 1, 1, 5}));
	}
}
