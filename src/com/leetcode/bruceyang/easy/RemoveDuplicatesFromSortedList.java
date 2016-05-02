package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.domain.ListNode;
import com.leetcode.bruceyang.util.ListNodeUtil;

public class RemoveDuplicatesFromSortedList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	    	if (head == null || head.next == null){
	    		return head;
	    	}
	        ListNode r = head;
	        ListNode p = head.next;
	        while (p != null){
	        	if (p.val == r.val){
	        		p = p.next;
	        	}else {
					r.next = p;
					r = p;
				}
	        }
	        r.next = null;
	        
	        return head;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNodeUtil.print(solution.deleteDuplicates(ListNodeUtil.toListNodes(new int[]{})));
		ListNodeUtil.print(solution.deleteDuplicates(ListNodeUtil.toListNodes(new int[]{1})));
		ListNodeUtil.print(solution.deleteDuplicates(ListNodeUtil.toListNodes(new int[]{1,2,3})));
		ListNodeUtil.print(solution.deleteDuplicates(ListNodeUtil.toListNodes(new int[]{1,1,1,1,23,45})));
		ListNodeUtil.print(solution.deleteDuplicates(ListNodeUtil.toListNodes(new int[]{1,2,2,2,2,2,2})));
	}
}
