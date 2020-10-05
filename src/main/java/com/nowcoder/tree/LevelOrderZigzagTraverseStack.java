package com.nowcoder.tree;

import com.alphatok.domain.TreeNode;

import java.util.*;
public class LevelOrderZigzagTraverseStack {
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

            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);

            ArrayList<ArrayList<Integer>> allRs = new ArrayList<>();
            boolean leftFirst = true;
            while (!stack.isEmpty()){
                Stack<TreeNode> nextLevelStack = new Stack<TreeNode>();


                ArrayList<Integer> curLevelRs = new ArrayList<>();
                while (!stack.isEmpty()){
                    TreeNode node = stack.pop();
                    curLevelRs.add(node.val);

                    if (node.left != null){
                        nextLevelStack.push((node.left));
                    }

                    if (node.right != null){
                        nextLevelStack.push((node.right));
                    }
                }

                if (!leftFirst) {
                    Collections.reverse(curLevelRs);
                }
                allRs.add(curLevelRs);

                leftFirst = !leftFirst;
                while (!nextLevelStack.isEmpty()){
                    stack.push(nextLevelStack.pop());
                }
            }

            return allRs;
        }
    }


}
