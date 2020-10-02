package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListWithDummyHead2Test extends TestCase {

    @Test
    public void testReverse(){
        ReverseLinkedListWithDummyHead2.Solution solution = new ReverseLinkedListWithDummyHead2.Solution();
        {
            ListNode head = new ListNodeBuilder(new int[]{1}).getHead();
            Assert.assertTrue(ListNodeUtil.equals(solution.ReverseList(head), new ListNode(1)));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3}).getHead();
            ListNode reverseList = solution.ReverseList(head);
            ListNodeUtil.print(reverseList);
            Assert.assertTrue(ListNodeUtil.equals(reverseList, new ListNodeBuilder(new int[]{3,2,1}).getHead()));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4,5,6}).getHead();
            ListNode reverseList = solution.ReverseList(head);
            ListNodeUtil.print(reverseList);
            Assert.assertTrue(ListNodeUtil.equals(reverseList, new ListNodeBuilder(new int[]{6,5,4,3,2,1}).getHead()));
        }
    }
}