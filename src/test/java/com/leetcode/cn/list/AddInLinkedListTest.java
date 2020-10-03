package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddInLinkedListTest {

    @Test
    public void testAdd(){
        AddInLinkedList.Solution solution = new AddInLinkedList.Solution();

        {
            ListNode a = new ListNodeBuilder(new int[]{9, 3, 7}).getHead();
            ListNode b = new ListNodeBuilder(new int[]{1,1,1, 6, 3}).getHead();
            ListNode sum = new ListNodeBuilder(new int[]{1,2,1,0,0}).getHead();
            assertTrue(ListNodeUtil.equals(solution.addInList(a, b), sum));
        }

        {
            ListNode a = new ListNodeBuilder(new int[]{1,1,1, 9, 3, 7}).getHead();
            ListNode b = new ListNodeBuilder(new int[]{6, 3}).getHead();
            ListNode sum = new ListNodeBuilder(new int[]{1,1,2, 0,0,0}).getHead();
            assertTrue(ListNodeUtil.equals(solution.addInList(a, b), sum));
        }

        {
            ListNode a = new ListNodeBuilder(new int[]{9, 3, 7}).getHead();
            ListNode b = new ListNodeBuilder(new int[]{6, 3}).getHead();
            ListNode sum = new ListNodeBuilder(new int[]{1,0,0,0}).getHead();
            assertTrue(ListNodeUtil.equals(solution.addInList(a, b), sum));
        }

        {
            ListNode a = new ListNodeBuilder(new int[]{9}).getHead();
            ListNode b = new ListNodeBuilder(new int[]{6}).getHead();
            ListNode sum = new ListNodeBuilder(new int[]{1,5}).getHead();
            assertTrue(ListNodeUtil.equals(solution.addInList(a, b), sum));
        }

        {
            ListNode a = new ListNodeBuilder(new int[]{0,9}).getHead();
            ListNode b = new ListNodeBuilder(new int[]{6}).getHead();
            ListNode sum = new ListNodeBuilder(new int[]{1,5}).getHead();
            ListNode result = solution.addInList(a, b);
            assertTrue(ListNodeUtil.equals(result, sum));
        }

        {
            ListNode a = new ListNodeBuilder(new int[]{0,0,9}).getHead();
            ListNode b = new ListNodeBuilder(new int[]{6}).getHead();
            ListNode sum = new ListNodeBuilder(new int[]{1,5}).getHead();
            assertTrue(ListNodeUtil.equals(solution.addInList(a, b), sum));
        }
    }

    @Test
    public void testReverse(){
        AddInLinkedList.Solution solution = new AddInLinkedList.Solution();
        {
            ListNode reverse = solution.reverse(new ListNode(-1));
            assertTrue(ListNodeUtil.equals(new ListNode(-1), reverse));
        }

        {
            ListNode reverse = solution.reverse(new ListNodeBuilder(new int[]{1,2,3}).getHead());
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{3,2,1}).getHead(), reverse));
        }

        {
            ListNode reverse = solution.reverse(new ListNodeBuilder(new int[]{1,2,3,4}).getHead());
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{4,3,2,1}).getHead(), reverse));
        }
    }

    @Test
    public void testCarry(){
        AddInLinkedList.Solution solution = new AddInLinkedList.Solution();

        {
            ListNode carry = solution.carry(new ListNodeBuilder(new int[]{1}).getHead());
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{1}).getHead(), carry));
        }

        {
            ListNode carry = solution.carry(new ListNodeBuilder(new int[]{10}).getHead());
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{0, 1}).getHead(), carry));
        }

        {
            ListNode carry = solution.carry(new ListNodeBuilder(new int[]{10, 9, 10}).getHead());
            assertTrue(ListNodeUtil.equals(new ListNodeBuilder(new int[]{0, 0, 1, 1}).getHead(), carry));
        }
    }

}