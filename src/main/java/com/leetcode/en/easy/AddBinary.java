package com.leetcode.en.easy;

public class AddBinary {
	public static class Solution{
		
		public String addBinary(String a, String b) {
			b = b.trim();
			a = a.trim();
	        
	        if (a.indexOf("1") < 0 && b.indexOf("1") < 0){
	        	return "0";
	        }

	        // �Ƴ�ǰ���0
	        if (a.indexOf("1") >= 0) {
				a = a.substring(a.indexOf("1"));
			}else{
				a = "";
			}
	        
	        if (b.indexOf("1") >= 0) {
				b = b.substring(b.indexOf("1"));
			}else {
				b = ""; 
			}
	        
	        // ��ת
	        char[] arrayA = new StringBuffer(a).reverse().toString().toCharArray();
	        char[] arrayB = new StringBuffer(b).reverse().toString().toCharArray();
	        int maxLength = Math.max(arrayA.length, arrayB.length);
	        int minLength = Math.min(arrayA.length, arrayB.length);
	        int[] arraySum = new int[maxLength + 1];
	        arraySum[maxLength] = 0;
	        int i = 0;
	        for (i = 0; i < minLength; i++) {
	        	arraySum[i] = (arrayA[i] == '1' ? 1:0) + (arrayB[i] == '1' ? 1:0);
			}
	        
	        if (arrayA.length > minLength ){
	        	for (int j = i; j < arrayA.length; j++) {
	        		arraySum[j] = (arrayA[j] == '1' ? 1:0);
				}
	        }
	        
	        if (arrayB.length > minLength ){
	        	for (int j = i; j < arrayB.length; j++) {
	        		arraySum[j] = (arrayB[j] == '1' ? 1:0);
				}
	        }
	        
	        boolean leek = false;
	        int j = 0;
	        for (j = 0; j < arraySum.length - 1; j++) {
	        	int value = arraySum[j] + (leek?1:0);
				if (value >= 2){
					leek = true;
					arraySum[j] = value % 2;
				}else {
					leek = false;
					arraySum[j] = value;
				}
			}
	        
	        // ��λ��λ
	        if (leek){
	        	arraySum[j] = 1;
	        }
	        
	        boolean valid = false;
	        StringBuffer buffer = new StringBuffer();
	        for (j = arraySum.length - 1; j >= 0; j--) {
	        	if (!valid){
	        		if (arraySum[j] > 0){
						valid = true;
					}else {
						continue;
					}
	        	}
	        	
				
				if (valid){
					buffer.append(String.valueOf(arraySum[j]));
				}	
			}
	        
	        return buffer.toString();
	    }
		
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.addBinary("1010", "1011"));
//		System.out.println(solution.addBinary("11", "111"));
	}
}
