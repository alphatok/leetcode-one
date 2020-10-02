package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class ReverseLinkedListRecursive {
    public static class Solution {
        /**
         * NC78
         *
         * @param head no dummy head
         * @return reverse list node 1->2->3   3->2->1
         */
        public ListNode ReverseList(ListNode head) {
            if (null == head || null == head.getNext())
                return head;
            ListNode revHead = ReverseList(head.getNext());
            head.getNext().setNext(head);
            head.setNext(null);
            return revHead;
        }
    }
}
