package com.leetcode.en.easy;

import java.util.Arrays;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.TreeNodeUtil;

public class LowestCommonAncestorOfBinarySearchTree {
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
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null || p == null || q == null){
	        	return null;
	        }
	        
	        int min = p.val > q.val ? q.val : p.val;
	        int max = p.val > q.val ? p.val : q.val;
	        if (root.val > max){
	        	return lowestCommonAncestor(root.left, p, q);
	        }else if (root.val < min) {
	        	return lowestCommonAncestor(root.right, p, q);
			}else {
				return root;
			}
	    }
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNodeUtil.toTree(Arrays.asList(new Integer[]{5,3,6,2,4,null,null,1}));
		TreeNode lcr = new Solution().lowestCommonAncestor(root, new TreeNode(1), new TreeNode(4));
		System.out.println(lcr.val);
		TreeNode lcr2 = new Solution().lowestCommonAncestor(root, new TreeNode(1), new TreeNode(6));
		System.out.println(lcr2.val);
		TreeNode lcr3 = new Solution().lowestCommonAncestor(root, new TreeNode(1), new TreeNode(2));
		System.out.println(lcr3.val);
	}
}
