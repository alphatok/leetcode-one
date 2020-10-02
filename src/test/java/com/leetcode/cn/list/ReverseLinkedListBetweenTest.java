package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListBetweenTest {
    @Test
    public void testReverseBetween(){
        ReverseLinkedListBetween.Solution solution = new ReverseLinkedListBetween.Solution();
        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1});
            Assert.assertTrue(ListNodeUtil.equals(
                    solution.reverseBetween(builder.getHead(), 1,1),
                    new ListNodeBuilder(new int[]{1}).getHead()));
        }

        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3});
            Assert.assertTrue(ListNodeUtil.equals(
                    solution.reverseBetween(builder.getHead(), 1,3),
                    new ListNodeBuilder(new int[]{3,2,1}).getHead()));
        }

        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3});
            Assert.assertTrue(ListNodeUtil.equals(
                    solution.reverseBetween(builder.getHead(), 1,2),
                    new ListNodeBuilder(new int[]{2,1,3}).getHead()));
        }

        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3});
            Assert.assertTrue(ListNodeUtil.equals(
                    solution.reverseBetween(builder.getHead(), 2, 3),
                    new ListNodeBuilder(new int[]{1,3,2}).getHead()));
        }

        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3,4,5});
            ListNode reverseBetween = solution.reverseBetween(builder.getHead(), 2, 4);
            ListNodeUtil.print(reverseBetween);
            Assert.assertTrue(ListNodeUtil.equals(
                    reverseBetween, new ListNodeBuilder(new int[]{1,4,3,2,5}).getHead()));
        }

        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3,4,5});
            ListNode reverseBetween = solution.reverseBetween(builder.getHead(), 1, 5);
            ListNodeUtil.print(reverseBetween);
            Assert.assertTrue(ListNodeUtil.equals(
                    reverseBetween, new ListNodeBuilder(new int[]{5,4,3,2,1}).getHead()));
        }
    }

}