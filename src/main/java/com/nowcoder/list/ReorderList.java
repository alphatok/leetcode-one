package com.nowcoder.list;

import com.alphatok.domain.ListNode;

public class ReorderList {
    public static class Solution {
        public void reorderList(ListNode head) {
            if (null == head || head.next == null) {
                return;
            }

            ListNode vHead = new ListNode(-1);
            vHead.next = head;

            // fast slow walk
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }

            // reverse right part
            ListNode right = slow.next;
            slow.next = null;
            ListNode reversed = reverse(right);

            // merge left and rigth
            // 1 2 3
            // 4 5
            ListNode p1 = head;
            ListNode p2 = reversed;
            while (p2 != null){
                ListNode nextp1 = p1.next;
                ListNode nextp2 = p2.next;

                p1.next = p2;
                p2.next = nextp1;

                p1 = nextp1;
                p2 = nextp2;
            }
        }

        private ListNode reverse(ListNode head){
            if (head == null || head.next == null) {
                return head;
            }

            ListNode vHead = new ListNode(-1);
            vHead.next = head;

            // s->1->2->3
            // s->1  2  3
            ListNode pre = head;
            ListNode cur = head.next;
            pre.next = null;
            while (cur != null){
                ListNode next = cur.next;

                cur.next = pre;
                vHead.next = cur;

                pre = cur;
                cur = next;
            }

            return pre;
        }
    }
}
