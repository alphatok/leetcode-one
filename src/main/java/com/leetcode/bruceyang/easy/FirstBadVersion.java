package com.leetcode.bruceyang.easy;

import java.util.Date;
import java.util.Random;

public class FirstBadVersion {
	public static class VersionControl{
		
		private static int bad = new Random().nextInt(Integer.MAX_VALUE);
		 boolean isBadVersion(int version){
			 if (version >= bad){
				 return true;
			 }
			 return false;
		 }
	}
	
	public static class Solution extends VersionControl {
	    public int firstBadVersion(int n) {
	        int end = n;
	        int start = 1;
	        int firsetBadVersion = -1;
	    	while(start <= end){
	    		int middle = start/2 + end/2;		// ����+-ע�����
	        	boolean result = isBadVersion(middle);
	        	if (result){
	        		end = middle;
	        	}else {
					start = middle + 1;
				}
	        	
	        	if (start - end  >= 0){				// ����+-ע�����
	        		firsetBadVersion = end;
	        		break;
	        	}
	        	
	        }
	    	
	    	return firsetBadVersion;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		123456789
		long startTime = new Date().getTime();
		System.out.println(solution.firstBadVersion(Integer.MAX_VALUE));
		System.out.println(new Date().getTime() - startTime);
	}
}
