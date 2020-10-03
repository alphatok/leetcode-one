package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTwoLinkedListsTest {

    @Test
    public void testMerge(){
        MergeTwoLinkedLists.Solution solution = new MergeTwoLinkedLists.Solution();
        {
            ListNode merged = solution.mergeTwoLists(null, null);
            assertTrue(ListNodeUtil.equals(null, merged));
        }

        {
            ListNode merged = solution.mergeTwoLists(new ListNode(1), null);
            assertTrue(ListNodeUtil.equals(new ListNode(1), merged));
        }

        {
            ListNode merged = solution.mergeTwoLists(null, new ListNode(1));
            assertTrue(ListNodeUtil.equals(new ListNode(1), merged));
        }

        {
            ListNode merged = solution.mergeTwoLists(new ListNode(1), new ListNode(1));
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{1,1}).getHead(), merged));
        }

        {
            ListNode a = new ListNodeBuilder(new int[]{1, 1, 4, 6, 7}).getHead();
            ListNode merged = solution.mergeTwoLists(a, new ListNode(1));
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{1,1,1,4,6,7}).getHead(), merged));
        }

        {
            ListNode a = new ListNodeBuilder(new int[]{1}).getHead();
            ListNode b = new ListNodeBuilder(new int[]{1, 1, 4, 6, 7}).getHead();
            ListNode merged = solution.mergeTwoLists(a, b);
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{1,1,1,4,6,7}).getHead(), merged));
        }

        {
            ListNode a = new ListNodeBuilder(new int[]{3,5}).getHead();
            ListNode b = new ListNodeBuilder(new int[]{1, 1, 4, 6, 7}).getHead();
            ListNode merged = solution.mergeTwoLists(a, b);
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{1,1,3,4,5,6,7}).getHead(), merged));
        }

        {
            ListNode b = new ListNodeBuilder(new int[]{3,5}).getHead();
            ListNode a = new ListNodeBuilder(new int[]{1, 1, 4, 6, 7}).getHead();
            ListNode merged = solution.mergeTwoLists(a, b);
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{1,1,3,4,5,6,7}).getHead(), merged));
        }
    }

}