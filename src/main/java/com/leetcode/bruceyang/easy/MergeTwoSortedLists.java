package com.leetcode.bruceyang.easy;

import com.alphatok.domain.ListNode;
import com.alphatok.util.ListNodeUtil;

public class MergeTwoSortedLists {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class Solution {
	    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    	ListNode head = null;
	    	ListNode p = null;
	    	while(l1 != null && l2 != null){
	    		if (l1.val >= l2.val){
	    			if (head == null){
	    				head = l2;
	    				p = head;
	    				l2 = l2.next;
	    			}else {
						p.next = l2;
						p = l2;
						l2 = l2.next;
					}
	    		}else {
	    			if (head == null){
	    				head = l1;
	    				p = head;
	    				l1 = l1.next;
	    			}else {
						p.next = l1;
						p = l1;
						l1 = l1.next;
					}
				}
	    	}
	    	
			if (l1 == null){
				if (head == null){
					 head = l2;
					 p = l2;
					 if (l2 != null){
						 l2 = l2.next;
					 }
				}else {
					p.next = l2;
				}
			}
			
			if (l2 == null){
				if (head == null){
					 head = l1;
					 p = l1;
					 if (l1 != null){
						 l1 = l1.next;
					 }
				}else {
					p.next = l1;
				}
			}
	    	
	    	
	    	return head;
	    }
	}
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNodeUtil.print(solution.mergeTwoLists(ListNodeUtil.toListNodes(new int[]{1,9,90}), ListNodeUtil.toListNodes(new int[]{2,3,4,7})));
		ListNodeUtil.print(solution.mergeTwoLists(ListNodeUtil.toListNodes(new int[]{}), ListNodeUtil.toListNodes(new int[]{1,2,3})));
		ListNodeUtil.print(solution.mergeTwoLists(ListNodeUtil.toListNodes(new int[]{}), ListNodeUtil.toListNodes(new int[]{})));
		ListNodeUtil.print(solution.mergeTwoLists(ListNodeUtil.toListNodes(new int[]{10}), ListNodeUtil.toListNodes(new int[]{1,2,3})));
	}
}
