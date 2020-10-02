package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class ReverseLinkedListWithDummyHead {
    public static class Solution {
        /**
         * NC78
         *
         * @param head no dummy head
         * @return reverse list node 1->2->3   3->2->1
         */
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode exHead = new ListNode(-1);
            exHead.next = head;

            // s->1->2->3->nil
            // s(exHead)->1(head)->nil  2(next)->3->nil
            ListNode cur = head.next;
            head.next = null;
            while(cur != null){
                ListNode next = cur.next;

                exHead.next = cur;
                cur.next = head;

                head = cur;
                cur = next;
            }

            return exHead.next;
        }
    }
}
