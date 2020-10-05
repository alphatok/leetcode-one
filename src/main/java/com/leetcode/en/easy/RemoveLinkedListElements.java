package com.leetcode.en.easy;

import com.alphatok.domain.ListNode;
import com.alphatok.util.ListNodeUtil;

public class RemoveLinkedListElements {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class Solution {
	    public ListNode removeElements(ListNode head, int val) {
	    	if (head == null){
	    		return null;
	    	}
	    	
	    	ListNode p = head;
	    	ListNode pre = null;
	    	ListNode newHead = head;
	    	while(p != null){
	    		if (p.val == val){
	    			if (newHead == p){
	    				newHead = p.next;
	    				pre = null;
						p = p.next;
	    			}else {
	    				pre.next = p.next;
						p = p.next;
					}
	    		}else {
					pre = p;
					p = p.next;
				}
	    	}
	    	
	    	return newHead;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNodeUtil.print(solution.removeElements(ListNodeUtil.toListNodes(new int[]{1,2,4,6,5,7,6}), 6));
		ListNodeUtil.print(solution.removeElements(ListNodeUtil.toListNodes(new int[]{6}), 6));
		ListNodeUtil.print(solution.removeElements(ListNodeUtil.toListNodes(new int[]{6,6}), 6));
		ListNodeUtil.print(solution.removeElements(ListNodeUtil.toListNodes(new int[]{6,6,8}), 6));
		ListNodeUtil.print(solution.removeElements(ListNodeUtil.toListNodes(new int[]{}), 6));
		ListNodeUtil.print(solution.removeElements(ListNodeUtil.toListNodes(new int[]{6, 7}), 6));
		ListNodeUtil.print(solution.removeElements(ListNodeUtil.toListNodes(new int[]{6, 7, 9}), 6));
	}
}
