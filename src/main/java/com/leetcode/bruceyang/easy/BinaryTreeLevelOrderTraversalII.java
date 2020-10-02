package com.leetcode.bruceyang.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.TreeNodeUtil;

public class BinaryTreeLevelOrderTraversalII {
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
	    public List<List<Integer>> levelOrderBottom(TreeNode root) {
	    	List<List<Integer>> result = new ArrayList<List<Integer>>();
	    	if (root == null){
	    		return result;
	    	}
	    	
	    	List<TreeNode> levelNodes = new ArrayList<TreeNode>(20);
	    	levelNodes.add(root);
	    	levelOrder(levelNodes, result);
	    	for (int i = 0, j = result.size() - 1; i < j; i++, j--) {
				List<Integer> a = result.get(i);
				List<Integer> b = result.get(j);
				result.set(i, b);
				result.set(j, a);
			}
	    	
	    	return result;
	    }
	    
	    private void levelOrder(List<TreeNode> levelNodes, List<List<Integer>> result) {
			if (levelNodes.isEmpty()){
				return;
			}
			
			List<TreeNode> nextLevelNodes = new ArrayList<TreeNode>(levelNodes.size() << 1);
			List<Integer> levelResult = new ArrayList<Integer>(levelNodes.size() << 1);
			for (TreeNode node : levelNodes) {
				levelResult.add(node.val);
				if (node.left != null){
					nextLevelNodes.add(node.left);
				}
				if (node.right != null){
					nextLevelNodes.add(node.right);
				}
			}
			result.add(levelResult);
			
			levelOrder(nextLevelNodes, result);
		}
	}
	
	
	public static void main(String[] args) {
		List<List<Integer>> result = new Solution().levelOrderBottom(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,3,4,5,6, null,8,9, null, null, 100})));
		System.out.println(result.size());
	}
}
