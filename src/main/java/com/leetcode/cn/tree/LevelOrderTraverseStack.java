package com.leetcode.cn.tree;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.CollectionUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraverseStack {
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
