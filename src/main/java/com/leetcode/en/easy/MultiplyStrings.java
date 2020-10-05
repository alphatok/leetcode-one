package com.leetcode.en.easy;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class MultiplyStrings {

	public static class Solution{
		
		public String multiply(String num1, String num2) {
			int[] num1IntArr = toIntArr(num1);
			int[] num2IntArr = toIntArr(num2);
			if (num1IntArr.length == 0 || num2IntArr.length == 0){
				return "";
			}
			
			if ("0".endsWith(num1.trim()) || "0".endsWith(num2.trim())){
				return "0";
			}
			
			
			Map<Integer, Integer> sumMap = new TreeMap<Integer, Integer>();
			for (int i = 0; i < num1IntArr.length; i++) {
				for (int j = 0; j < num2IntArr.length; j++) {
					int a = num1IntArr[i];
					int b = num2IntArr[j];
					int sum = a*b;
					if (sumMap.containsKey(i+j)){
						int initValue = sumMap.get(i+j);
						sumMap.put(i+j, initValue+sum);
					}else {
						sumMap.put(i+j, sum);
					}
				}
			}
			
			for (Entry<Integer, Integer> entry: sumMap.entrySet()) {
				if (entry.getValue() > 9){
					int preKey = entry.getKey() + 1;
					if (sumMap.containsKey(preKey)){
						int preValue = sumMap.get(preKey);
						sumMap.put(preKey, preValue + entry.getValue() / 10);
					}else {
						sumMap.put(preKey, entry.getValue() / 10);
					}
					sumMap.put(entry.getKey(), entry.getValue() % 10);
				}
			}
			
			StringBuffer buffer = new StringBuffer();
			for (Entry<Integer, Integer> entry: sumMap.entrySet()) {
				buffer.append(entry.getValue());
			}
			
			return buffer.reverse().toString();
	    }
		
		public int[] toIntArr(String num){
			int size = 0;
			String[] numStrArr = num.split("");
			for (int i = 0; i < numStrArr.length; i++) {
				String decStr = numStrArr[i];
				if (decStr.length() != 1){
					continue;
				}
				size++;
			}
			
			int index = 0;
			int[] intArray = new int[size];
			for (int i = 0; i < numStrArr.length; i++) {
				String decStr = numStrArr[i];
				if (decStr.length() != 1){
					continue;
				}
				intArray[size - 1 - index++] = Integer.parseInt(decStr);
			}
			
			return intArray;
		}
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int a = Math.abs(new Random().nextInt(452));
		int b = Math.abs(new Random().nextInt(435345));
		System.out.println(String.format("%s*%s=%s", a, b, a*b));
		
//		System.out.println(solution.multiply("", String.valueOf(b)));
//		System.out.println(solution.multiply("1", "2"));
//		System.out.println(solution.multiply("11", "11"));
		System.out.println(solution.multiply(String.valueOf(a), String.valueOf(b)));
	}
}
