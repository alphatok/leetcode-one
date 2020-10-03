package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class IsPail {
    public static class Solution {
        /**
         *
         * @param head ListNode类 the head
         * @return bool布尔型
         */
        public boolean isPail (ListNode head) {
            if (head == null){
                return false;
            }

            if (head.next == null){
                return true;
            }

            // fast slow walk
            ListNode vHead = new ListNode(-1);
            vHead.next = head;
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            // reverse left
            ListNode reversed = reverse(slow.next);
            slow.next = null; // cut left & rigth

            // 奇数个的时候，忽略(fast结束就算结束)
            ListNode left = head;
            ListNode right = reversed;
            while (right != null){
                if (right.val != left.val){
                    return false;
                }

                right = right.next;
                left = left.next;
            }

            return true;
        }

        private ListNode reverse(ListNode head){
            ListNode vHead = new ListNode(-1);
            vHead.next = head;

            // s->1->2->3
            // s->1  2->3
            // s->2->1  3
            ListNode pre = head;
            ListNode cur = head.next;
            pre.next = null; // last
            while (cur != null){
                ListNode next = cur.next;
                cur.next = pre;
                vHead.next = cur;

                pre = cur;
                cur = next;
            }

            return vHead.next;
        }
    }
}
