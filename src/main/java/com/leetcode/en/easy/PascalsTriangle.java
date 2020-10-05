package com.leetcode.en.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.alphatok.util.CollectionUtil;

public class PascalsTriangle {
	public static class Solution {
	    public List<List<Integer>> generate(int numRows) {
	    	List<List<Integer>> ret = new ArrayList<>(numRows);
	    	if (numRows == 0){
	    		return ret;
	    	}
	    	ret.add(Arrays.asList(new Integer[]{1}));
	    	if (numRows == 1){
	    		return ret;
	    	}
	    	
	    	ret.add(Arrays.asList(new Integer[]{1, 1}));
	    	if (numRows == 2){
	    		return ret;
	    	}
	    	
	    	for (int i = 3; i <= numRows; i++) {
				List<Integer> row = new ArrayList<>(i);
				List<Integer> lastRow = ret.get(i - 2);
				row.add(1);
				for (int j = 1; j < i -1; j++) {
					row.add(lastRow.get(j) + lastRow.get(j - 1));
				}
				row.add(1);
				ret.add(row);
			}
	    	
	    	return ret;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> ret = solution.generate(5);
		for (Iterator<List<Integer>> iterator = ret.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			CollectionUtil.print(list);
		}
	}
}
