package com.leetcode.bruceyang.easy;

import java.util.Arrays;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.TreeNodeUtil;

public class InvertBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public static class Solution {
	    public TreeNode invertTree(TreeNode root) {
	        if (root == null){
	        	return null;
	        }
	        
	        if (root.left == null && root.right == null){
	        	return root;
	        }
	        
	        TreeNode leftInv = invertTree(root.left);
	        TreeNode rigthInv = invertTree(root.right);
	        root.left = rigthInv;
	        root.right = leftInv;
	        return root;
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode node = solution.invertTree(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,3})));
		TreeNodeUtil.printAsPaths(node);
	}
}
