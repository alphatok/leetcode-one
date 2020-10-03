package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindFirstCommonNodeTest {
    @Test
    public void testFindFirstCommonNode(){
        FindFirstCommonNode.Solution solution = new FindFirstCommonNode.Solution();
        {
            ListNode common = new ListNodeBuilder(new int[]{6,7}).getHead();
            ListNode a = new ListNodeBuilder(new int[]{1,2,3}).append(common).getHead();
            ListNode b = new ListNodeBuilder(new int[]{4,5}).append(common).getHead();
            ListNode commonNode = solution.FindFirstCommonNode(a, b);
            assertTrue(ListNodeUtil.equals(common, commonNode));
        }

        {
            ListNode common = new ListNodeBuilder(new int[]{6,7}).getHead();
            ListNode a = new ListNodeBuilder(new int[]{1}).append(common).getHead();
            ListNode b = new ListNodeBuilder(new int[]{4,5}).append(common).getHead();
            ListNode commonNode = solution.FindFirstCommonNode(a, b);
            assertTrue(ListNodeUtil.equals(common, commonNode));
        }

        {
            ListNode common = new ListNodeBuilder(new int[]{6,7}).getHead();
            ListNode a = new ListNodeBuilder(new int[]{1}).append(common).getHead();
            ListNode b = new ListNodeBuilder(new int[]{4,5}).append(common).getHead();
            ListNode commonNode = solution.FindFirstCommonNode(a, b);
            assertTrue(ListNodeUtil.equals(common, commonNode));
        }
    }

}