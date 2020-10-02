package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class ReverseLinkedListWithoutDummyHead {
    public static class Solution {
        /**
         * NC78
         *
         * @param head no dummy head
         * @return reverse list node 1->2->3   3->2->1
         */
        public ListNode ReverseList(ListNode head) {
            ListNode p = head;

            ListNode prev = null;
            while (p != null){
                ListNode next = p.next;
                p.next = prev;

                prev = p;
                p = next;
            }

            return prev;
        }
    }
}
