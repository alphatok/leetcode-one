package com.nowcoder.list;

import com.alphatok.domain.ListNode;

public class RemoveAllAfterNthFromEnd {

    public static class Solution {
        /**
         * 删除倒数第N及其以后的元素
         *
         * @param head ListNode类
         * @param n int整型
         * @return ListNode类
         */
        public ListNode removeAllAfterNthFromEnd(ListNode head, int n) {
            if (null == head ){
                return null;
            }

            int len = length(head);
            ListNode vHead = new ListNode(-1);
            vHead.next = head;

            int dstIdx = len - n + 1;
            ListNode pre = vHead;
            ListNode cur = head;
            int i = 1;
            while (i < dstIdx){
                pre = pre.next;
                cur = cur.next;
                i++;
            }

            pre.next = null;
            return vHead.next;
        }

        public int length(ListNode head){
            int len = 0;
            while (head != null){
                len++;
                head = head.next;
            }
            return len;
        }
    }

}
