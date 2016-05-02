package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.domain.ListNode;
import com.leetcode.bruceyang.util.ListNodeUtil;

public class RemoveNthNodeFromEndOfList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        int length = length(head);
	        if (n <= 0 || n > length){
	        	return head;
	        }
	        
	        int stopCount = length - n;
	        if (stopCount == 0){
	        	return head.next;
	        }else{
	        	ListNode pre = head;
	        	ListNode p = pre.next;
	        	int count = stopCount - 1;
	        	while (count > 0){
	        		pre = p;
	        		p = p.next;
	        		count--;
	        	}
	        	
	        	pre.next = p.next;
	        }
	        
	        return head;
	        // take care of the tail and head
	    }
	    
	    private int length(ListNode head){
	    	int count = 0;
	    	while (head != null){
	    		count++;
	    		head = head.next;
	    	}
	    	
	    	return count;
	    }
	}
	
	
	public static void main(String[] args){
		Solution solution = new Solution();
		ListNodeUtil.print(solution.removeNthFromEnd(ListNodeUtil.toListNodes(new int[]{}), 1));
		ListNodeUtil.print(solution.removeNthFromEnd(ListNodeUtil.toListNodes(new int[]{1}), 1));
		ListNodeUtil.print(solution.removeNthFromEnd(ListNodeUtil.toListNodes(new int[]{1,2}), 1));
		ListNodeUtil.print(solution.removeNthFromEnd(ListNodeUtil.toListNodes(new int[]{1,2,3}), 2));
		ListNodeUtil.print(solution.removeNthFromEnd(ListNodeUtil.toListNodes(new int[]{1,2,3}), 3));
	}
}
