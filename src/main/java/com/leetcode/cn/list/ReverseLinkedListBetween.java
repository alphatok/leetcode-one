package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class ReverseLinkedListBetween {
    public static class Solution {
        /**
         *
         * @param head ListNode类
         * @param m int整型
         * @param n int整型
         * @return ListNode类
         */
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(m == n || head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy;
            ListNode cur = head;
            // scan to m
            int curIndex = 1;
            for (; curIndex < m; curIndex++) {
                pre = pre.next;
                cur = cur.next;
            }

            // cur move to m+1
            curIndex++;
            ListNode hookNode = pre;
            pre = pre.next;
            cur = cur.next;

            while (curIndex <= n && cur != null){
                ListNode next = cur.next;

                // cut cur from list
                pre.next = cur.next;
                // insert cur after hookNode
                cur.next = hookNode.next;
                hookNode.next = cur;

                cur = next;
                curIndex++;
            }

            return dummy.next;
        }
    }
}
