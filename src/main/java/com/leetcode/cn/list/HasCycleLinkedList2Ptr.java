package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class HasCycleLinkedList2Ptr {
    public static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && slow != null){
                slow = slow.next;
                fast = fast.next;
                if (fast != null){
                    fast = fast.next;
                }else{
                    break;
                }

                if (fast == slow){
                    return true;
                }
            }

            return false;
        }
    }
}
