package com.leetcode.bruceyang.easy;

import com.alphatok.domain.TreeNode;

public class PathSum {
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
	    public boolean hasPathSum(TreeNode root, int sum) {
	        return pathSum(root, 0, sum);
	    }
	    
	    public boolean pathSum(TreeNode root, int pathSum, int destSum){
	    	if (root == null){
	    		return false;
	    	}
	    	
	    	if (root.left  == null && root.right == null){
	    		return pathSum + root.val == destSum; 
	    	}
	    	
	    	
	    	return pathSum(root.left, pathSum + root.val, destSum) || pathSum(root.right, pathSum + root.val, destSum);
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);
		System.out.println(solution.hasPathSum(root, 0));
		System.out.println(solution.hasPathSum(root, 1));
		System.out.println(solution.hasPathSum(root, 15));
		System.out.println(solution.hasPathSum(root, 16));
		System.out.println(solution.hasPathSum(root, 10));
		System.out.println(solution.hasPathSum(root, 23));
		System.out.println(solution.hasPathSum(null, 0));
	}
}
