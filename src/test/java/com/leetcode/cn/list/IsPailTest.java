package com.leetcode.cn.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsPailTest {

    @Test
    public void testIsPail(){
        IsPail.Solution solution = new IsPail.Solution();
        assertTrue(solution.isPail(new ListNode(1)));
        assertTrue(solution.isPail(ListNodeBuilder.create("1").getHead()));
        assertTrue(solution.isPail(ListNodeBuilder.create("1,2,1").getHead()));
        assertTrue(solution.isPail(ListNodeBuilder.create("1,2,2,1").getHead()));
        assertTrue(solution.isPail(ListNodeBuilder.create("1,2,3,2,1").getHead()));

        assertFalse(solution.isPail(null));
        assertFalse(solution.isPail(ListNodeBuilder.create("1,2,3").getHead()));
        assertFalse(solution.isPail(ListNodeBuilder.create("1,3,3,2,1").getHead()));
        assertFalse(solution.isPail(ListNodeBuilder.create("1,2,3,3,1").getHead()));
    }

}