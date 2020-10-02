package com.algo.list;

import com.algo.util.MyLinkedListUtil;

public class ReverseKGroup {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public MyListNode reverseKGroup (MyListNode head, int k) {
        if ( 1 == k || head == null){
            return head;
        }

        int total = countNode(head);

        // add sentile node
        MyListNode sentile = new MyListNode(-1);
        sentile.next = head;

        int roundCount = total / k;
        boolean hasRemainNode = (total % k) != 0; //

        MyListNode nextRoundSentile = sentile;
        for (int i = 1; i <= roundCount; i++){
            // save next round Sentile
            MyListNode roundSentile = nextRoundSentile;
            nextRoundSentile = roundSentile.next;

            int switchCount = 0;
            MyListNode pre = roundSentile.next;
            MyListNode p = pre.next;
            if (!hasRemainNode && i == roundCount){
                pre.next = null;
            }

            while (switchCount < k-1 && p != null){
                MyListNode nxt = p.next;
                roundSentile.next = p;
                p.next = pre;

                pre = p;
                p = nxt;
                switchCount++;
            }
        }

        return sentile.next;
    }

    public int countNode(MyListNode head){
        int total = 0;
        while (head != null){
            total++;
            head = head.next;
        }

        return total;
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        MyListNode listNode = MyLinkedListUtil.toLinkedList(new int[]{1,2,3}).getFirst();
        reverseKGroup.reverseKGroup(listNode, 3);
    }
}
