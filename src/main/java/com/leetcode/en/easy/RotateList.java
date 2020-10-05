package com.leetcode.en.easy;

import com.alphatok.domain.ListNode;
import com.alphatok.util.ListNodeUtil;

public class RotateList {
	public static class Solution{

	    public ListNode rotateRight(ListNode head, int k) {
	    	int size = sizeOfListNode(head);
	    	if (size == 0){
	    		return head;
	    	}
	    	int step = k % size;
	        if (step == 0){
	        	return head;
	        }
	        
	        ListNode newHead = null;
	        ListNode tmp = head, newHeadPre = head;
	        int count = size - step;
	        // find the preElement of the new head
	        while (tmp != null) {
	        	newHeadPre = tmp;
	        	tmp = tmp.next;
	        	count--;
	        	if (count == 0){ 
	        		newHead = tmp;
	        		break;
	        	}else {
					newHead = tmp;
					
				}
			}
	        
	        ListNode tail = newHead;
	        while(tail.next != null){
	        	tail = tail.next;
	        }
	        
	        tail.next = head;
	        newHeadPre.next = null;
	        return newHead;
	    }
	    
	    private int sizeOfListNode(ListNode head){
	    	int size = 0;
	    	while(head != null){
	    		if (head.next == null){
	    			size++;
	    			break;
	    		}else {
	    			size++;
					head = head.next;
				}
	    	}
	    	
	    	return size;
	    }

	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = ListNodeUtil.toListNodes(new int[]{1, 2, 3, 3, 2, 1});
		ListNodeUtil.print(head); 
		ListNodeUtil.print(solution.rotateRight(head, 3));
	}
}
