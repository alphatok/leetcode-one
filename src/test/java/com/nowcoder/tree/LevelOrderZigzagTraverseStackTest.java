package com.nowcoder.tree;

import com.alphatok.domain.TreeNode;
import com.alphatok.domain.TreeNodeLevelBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class LevelOrderZigzagTraverseStackTest {

    @Test
    public void test(){
        TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,5,6,7,8,9").build();
        LevelOrderZigzagTraverseStack.Solution solution = new LevelOrderZigzagTraverseStack.Solution();
        ArrayList<ArrayList<Integer>> lists = solution.zigzagLevelOrder(root);
        assertEquals("[[1], [3, 2], [4, 5, 6, 7], [9, 8]]", lists.toString());
    }

    @Test
    public void test2(){
        TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,5,6,7,8,9,#,#,1,1,#,#,#,#,99,8").build();
        LevelOrderZigzagTraverseStack.Solution solution = new LevelOrderZigzagTraverseStack.Solution();
        ArrayList<ArrayList<Integer>> lists = solution.zigzagLevelOrder(root);
        assertEquals("[[1], [3, 2], [4, 5, 6, 7], [1, 1, 9, 8], [99, 8]]", lists.toString());
    }

    @Test
    public void test3() throws IOException, InterruptedException {
        TreeNode root = TreeNodeLevelBuilder.create("1,2,3,4,#,#,5").build();
//        GraphUtil.paintAndOpen(root, false);
        LevelOrderZigzagTraverseStack.Solution solution = new LevelOrderZigzagTraverseStack.Solution();
        ArrayList<ArrayList<Integer>> lists = solution.zigzagLevelOrder(root);
        System.out.println(lists);
        assertEquals("[[1], [3, 2], [4, 5]]", lists.toString());
    }
}