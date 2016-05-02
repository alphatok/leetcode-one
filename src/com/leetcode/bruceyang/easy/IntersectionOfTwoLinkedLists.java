package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.domain.ListNode;
import com.leetcode.bruceyang.util.ListNodeUtil;

public class IntersectionOfTwoLinkedLists {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public static class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	    	int lengthA = 0;
	    	int lengthB = 0;
	    	ListNode a = headA;
	    	ListNode b = headB;
	    	while(a != null){
	    		lengthA++;
	    		a = a.next;
	    	}
	    	
	    	while(b != null){
	    		lengthB++;
	    		b = b.next;
	    	}
	    	
	    	a = headA;
	    	b = headB;
	    	int diff = lengthA - lengthB;
	    	if (diff > 0){
	    		while(diff > 0){
	    			a = a.next;
	    			diff--;
	    		}
	    	}else if (diff < 0) {
				while(diff < 0){
					b = b.next;
					diff++;
				}
			}
	    	
	    	while(a != null && b != null){
	    		if (a.val == b.val){
	    			return a;
	    		}else {
					a = a.next;
					b = b.next;
				}
	    	}
	    	
			return null;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNodeUtil.print(solution.getIntersectionNode(ListNodeUtil.toListNodes(new int[]{1,4,7}), ListNodeUtil.toListNodes(new int[]{2,3,4,7})));
		ListNodeUtil.print(solution.getIntersectionNode(ListNodeUtil.toListNodes(new int[]{43}), ListNodeUtil.toListNodes(new int[]{2,3,4,7})));
	}
}
