package com.leetcode.en.easy;

import com.alphatok.domain.ListNode;
import com.alphatok.util.ListNodeUtil;

public class SwapNodesInPairs {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class Solution {
	    public ListNode swapPairs(ListNode head) {
	    	if (null == head || head.next == null){
	    		return head;
	    	}
	    	
	    	ListNode swapedHead = swapPairs(head.next.next);
	    	ListNode newHead = head.next;
	    	newHead.next = head;
	    	head.next = swapedHead;
	    	return newHead;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNodeUtil.print(solution.swapPairs(ListNodeUtil.toListNodes(new int[]{1,2,3,4})));
		ListNodeUtil.print(solution.swapPairs(ListNodeUtil.toListNodes(new int[]{})));
		ListNodeUtil.print(solution.swapPairs(ListNodeUtil.toListNodes(new int[]{1,2,3,4,5,6})));
	}
}
