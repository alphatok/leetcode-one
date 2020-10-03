package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class RemoveNthFromEnd2Ptr {

    public static class Solution {
        /**
         * 删除倒数第N个元素
         *
         * @param head ListNode类
         * @param n int整型
         * @return ListNode类
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (null == head ){
                return null;
            }

            ListNode vHead = new ListNode(-1);
            vHead.next = head;

            ListNode pre = vHead;
            ListNode slow = head;

            ListNode fast = head;
            int fastCount = 1;
            while (fastCount <= n){
                fast = fast.next;
                fastCount++;
            }

            while (fast != null){
                fast = fast.next;
                slow = slow.next;
                pre = pre.next;
            }

            pre.next = slow.next;

            return vHead.next;
        }
    }

}
