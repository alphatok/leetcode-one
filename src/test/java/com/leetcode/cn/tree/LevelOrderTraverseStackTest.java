package com.leetcode.cn.tree;

import com.alphatok.domain.TreeNode;
import com.alphatok.domain.TreeNodeLevelBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class LevelOrderTraverseStackTest {

    @Test
    public void testLevelOrders(){
        TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,5,6,7,8,9").build();
        LevelOrderTraverseStack.Solution solution = new LevelOrderTraverseStack.Solution();
        int[] result = solution.levelOrders(root);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, result);
    }

}