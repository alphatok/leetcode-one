package com.leetcode.bruceyang.util;

public class StringUtil {
	public static int[] toIntArray(int absInt){
		String intStr = String.valueOf(absInt);
		return toIntArr(intStr);
	}
	
	public static int[] toIntArr(String num){
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
	
	public static int[] toIntArray(int absInt, boolean reverse){
		String intStr = String.valueOf(absInt);
		if (reverse){
			intStr = new StringBuffer(intStr).reverse().toString();
		}
		String[] stringArray = intStr.split("");
		
		int size = 0;
		for (int i = 0; i < stringArray.length; i++) {
			String decStr = stringArray[i];
			if (decStr.length() != 1){
				continue;
			}
			size++;
		}
		
		int index = 0;
		int[] intArray = new int[size];
		for (int i = 0; i < stringArray.length; i++) {
			String decStr = stringArray[i];
			if (decStr.length() != 1){
				continue;
			}
			intArray[index++] = Integer.parseInt(decStr);
		}
		
		return intArray;
	}
	
	public static String repeat(String str, int count){
		if (str == null || count == 0){
			str = "";
		}
		if (count < 0 || str.isEmpty()){
			return str;
		}
		
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < count; i++) {
			buffer.append(str);
		}
		
		return buffer.toString();
	}
	
	public static void main(String[] args) {
//		System.out.println(toIntArray(12312312));
		System.out.println(toIntArr("987654"));
		System.out.println(repeat("1", 12));
	}
}
