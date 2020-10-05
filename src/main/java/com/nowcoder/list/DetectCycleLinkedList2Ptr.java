package com.nowcoder.list;

import com.alphatok.domain.ListNode;

public class DetectCycleLinkedList2Ptr {
    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            // x = (n-2m-1)L +z
            // https://www.jianshu.com/p/7608f44e1baf
            if (head == null || head.next == null) {
                return null;
            }

            ListNode interNode = findInterNode(head);
            if (interNode == null) {
                return null;
            }

            ListNode fast = interNode;
            ListNode slow = head;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }

        private ListNode findInterNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast){
                    return slow;
                }
            }

            return null;
        }
    }
}
