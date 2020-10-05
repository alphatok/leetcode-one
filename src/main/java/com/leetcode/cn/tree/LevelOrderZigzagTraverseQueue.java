package com.leetcode.cn.tree;

import com.alphatok.domain.TreeNode;

import java.util.*;

public class LevelOrderZigzagTraverseQueue {
    public static class Solution {
        /**
         *
         * @param root TreeNode类
         * @return int整型ArrayList<ArrayList<>>
         */
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
            if (null == root){
                return new ArrayList<>();
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            ArrayList<ArrayList<Integer>> allRs = new ArrayList<>();
            boolean leftFirst = true;
            while (!queue.isEmpty()){
                Queue<TreeNode> nextLevelQueue = new LinkedList<TreeNode>();
                ArrayList<Integer> curLevelRs = new ArrayList<>();
                while (!queue.isEmpty()){
                    TreeNode node = queue.poll();
                    curLevelRs.add(node.val);

                    if (node.left != null){
                        nextLevelQueue.add((node.left));
                    }

                    if (node.right != null){
                        nextLevelQueue.add((node.right));
                    }
                }

                if (!leftFirst) {
                    Collections.reverse(curLevelRs);
                }
                allRs.add(curLevelRs);

                leftFirst = !leftFirst;
                if (!nextLevelQueue.isEmpty()){
                    queue.addAll(nextLevelQueue);
                }
            }

            return allRs;
        }
    }


}
