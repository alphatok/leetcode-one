package com.nowcoder.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import org.junit.Assert;
import org.junit.Test;

public class DetectCycleLinkedList2PtrTest {

    @Test
    public void testHasCycle() {
        DetectCycleLinkedList2Ptr.Solution solution =  new DetectCycleLinkedList2Ptr.Solution();
        Assert.assertNull(solution.detectCycle(null));
        Assert.assertNull(solution.detectCycle(new ListNode(-1)));

        ListNode head1 = new ListNodeBuilder(new int[]{1, 1, 1, 1, 1}).getHead();
        Assert.assertNull(solution.detectCycle(head1));


        {
            ListNode head = new ListNode(-1);
            head.next = head;
            Assert.assertEquals(solution.detectCycle(head), head);
        }

        {
            ListNode head = new ListNode(-1);
            ListNode p1 = new ListNode(1);
            ListNode p2 = new ListNode(2);
            head.next = p1;
            p1.next = p2;
            p2.next = head;
            Assert.assertEquals(solution.detectCycle(head), head);
        }

        {
            ListNode head = new ListNode(-1);
            ListNode p1 = new ListNode(1);
            ListNode p2 = new ListNode(2);
            ListNode p3 = new ListNode(3);
            head.next = p1;
            p1.next = p2;
            p2.next = p3;
            p3.next = head;
            Assert.assertEquals(solution.detectCycle(head), head);
        }

        {
            ListNode head = new ListNode(-1);
            ListNode p1 = new ListNode(1);
            ListNode p2 = new ListNode(2);
            ListNode p3 = new ListNode(3);
            ListNode p4 = new ListNode(4);
            head.next = p1;
            p1.next = p2;
            p2.next = p3;
            p3.next = p4;
            p4.next = p2;
            Assert.assertEquals(solution.detectCycle(head), p2);
        }
    }
}