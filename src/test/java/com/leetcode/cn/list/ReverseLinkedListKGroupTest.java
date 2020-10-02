package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListKGroupTest {
    @Test
    public void testReverseBetween(){
        ReverseLinkedListKGroup.Solution solution = new ReverseLinkedListKGroup.Solution();
        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3,4,5});
            ListNode reverseBetween = solution.reverseKGroup(builder.getHead(), 2);
            ListNodeUtil.print(reverseBetween);
            Assert.assertTrue(ListNodeUtil.equals(
                    reverseBetween, new ListNodeBuilder(new int[]{2,1,4,3,5}).getHead()));
        }

        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3,4,5});
            ListNode reverseBetween = solution.reverseKGroup(builder.getHead(), 5);
            ListNodeUtil.print(reverseBetween);
            Assert.assertTrue(ListNodeUtil.equals(
                    reverseBetween, new ListNodeBuilder(new int[]{5,4,3,2,1}).getHead()));
        }

        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3,4,5});
            ListNode reverseBetween = solution.reverseKGroup(builder.getHead(), 1);
            ListNodeUtil.print(reverseBetween);
            Assert.assertTrue(ListNodeUtil.equals(
                    reverseBetween, new ListNodeBuilder(new int[]{1,2,3,4,5}).getHead()));
        }

        {
            ListNodeBuilder builder = new ListNodeBuilder(new int[]{1,2,3,4,5,6});
            ListNode reverseBetween = solution.reverseKGroup(builder.getHead(), 3);
            ListNodeUtil.print(reverseBetween);
            Assert.assertTrue(ListNodeUtil.equals(
                    reverseBetween, new ListNodeBuilder(new int[]{3,2,1,6,5,4}).getHead()));
        }
    }

}