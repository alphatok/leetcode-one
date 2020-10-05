package com.nowcoder.list;

import com.alphatok.domain.ListNode;

public class ReverseLinkedListWithDummyHead2 {
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
            ListNode pre = head;
            ListNode cur = head.next;

            while (cur != null){
                ListNode next = cur.next;

                // cut cur from list
                pre.next = cur.next;
                // insert cur after exHead
                cur.next = exHead.next;
                exHead.next = cur;

//                pre = cur;
                cur = next;
            }

            return exHead.next;
        }
    }
}
