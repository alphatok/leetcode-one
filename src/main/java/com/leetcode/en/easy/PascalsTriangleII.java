package com.leetcode.en.easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alphatok.util.CollectionUtil;

public class PascalsTriangleII {

	public static class Solution {
	    public List<Integer> getRow(int rowIndex) {
	    	rowIndex += 1;
	    	Map<Integer, BigInteger> factorialMap = new HashMap<>(rowIndex);
	    	if (rowIndex <= 0){
	    		return Collections.emptyList();
	    	}
	    	List<Integer> ret = new ArrayList<Integer>(rowIndex);
	    	
	    	BigInteger factorial = new BigInteger("1");
	    	for (int i = 1; i <= rowIndex; i++) {
	    		factorial = factorial.multiply(new BigInteger(i+""));
				factorialMap.put(i, factorial);
			}
	    	
	    	ret.add(1);
	    	int low = rowIndex - 1;
	    	for (int i = 1; i < rowIndex - 1; i++) {
	    		int c =  (factorialMap.get(low).divide((factorialMap.get(i).multiply(factorialMap.get(low - i))))).intValue();
	    		ret.add(c);
			}
	    	
	    	if (rowIndex - 1 >= 1){
	    		ret.add(1);
	    	}
	    	
	    	return ret;
	    }
	}
	
	public static class Solution2 {
	    public List<Integer> getRow(int rowIndex) {
	    	if (rowIndex < 0){
	    		return Collections.emptyList();
	    	}

	    	
	    	if (rowIndex == 0){
	    		return Arrays.asList(new Integer[]{1});
	    	}
	    	
	    	if (rowIndex == 1){
	    		return Arrays.asList(new Integer[]{1, 1});
	    	}
	    	
	    	int[] array = new int[rowIndex+1];
	    	array[0] = 1;
	    	array[1] = 1;
	    	for (int i = 2; i <= rowIndex; i++) {
	    		int stop = (i)/2;
	    		int j = i - 1;
	    		for (; j >= stop; j--) {
	    			array[j] = array[j] + array[j - 1];
				}
	    		j = i;
	    		array[j] = 1;
	    		int half = (j+1) / 2;
	    		int lastIndex = j;
	    		j = 1;
	    		for (; j < half; j++) {
	    			array[j] = array[lastIndex - j];
				}
			}
	    	
	    	List<Integer> ret = new ArrayList<Integer>(rowIndex+1);
	    	for (int i = 0; i < array.length; i++) {
	    		ret.add(array[i]);
			}
	    	return ret;
	    }
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 40; i++) {
//			CollectionUtil.print(new Solution().getRow(i));
//			CollectionUtil.print(new Solution2().getRow(i));
		}
		CollectionUtil.print(new Solution2().getRow(15));
		CollectionUtil.print(new Solution().getRow(15));
//		CollectionUtil.print(new Solution().getRow(5));
//		CollectionUtil.print(new Solution().getRow(6));
//		CollectionUtil.print(new Solution().getRow(7));
//		CollectionUtil.print(new Solution().getRow(8));
//		CollectionUtil.print(new Solution().getRow(9));
//		CollectionUtil.print(new Solution().getRow(10));
//		CollectionUtil.print(new Solution().getRow(12));
//		CollectionUtil.print(new Solution().getRow(13));
//		CollectionUtil.print(new Solution().getRow(21));
//		CollectionUtil.print(new Solution().getRow(20));
	}
}
