package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class OddEvenListTest {

    @Test
    public void testOddEven(){
        OddEvenList.Solution solution = new OddEvenList.Solution();
        {
            ListNode input = ListNodeBuilder.create("1").getHead();
            ListNode expected = ListNodeBuilder.create("1").getHead();
            solution.oddEvenList(input);
            assertTrue(ListNodeUtil.equals(expected, input));
        }

        {
            ListNode input = ListNodeBuilder.create("1,2").getHead();
            ListNode expected = ListNodeBuilder.create("1,2").getHead();
            solution.oddEvenList(input);
            assertTrue(ListNodeUtil.equals(expected, input));
        }


        {
            ListNode input = ListNodeBuilder.create("1,2,3").getHead();
            ListNode expected = ListNodeBuilder.create("1,3,2").getHead();
            solution.oddEvenList(input);
            assertTrue(ListNodeUtil.equals(expected, input));
        }

        {
            ListNode input = ListNodeBuilder.create("1,2,3,4").getHead();
            ListNode expected = ListNodeBuilder.create("1,3,2,4").getHead();
            solution.oddEvenList(input);
            assertTrue(ListNodeUtil.equals(expected, input));
        }

        {
            ListNode input = ListNodeBuilder.create("1,2,3,4,5,6,7").getHead();
            ListNode expected = ListNodeBuilder.create("1,3,5,7,2,4,6").getHead();
            ListNode result = solution.oddEvenList(input);
            ListNodeUtil.print(result);
            assertTrue(ListNodeUtil.equals(expected, input));
        }

        {
            ListNode input = ListNodeBuilder.create("1,2,3,4,5").getHead();
            ListNode expected = ListNodeBuilder.create("1,3,5,2,4").getHead();
            solution.oddEvenList(input);
            assertTrue(ListNodeUtil.equals(expected, input));
        }

        {
            ListNode input = ListNodeBuilder.create("1,2,3,4,5,6").getHead();
            ListNode expected = ListNodeBuilder.create("1,3,5,2,4,6").getHead();
            solution.oddEvenList(input);
            assertTrue(ListNodeUtil.equals(expected, input));
        }

    }

}