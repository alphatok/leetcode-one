package com.nowcoder.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import org.junit.Assert;
import org.junit.Test;

public class HasCycleLinkedList2PtrTest {

    @Test
    public void testHasCycle() {
        HasCycleLinkedList2Ptr.Solution solution =  new HasCycleLinkedList2Ptr.Solution();
        Assert.assertFalse(solution.hasCycle(null));
        Assert.assertFalse(solution.hasCycle(new ListNode(-1)));

        Assert.assertFalse(solution.hasCycle(new ListNodeBuilder(new int[]{1,1,1,1,1}).getHead()));


        {
            ListNode head = new ListNode(-1);
            head.next = head;
            Assert.assertTrue(solution.hasCycle(head));
        }

        {
            ListNode head = new ListNode(-1);
            ListNode p1 = new ListNode(1);
            ListNode p2 = new ListNode(2);
            head.next = p1;
            p1.next = p2;
            p2.next = head;
            Assert.assertTrue(solution.hasCycle(head));
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
            Assert.assertTrue(solution.hasCycle(head));
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
            Assert.assertTrue(solution.hasCycle(head));
        }
    }
}