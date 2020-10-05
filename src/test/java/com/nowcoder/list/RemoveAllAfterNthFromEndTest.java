package com.nowcoder.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveAllAfterNthFromEndTest {

    @Test
    public void testRemoveAllAfterNthFromEnd(){
        RemoveAllAfterNthFromEnd.Solution solution = new RemoveAllAfterNthFromEnd.Solution();
        {
            assertTrue(ListNodeUtil.equals(solution.removeAllAfterNthFromEnd(new ListNode(1), 1), null));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeAllAfterNthFromEnd(head, 2), null));
        }


        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4,5}).getHead();
            ListNode result = new ListNodeBuilder(new int[]{1,2,3,4}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeAllAfterNthFromEnd(head, 1), result));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4,5}).getHead();
            ListNode result = new ListNodeBuilder(new int[]{1,2,3}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeAllAfterNthFromEnd(head, 2), result));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4,5}).getHead();
            assertTrue(ListNodeUtil.equals(solution.removeAllAfterNthFromEnd(head, 5), null));
        }
    }
}