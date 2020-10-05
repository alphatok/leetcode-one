package com.leetcode.en.easy;

public class CountAndSay {
	public static class Solution {
	    public String countAndSay(int n) {
	    	String one = "1";
	    	if (n == 1) {
				return one;
			}
	    	
	    	StringBuilder buffer = new StringBuilder();
	    	buffer.append(one);
	    	int count = 0;
        	char lastChar = '0';
        	
	    	StringBuilder result = new StringBuilder();
	        for (int i = 1; i < n; i++) {
				for (int j = 0; j < buffer.length(); j++) {
					if (count == 0){
						lastChar = buffer.charAt(j);
						count = 1;
						continue;
					}
					if (lastChar == buffer.charAt(j)){
						count++;
					}else {
						result.append(count).append(lastChar);
						count = 1;
						lastChar = buffer.charAt(j);
					}
				}
				
				if (count > 0){
					result.append(count).append(lastChar);
				}
				
				if (i < n - 1){
					buffer.setLength(0);
					buffer.append(result);
					result.setLength(0);
					count = 0;
				}
			}
	        
	        
	        return result.toString();
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.countAndSay(1));
//		System.out.println(solution.countAndSay(2));
//		System.out.println(solution.countAndSay(3));
		System.out.println(solution.countAndSay(4));
		System.out.println(solution.countAndSay(5));
		System.out.println(solution.countAndSay(6));
		System.out.println(solution.countAndSay(7));
		System.out.println(solution.countAndSay(8));
		System.out.println(solution.countAndSay(20));
		//11131221131211132221232112111312111213111213211231132132211211131221131211221321123113213221123113112221131112311332211211131221131211132211121312211231131112311211232221121321132132211331121321231231121113112221121321133112132112312321123113112221121113122113121113123112112322111213211322211312113211
		//11131221131211132221232112111312111213111213211231132132211211131221131211221321123113213221123113112221131112311332211211131221131211132211121312211231131112311211232221121321132132211331121321231231121113112221121321133112132112312321123113112221121113122113121113123112112322111213211322211312113211

	}
}
