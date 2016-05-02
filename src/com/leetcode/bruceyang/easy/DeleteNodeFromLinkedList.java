package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.domain.ListNode;
import com.leetcode.bruceyang.util.ListNodeUtil;

public class DeleteNodeFromLinkedList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class Solution {
	    public void deleteNode(ListNode node) {
	        if (node == null){
	        	return;
	        }
	        
	        node.val = node.next.val;
	        node.next = node.next.next;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode node = ListNodeUtil.toListNodes(new int[]{1,2,4,4});
		node = node.next;
		solution.deleteNode(node);
	}
}
