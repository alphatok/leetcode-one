package com.leetcode.cn.tree;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.CollectionUtil;

import java.sql.Statement;
import java.util.*;

/**
 * NC45
 */
public class ThreeOrdersTraverseStack {

    public static class Solution {
        /**
         *
         * @param root TreeNode类 the root of binary tree
         * @return int整型二维数组
         */
        public int[][] threeOrders(TreeNode root) {
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
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            // root left right
            while (!stack.isEmpty()) {
                TreeNode p = stack.pop();
                resultCollection.add(p.val);

                if (p.right != null) {
                    // p下的right后被访问
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                }
            }

            return CollectionUtil.convert(resultCollection);
        }

        public int[] midOrderTraverse(TreeNode root){
            if (root == null) {
                return new int[]{};
            }

            List<Integer> resultCollection = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            // left root right
            while (!stack.isEmpty() || p != null) {
                while ( p != null){
                    stack.push(p);
                    p = p.left;
                }

                if (!stack.isEmpty()) {
                    p = stack.pop();
                    resultCollection.add(p.val);
                    p = p.right;
                }
            }

            return CollectionUtil.convert(resultCollection);
        }

        public int[] postOrderTraverse(TreeNode root){
            if (root == null) {
                return new int[]{};
            }

            List<Integer> resultCollection = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            // left right root
            TreeNode lastPrintNode = null;
            while (!stack.isEmpty() || (p != null && p != lastPrintNode)) {
                // 一路left到底
                while (p != null && p != lastPrintNode){
                    stack.push(p);
                    p = p.left;
                }

                if (!stack.isEmpty()) {
                    p = stack.peek();
                    TreeNode right = p.right;
                    // has right node
                    if (right != null) {
                        // 未访问，入队
                        if (lastPrintNode != right) {
                            p = right;
                        }else{
                            // 已访问，print p(mark)
                            stack.pop();
                            resultCollection.add(p.val);
                            lastPrintNode = p;
                        }
                    }else{
                        // no right node
                        // print p(mark)
                        stack.pop();
                        resultCollection.add(p.val);
                        lastPrintNode = p;
                    }
                }
            }

            return CollectionUtil.convert(resultCollection);
        }

        /**
         * 变量记录上次访问节点。如果左右子树 都已访问，则可以打印
         * @param root
         * @return
         */
        public int[] postOrderTraverse2(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }

            List<Integer> resultCollection = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            // left right root
            TreeNode p = null;
            TreeNode lastVisit = null;
            while (!stack.isEmpty()) {
                p = stack.peek();

                TreeNode left = p.left;
                TreeNode right = p.right;
                if (left != null && left != lastVisit && right != lastVisit) {
                    stack.push(left);
                }else if (right != null && right != lastVisit) {
                    stack.push(right);
                }else{
                    stack.pop();
                    resultCollection.add(p.val);
                    lastVisit = p;
                }
            }

            return CollectionUtil.convert(resultCollection);
        }

        /**
         * 变样的先序 再反转 LRD = (DRL)^T
         * variant from: https://blog.csdn.net/davidddl/article/details/75667092
         * root,right,left
         * @param root
         * @return
         */
        public int[] postOrderTraverse3(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }

            List<Integer> resultCollection = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode p = stack.pop();
                resultCollection.add(p.val);

                if (p.left != null) {
                    stack.push(p.left);
                }

                if (p.right != null) {
                    stack.push(p.right);
                }
            }

            Collections.reverse(resultCollection);
            return CollectionUtil.convert(resultCollection);
        }
    }

}
