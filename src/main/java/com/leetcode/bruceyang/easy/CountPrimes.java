package com.leetcode.bruceyang.easy;

import java.util.Date;

public class CountPrimes {
	public static class Solution {
		
	    public int countPrimes(int n) {
	    	int count = 0;
	    	int maxDiv = (int) Math.sqrt(n);
	    	boolean[] nonPrimes = new boolean[n];
	        for (int i = 2; i <= maxDiv; i++) {
	        	for (int j = i; j*i < n; j++) {
	        		nonPrimes[j*i] = true;
				}
	        }
	        
	        for (int i = 2; i < nonPrimes.length; i++) {
				if (!nonPrimes[i]){
					count++;
				}
			}
	        
	        return count;
	    }
	}
	
	public static void main(String[] args) {
		// ����  ���ܱ��κ������ 1
		Solution solution = new Solution();
//		System.out.println(solution.countPrimes(1));
//		System.out.println(solution.countPrimes(2));
//		System.out.println(solution.countPrimes(3));
//		System.out.println(solution.countPrimes(4));
//		System.out.println(solution.countPrimes(5));
//		System.out.println(solution.countPrimes(6));
//		System.out.println(solution.countPrimes(7));
		System.out.println(solution.countPrimes(8));// 4
		System.out.println(solution.countPrimes(9));// 4
		System.out.println(solution.countPrimes(10));// 4
		System.out.println(solution.countPrimes(11));// 5
		System.out.println(solution.countPrimes(13));// 6
		System.out.println(solution.countPrimes(100));// 6
		long start = new Date().getTime();
//		System.out.println(solution.countPrimes(499979)); 
		System.out.println(solution.countPrimes(Integer.MAX_VALUE/100)); 
//		41538
//		14312
		System.out.println(new Date().getTime() - start);
	}
}
