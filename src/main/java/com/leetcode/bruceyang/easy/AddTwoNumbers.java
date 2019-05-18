package com.leetcode.bruceyang.easy;

import com.leetcode.bruceyang.domain.ListNode;
import com.leetcode.bruceyang.util.ListNodeUtil;

public class AddTwoNumbers {


	/**
	 *  1 2 3 4 5
	 *  4 5 5 8 5 9 5
	 **/
	public static class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if(null == l1){
				return l2;
			}
			
			if(null == l2){
				return l1;
			}
			
			// part 1����list����ֵ�Ĳ���
			ListNode result = l2;
			boolean leek = false;  						// last calc result >= 10 
			while(null != l1 && null != l2){
				l2.val = l1.val + l2.val + (leek?1:0);
				leek = l2.val >= 10;
				l2.val = l2.val % 10;
				if (l2.next == null || l1.next == null){
					break;
				}else {
					l2 = l2.next;
					l1 = l1.next;
				}
			}
			
			// part 2 
			if (null == l2.next && null == l1.next){
				// ����list�ȳ�
				if (leek){
					l2.next = new ListNode(1);
					return result;
				}
			}else if (null == l2.next && null != l1.next) {
				// l1�ϳ�
				l2.next = l1.next; // l2ָ��l1
				l2 = l1.next;  // ����һλ
			}else if (null != l2.next && null == l1.next) {
				// l2�ϳ�
				l2 = l2.next;  // ����һλ
			}
			
			// part 3 �ϳ�list��λ����
			while(l2 != null){
				l2.val = l2.val +  (leek?1:0);
				leek = l2.val >= 10;
				l2.val = l2.val % 10;
				if(l2.next == null){
					break;
				}else {
					l2 = l2.next;
				}
			}
			
			// part 4 ���Ľ�λ
			if (leek){
				l2.next = new ListNode(1);
			}
			
			return result;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int arr1[] = { 9, 8 };
		int arr2[] = { 1 };
		
		ListNode l1 = ListNodeUtil.toListNodes(arr1);
		ListNode l2 = ListNodeUtil.toListNodes(arr2);
		ListNodeUtil.print(l1);
		ListNodeUtil.print(l2);
		ListNodeUtil.print(solution.addTwoNumbers(l1, l2));

		int arr3[] = { 1, 2, 3, 4, 7 };
		int arr4[] = { 1, 2, 8 };
		ListNodeUtil.print(solution.addTwoNumbers(ListNodeUtil.toListNodes(arr3), ListNodeUtil.toListNodes(arr4)));

		int arr5[] = { 1, 2, 9 };
		int arr6[] = { 3, 2, 3, 9, 9 };
		ListNode l5 = ListNodeUtil.toListNodes(arr5);
		ListNode l6 = ListNodeUtil.toListNodes(arr6);
		ListNodeUtil.print(solution.addTwoNumbers(l5, l6));

		int arr7[] = { 9 };
		int arr8[] = { 12 };
		ListNodeUtil.print(solution.addTwoNumbers(ListNodeUtil.toListNodes(arr7), ListNodeUtil.toListNodes(arr8)));
	}
}
