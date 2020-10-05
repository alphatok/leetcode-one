package com.nowcoder.list;

import com.alphatok.domain.ListNode;

import java.util.Stack;

public class ReverseLinkedListStack {
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

            Stack<ListNode> stack = new Stack<>();
            while (head != null){
                stack.push(head);
                head = head.next;
            }

            ListNode newHead = stack.pop();
            ListNode last = newHead;
            while (!stack.isEmpty()) {
                ListNode tmp = stack.pop();
                last.next = tmp;
                last = tmp;
            }
            last.next = null;

            return newHead;
        }
    }
}
