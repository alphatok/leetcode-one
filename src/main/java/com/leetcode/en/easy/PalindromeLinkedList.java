package com.leetcode.en.easy;

import com.alphatok.domain.ListNode;
import com.alphatok.util.ListNodeUtil;

public class PalindromeLinkedList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class Solution {
	    public boolean isPalindrome(ListNode head) {
	    	ListNode middle = head;
	    	ListNode tail = head;
	    	while (tail != null) {
	    		middle = middle.next;
	    		tail = tail.next;
	    		if (tail == null){
	    			break;
	    		}else {
					tail = tail.next;
				}
			}
	    	
//	    	NodeUtil.print(head);
//	    	NodeUtil.print(middle);
	    	ListNode reversedMiddle = reverseList(middle);
//	    	NodeUtil.print(reversedMiddle);
	    	
	    	ListNode p = reversedMiddle;
	    	ListNode q = head;
	    	while (p != null && q != null && q.val == p.val) {
	    		q = q.next;
	    		p = p.next;
			}
	    	
	    	if (p == null ){
	    		return true;
	    	}else {
				return false;
			}
	    }
	    
	    private ListNode reverseList(ListNode head) {
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
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{})));
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{1, 2, 1})));
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{1, 2, 4})));
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{1, 2, 2, 1})));
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{1, 2, 2, 5})));
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{1, 2, 3, 2, 1})));
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{1, 2, 3, 8, 1})));
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{1, 2, 3, 4, 3, 2, 1})));
		System.out.println(solution.isPalindrome(ListNodeUtil.toListNodes(new int[]{1, 2, 3, 4, 6, 2, 1})));
	}
}
