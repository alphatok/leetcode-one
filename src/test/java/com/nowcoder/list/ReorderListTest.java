package com.nowcoder.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReorderListTest {

    @Test
    public void testReorderList(){
        ReorderList.Solution solution = new ReorderList.Solution();
        {
            ListNode input = ListNodeBuilder.create("10,20,30,40").getHead();
            solution.reorderList(input);
            ListNode expected = ListNodeBuilder.create("10,40,20,30").getHead();
            assertTrue(ListNodeUtil.equals(input, expected));
        }

        {
            ListNode input = ListNodeBuilder.create("10,20,30,40,50").getHead();
            solution.reorderList(input);
            ListNode expected = ListNodeBuilder.create("10,50,20,40,30").getHead();
            assertTrue(ListNodeUtil.equals(input, expected));
        }

        {
            ListNode input = ListNodeBuilder.create("10").getHead();
            solution.reorderList(input);
            ListNode expected = ListNodeBuilder.create("10").getHead();
            assertTrue(ListNodeUtil.equals(input, expected));
        }

        {
            ListNode input = ListNodeBuilder.create("10,20").getHead();
            solution.reorderList(input);
            ListNode expected = ListNodeBuilder.create("10,20").getHead();
            assertTrue(ListNodeUtil.equals(input, expected));
        }
    }
}