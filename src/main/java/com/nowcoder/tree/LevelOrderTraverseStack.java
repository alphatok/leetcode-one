package com.nowcoder.tree;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.CollectionUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverseStack {

    public static class Solution2 {
        public ArrayList<ArrayList<Integer>> levelOrders(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            Queue<TreeNode> preLevel = new LinkedList<>();
            preLevel.add(root);
            while (!preLevel.isEmpty()) {
                Queue<TreeNode> nextLevel = new LinkedList<>();
                ArrayList<Integer> levelResult = new ArrayList<>();
                while (!preLevel.isEmpty()) {
                    TreeNode p = preLevel.poll();

                    levelResult.add(p.val);
                    if (p.left != null) {
                        nextLevel.add(p.left);
                    }
                    if (p.right != null) {
                        nextLevel.add(p.right);
                    }
                }
                result.add(levelResult);
                preLevel = nextLevel;
            }

            return result;
        }
    }


    /**
     * in one array
     */
    public static class Solution {
        public int[] levelOrders(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }

            List<Integer> result = new LinkedList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                result.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                }

                if (p.right != null) {
                    queue.add(p.right);
                }
            }

            return CollectionUtil.convert(result);
        }
    }
}
