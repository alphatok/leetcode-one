package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class ReverseLinkedListKGroup {
    public static class Solution {
        /**
         *
         * @param head ListNode类
         * @param k int整型
         * @return ListNode类
         */
        public ListNode reverseKGroup(ListNode head, int k) {
            if (k == 1 || head == null || head.next == null) {
                return head;
            }

            int len = 0;
            ListNode tmp = head;
            while (tmp != null){
                tmp = tmp.next;
                len++;
            }

            // add dummyNode
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            int curIndex = 1;
            ListNode pre = dummyHead;
            ListNode cur = head;
            ListNode hookNode = dummyHead;
            int maxIndex = (len/k) * k;
            while (curIndex <= maxIndex && cur != null ){
                if (curIndex % k == 1) {
                    hookNode = pre;
                    pre = pre.next;
                    cur = cur.next;
                    curIndex++;
                }

                // cut cur from list
                ListNode next = cur.next;

                // insert cur to hookNode
                pre.next = cur.next;
                cur.next = hookNode.next;
                hookNode.next = cur;

                cur = next;
                curIndex++;
            }

            return dummyHead.next;
        }

    }
}
