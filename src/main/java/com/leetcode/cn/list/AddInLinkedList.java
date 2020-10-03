package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.util.ListNodeUtil;

public class AddInLinkedList {

    public static class Solution {
        /**
         *
         * @param head1 ListNode类
         * @param head2 ListNode类
         * @return ListNode类
         */
        public ListNode addInList(ListNode head1, ListNode head2) {
            head1 = trimPreZero(head1);
            head2 = trimPreZero(head2);
            int lenA = length(head1);
            int lenB = length(head2);

            ListNode resultHead;
            if (lenA > lenB) {
                int walkLen = lenA - lenB;
                resultHead = addTo(head2, walkLen, head1);
            }else{
                int walkLen = lenB - lenA;
                resultHead = addTo(head1, walkLen, head2);
            }

            resultHead = reverse(resultHead);
            // carry handle
            resultHead = carry(resultHead);
            // reverse
            resultHead = reverse(resultHead);


            ListNodeUtil.print(resultHead);
            return resultHead;
        }

        private ListNode trimPreZero(ListNode head) {
            while (head != null && head.val == 0) {
                head = head.next;
            }

            return head;
        }

        public ListNode carry(ListNode head) {
            ListNode tmp = head;

            boolean hasCarry = false;
            ListNode last = head;
            while (tmp != null){
                if (hasCarry){
                    tmp.val = tmp.val + 1;
                }

                if (tmp.val > 9) {
                    tmp.val = tmp.val - 10;
                    hasCarry = true;
                }else{
                    hasCarry = false;
                }

                last = tmp;
                tmp = tmp.next;
            }

            if (hasCarry){
                last.next = new ListNode(1);
            }

            return head;
        }

        public ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode vHead = new ListNode(-1);
            vHead.next = head;

            ListNode pre = head;
            ListNode cur = head.next;
            while (cur != null){
                ListNode next = cur.next;

                pre.next = cur.next;
                cur.next = vHead.next;
                vHead.next = cur;

                cur = next;
            }

            return vHead.next;
        }

        private ListNode addTo(ListNode shortList, int walkLen, ListNode longList) {
            ListNode result = longList;
            while (walkLen-- > 0) {
                longList = longList.next;
            }
            while (longList != null) {
                longList.val = longList.val + shortList.val;
                longList = longList.next;
                shortList = shortList.next;
            }

            return result;
        }

        private int length(ListNode node) {
            int len = 0;
            while (node != null){
                node = node.next;
                len++;
            }

            return len;
        }
    }
}
