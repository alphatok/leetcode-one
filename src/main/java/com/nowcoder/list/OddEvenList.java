package com.nowcoder.list;

import com.alphatok.domain.ListNode;

public class OddEvenList {
    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param head ListNode类
         * @return ListNode类
         */
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null || head.next.next == null){
                return head;
            }

            // 1,2 --> 1,2
            // 1,2,3 --> 1,3,2
            // 1,2,3,4 --> 1,3,2,4
            // 1,2,3,4,5 --> 1,3,5,2,4
            // 1,2,3,4,5,6 --> 1,3,5,2,4,6
            ListNode vh = new ListNode(-1);
            vh.next = head;

            ListNode preOdd = head;
            ListNode preEven = head.next;
            ListNode curOdd = head.next.next;             // next odd(non null)
            while (curOdd != null){
                ListNode curEven = curOdd.next;             // even

                preEven.next = curEven;
                curOdd.next = preOdd.next;
                preOdd.next = curOdd;

                preEven = curEven;
                preOdd = curOdd;
                if (curEven != null){
                    curOdd = curEven.next;
                }else{
                    curOdd = null;
                }
            }

            return vh.next;
        }

    }

}
