package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;

public class FindFirstCommonNode {
    public  static class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            // x+L
            // y+L
            int len1 = length(pHead1);
            int len2 = length(pHead2);

            if (len1 > len2){
                int walkLen = len1 - len2;
                while (walkLen > 0){
                    pHead1 = pHead1.next;
                    walkLen--;
                }
            }else if (len2 > len1){
                int walkLen = len2 - len1;
                while (walkLen > 0){
                    pHead2 = pHead2.next;
                    walkLen--;
                }
            }

            while (pHead1 != null && pHead2 != null){
                if (pHead1 != pHead2){
                    pHead1 = pHead1.next;
                    pHead2 = pHead2.next;
                }else{
                    return pHead1;
                }
            }

            return null;
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
