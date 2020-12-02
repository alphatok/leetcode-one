package com.nowcoder.tree;

import com.alphatok.domain.TreeNode;
import com.alphatok.domain.TreeNodeLevelBuilder;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LevelOrderTraverseStackTest {

    @Test
    public void testLevelOrdersSolution1(){
        TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,5,6,7,8,9").build();
        LevelOrderTraverseStack.Solution solution = new LevelOrderTraverseStack.Solution();
        int[] result = solution.levelOrders(root);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, result);
    }

    @Test
    public void testLevelOrdersSolution2(){
        {
            TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,5,6,7,8,9").build();
            LevelOrderTraverseStack.Solution2 solution = new LevelOrderTraverseStack.Solution2();
            ArrayList<ArrayList<Integer>> levelOrders = solution.levelOrders(root);
            for (ArrayList<Integer> list : levelOrders) {
                System.out.println("list = " + list);
            }
        }
    }

}