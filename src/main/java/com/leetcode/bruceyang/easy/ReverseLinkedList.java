package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.domain.ListNode;
import com.leetcode.bruceyang.util.ListNodeUtil;

public class ReverseLinkedList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class SolutionIter {
		/**
		 * iteratively
		 **/
	    public ListNode reverseList(ListNode head) {
	        if (null == head || head.next == null){
	        	return head;
	        }
	        
	        // save next element to tmp, then link
	        // draw link array and pointer
	        ListNode pre = head;
	        ListNode p = head.next;
	        pre.next = null;
	        ListNode nextTmp = null;
	        while( p != null ){
	        	nextTmp = p.next;
	        	p.next = pre;
	        	pre = p;
	        	p = nextTmp;
	        }
	        
	        return pre;
	    }
	}
	
	public static class SolutionRecur{
		/**
		 * iteratively
		 **/
	    public ListNode reverseList(ListNode head) {
	    	if (head == null || head.next == null){
	    		return head;
	    	}
	    	
	    	ListNode next = head.next;
	    	ListNode reversedHead = reverseList(next);
	    
	    	next.next = head;
	    	head.next = null;
	    	
	        return reversedHead;
	    }
	}
	
	public static void main(String[] args) {
		SolutionIter solutionIter = new SolutionIter();
		ListNodeUtil.print(solutionIter.reverseList(ListNodeUtil.toListNodes(new int[]{1, 2, 3, 4, 5})));
		ListNodeUtil.print(solutionIter.reverseList(ListNodeUtil.toListNodes(new int[]{1})));
		ListNodeUtil.print(solutionIter.reverseList(ListNodeUtil.toListNodes(new int[]{})));
		SolutionRecur solutionRecur= new SolutionRecur();
		System.out.println("----------------------------");
		ListNodeUtil.print(solutionRecur.reverseList(ListNodeUtil.toListNodes(new int[]{1, 2, 3, 4, 5})));
		ListNodeUtil.print(solutionRecur.reverseList(ListNodeUtil.toListNodes(new int[]{1})));
		ListNodeUtil.print(solutionRecur.reverseList(ListNodeUtil.toListNodes(new int[]{})));
	}
}
