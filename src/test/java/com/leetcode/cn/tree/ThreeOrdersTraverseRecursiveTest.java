package com.leetcode.cn.tree;

import com.alphatok.domain.TreeNode;
import com.alphatok.domain.TreeNodeLevelBuilder;
import com.alphatok.util.CollectionUtil;
import com.alphatok.util.GraphUtil;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ThreeOrdersTraverseRecursiveTest {
    @Test
    public void testPreOrderTraverse() throws IOException, InterruptedException {
        TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,5,6,7,8,9").build();
        ThreeOrdersTraverseRecursive.Solution solution = new ThreeOrdersTraverseRecursive.Solution();
        int[] result = solution.preOrderTraverse(root);
        assertArrayEquals(new int[]{1,2,4,8,9,5,3,6,7}, result);
    }

    @Test
    public void testMidOrderTraverse() throws IOException, InterruptedException {
        TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,5,6,7,8,9").build();
        ThreeOrdersTraverseRecursive.Solution solution = new ThreeOrdersTraverseRecursive.Solution();
        int[] result = solution.midOrderTraverse(root);
        System.out.println("result = " + CollectionUtil.join(result));
        assertArrayEquals(new int[]{8,4,9,2,5,1,6,3,7}, result);
    }

    @Test
    public void testPostOrderTraverse() throws IOException, InterruptedException {
        TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,5,6,7,8,9").build();
        ThreeOrdersTraverseRecursive.Solution solution = new ThreeOrdersTraverseRecursive.Solution();
        int[] result = solution.postOrderTraverse(root);
        System.out.println("result = " + CollectionUtil.join(result));
        assertArrayEquals(new int[]{8,9,4,5,2,6,7,3,1}, result);
    }

}