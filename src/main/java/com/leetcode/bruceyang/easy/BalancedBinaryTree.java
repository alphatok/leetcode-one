package com.leetcode.bruceyang.easy;

import java.util.Arrays;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.TreeNodeUtil;

public class BalancedBinaryTree {
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
	    public boolean isBalanced(TreeNode root) {
	    	return height(root) != -1;
	    }
	    
	    private int height(TreeNode node){
	    	if (node == null){
	    		return 0;
	    	}else {
				int heightLeft = height(node.left);
				if (heightLeft == -1){
					return -1;
				}
				int heightRigth = height(node.right);
				if (heightRigth == -1){
					return -1;
				}
				if (heightLeft - heightRigth > 1 || heightRigth - heightLeft > 1){
					return -1;
				}else {
					return (heightLeft > heightRigth ? heightLeft : heightRigth) + 1;
				}
			}
	    }
	}
	
	
	public static void main(String[] args) {
		System.out.println(new Solution().isBalanced(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{}))));
//		System.out.println(new Solution().isBalanced(TreeNodeUtil.toTree(Arrays.asList(new String[]{1,2}))));
//		System.out.println(new Solution().isBalanced(TreeNodeUtil.toTree(Arrays.asList(new String[]{1,2,3}))));
		System.out.println(new Solution().isBalanced(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,3,4,5,null, null,8,9}))));
	}
}
