package com.leetcode.en.easy;

public class BullsAndCows {
	
	public static class Solution {
	    public String getHint(String secret, String guess) {
	    	int[] unmatchCountArr = new int[10];
	        
	        int indexMatched = 0;
	        for (int i = 0; i < secret.length(); i++) {
	        	Character a = secret.charAt(i);
	        	Character b = guess.charAt(i);
	        	if (a == b){
	        		indexMatched++;
	        	}else {
					unmatchCountArr[a - '0'] += 1;
				}
			}
//	        CollectionUtil.print(unmatchArrCount);
	       
	        int indexUnMatched = 0;
	        for (int i = 0; i < secret.length(); i++) {
	        	Character a = secret.charAt(i);
	        	Character b = guess.charAt(i);
	        	if (a == b){
	        		continue;
	        	}else {
	        		int index = b - '0';
					if (unmatchCountArr[index] > 0){
						indexUnMatched++;
						unmatchCountArr[index] -= 1;
					}
				}
			}
	        
	        return indexMatched + "A" + indexUnMatched + "B";
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		// exactly in both digit and position (called "bulls") 
		// how many digits match the secret number but locate in the wrong position (called "cows")
		// use A to indicate the bulls and B to indicate the cows
		System.out.println(solution.getHint("1807", "7810")); // "1A3B"
		System.out.println(solution.getHint("1123", "0111")); // "1A1B"
		System.out.println(solution.getHint("1122", "2211")); // "0A4B"
		System.out.println(solution.getHint("1801", "7810")); // "1A2B"
		System.out.println(solution.getHint("4271", "1234")); // "1A2B"
		System.out.println(solution.getHint("1112", "2111")); // "2A2B"
		System.out.println(solution.getHint("1312", "2341")); // "1A2B"
		System.out.println(solution.getHint("1114", "5671")); // "0A1B"
	}
}
