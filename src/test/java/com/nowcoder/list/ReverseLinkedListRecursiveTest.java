package com.nowcoder.list;

import com.alphatok.domain.ListNode;
import com.alphatok.domain.ListNodeBuilder;
import com.alphatok.util.ListNodeUtil;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ReverseLinkedListRecursiveTest extends TestCase {

    @Test
    public void testReverse(){
        ReverseLinkedListRecursive.Solution solution = new ReverseLinkedListRecursive.Solution();
        {
            ListNode head = new ListNodeBuilder(new int[]{1}).getHead();
            Assert.assertTrue(ListNodeUtil.equals(solution.ReverseList(head), new ListNode(1)));
        }

        {
            ListNode head = new ListNodeBuilder(new int[]{1,2,3,4}).getHead();
            ListNode reverseList = solution.ReverseList(head);
            Assert.assertTrue(ListNodeUtil.equals(reverseList, new ListNodeBuilder(new int[]{4, 3,2,1}).getHead()));
        }
    }
}