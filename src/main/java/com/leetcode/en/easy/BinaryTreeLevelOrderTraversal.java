package com.leetcode.en.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.TreeNodeUtil;

public class BinaryTreeLevelOrderTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 * 
	 * 
	 * bfs recursively
	 */
	public static class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	    	List<List<Integer>> result = new ArrayList<List<Integer>>();
	    	if (root == null){
	    		return result;
	    	}
	    	
	    	List<TreeNode> levelNodes = new ArrayList<TreeNode>(20);
	    	levelNodes.add(root);
	    	levelOrder(levelNodes, result);
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
	
	public static class Solution2 {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>(20);
			if (root == null){
				return result;
			}
			
			List<TreeNode> levelNodes = new ArrayList<TreeNode>(20);
			levelNodes.add(root);
			while(!levelNodes.isEmpty()){
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
				levelNodes = nextLevelNodes;
			}
			return result;
		}
	}
	
	public static class Solution3 {
		/**dfs*/
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>(20);
			levelOrder(result, root, 0);
			return result;
		}

		private void levelOrder(List<List<Integer>> result, TreeNode root, int depth) {
			if (root == null){
				return;
			}
			
			List<Integer> levelResult = null;
			if (result.size() < depth + 1){
				levelResult = new ArrayList<Integer>(10);
				result.add(levelResult);
			}else {
				levelResult = result.get(depth);
			}
			levelResult.add(root.val);
			levelOrder(result, root.left, depth+1);
			levelOrder(result, root.right, depth+1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> result = new Solution3().levelOrder(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,3,4,5,6, null,8,9, null, null, 100})));
		System.out.println(result.size());
	}
}
