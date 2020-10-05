package com.nowcoder.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RemoveNthFromEndTest {

    @Test
    public void testRemoveNthFromEnd(){
        RemoveNthFromEnd.Solution solution = new RemoveNthFromEnd.Solution();
        {
            assertTrue(ListNodeUtil.equals(solution.removeNthFromEnd(new ListNode(1), 1), null));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2}).getHead();
            ListNode result = new ListNodeBuilder(new int[]{2}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeNthFromEnd(head, 2), result));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4,5}).getHead();
            ListNode result = new ListNodeBuilder(new int[]{1,2,3,4}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeNthFromEnd(head, 1), result));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4,5}).getHead();
            ListNode result = new ListNodeBuilder(new int[]{1,2,3,5}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeNthFromEnd(head, 2), result));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4,5}).getHead();
            ListNode result = new ListNodeBuilder(new int[]{2,3,4,5}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeNthFromEnd(head, 5), result));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4,5}).getHead();
            ListNode result = new ListNodeBuilder(new int[]{1,2,4,5}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeNthFromEnd(head, 3), result));
        }
    }
}