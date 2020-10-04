package com.leetcode.cn.tree;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.CollectionUtil;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * re
 */
public class ThreeOrdersTraverseRecursive {

    public static class Solution {
        /**
         *
         * @param root TreeNode类 the root of binary tree
         * @return int整型二维数组
         */
        public int[][] threeOrders (TreeNode root) {
            int[] pre = preOrderTraverse(root);
            int[] mid = midOrderTraverse(root);
            int[] post = postOrderTraverse(root);

            int[][] result = new int[3][pre.length];
            result[0] = pre;
            result[1] = mid;
            result[2] = post;

            return result;
        }

        public int[] preOrderTraverse(TreeNode root){
            if (root == null) {
                return new int[]{};
            }

            List<Integer> resultCollection = new ArrayList<>();
            preOrderTraverse(root, resultCollection);
            return CollectionUtil.convert(resultCollection);
        }

        private void preOrderTraverse(TreeNode node, List<Integer> resultCollection) {
            if (node == null) {
                return;
            }

            resultCollection.add(node.val);
            preOrderTraverse(node.left, resultCollection);
            preOrderTraverse(node.right, resultCollection);
        }


        public int[] midOrderTraverse(TreeNode root){
            if (root == null) {
                return new int[]{};
            }

            List<Integer> resultCollection = new ArrayList<>();
            midOrderTraverse(root, resultCollection);
            return CollectionUtil.convert(resultCollection);
        }

        private void midOrderTraverse(TreeNode node, List<Integer> resultCollection) {
            if (node == null) {
                return;
            }

            midOrderTraverse(node.left, resultCollection);
            resultCollection.add(node.val);
            midOrderTraverse(node.right, resultCollection);
        }


        public int[] postOrderTraverse(TreeNode root){
            if (root == null) {
                return new int[]{};
            }

            List<Integer> resultCollection = new ArrayList<>();
            postOrderTraverse(root, resultCollection);
            return CollectionUtil.convert(resultCollection);
        }

        private void postOrderTraverse(TreeNode node, List<Integer> resultCollection) {
            if (node == null) {
                return;
            }

            postOrderTraverse(node.left, resultCollection);
            postOrderTraverse(node.right, resultCollection);
            resultCollection.add(node.val);
        }
    }

}
