package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class MergeTwoLinkedLists {

    public static class Solution {
        /**
         *
         * @param l1 ListNode类
         * @param l2 ListNode类
         * @return ListNode类
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode vHead = new ListNode(-1);
            ListNode ptr = vHead;

            while (l1 != null && l2 != null){
                if ( l1.val < l2.val ){
                    ptr.next = l1;
                    l1 = l1.next;
                    ptr = ptr.next;
                    ptr.next = null;
                }else{
                    ptr.next = l2;
                    l2 = l2.next;
                    ptr = ptr.next;
                    ptr.next = null;
                }
            }

            // remain of l1
            while (l1 != null){
                ptr.next = l1;
                l1 = l1.next;
                ptr = ptr.next;
                ptr.next = null;
            }
            // remain of l2
            while (l2 != null){
                ptr.next = l2;
                l2 = l2.next;
                ptr = ptr.next;
                ptr.next = null;
            }

            return vHead.next;
        }

    }

}
