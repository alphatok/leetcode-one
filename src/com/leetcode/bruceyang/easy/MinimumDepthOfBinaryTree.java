package com.leetcode.bruceyang.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.bruceyang.domain.TreeNode;

public class MinimumDepthOfBinaryTree {
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
		
		// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	    public int minDepth(TreeNode root) {
	        if (null == root){
	        	return 0;
	        }
	        
	        int depthLeft = minDepth(root.left);
	        int depthRigth = minDepth(root.right);
	        if (depthLeft == 0 && depthRigth == 0){  // this is called leaf node
	        	return 1;
	        }
	        
	        if (depthLeft == 0){
	        	depthLeft = Integer.MAX_VALUE;
	        }
	        
	        if (depthRigth == 0){
	        	depthRigth = Integer.MAX_VALUE;
	        }
			
	        return Math.min(depthLeft, depthRigth)+1;
	    }
	}
	
	public static class Solution2 {
		
		public static class LevelTreeNode{
			public TreeNode node;
			public int level = 0;
			public LevelTreeNode(TreeNode node, int level) {
				super();
				this.node = node;
				this.level = level;
			}
		}
		// bfs
		 public int minDepth(TreeNode root) {
			 if (root == null){
				 return 0;
			 }
			 
			 Queue<LevelTreeNode> queue = new LinkedList<>();
			 queue.add(new LevelTreeNode(root, 1));
			 while(!queue.isEmpty()){
				 LevelTreeNode ltree = queue.remove();
				 if (ltree.node.left == null && ltree.node.right == null){
					 return ltree.level;
				 }
				 
				 if (ltree.node.left != null){
					 queue.add(new LevelTreeNode(ltree.node.left, ltree.level + 1));
				 }
				 
				 if (ltree.node.right != null){
					 queue.add(new LevelTreeNode(ltree.node.right, ltree.level + 1));
				 }
			 }
			 
			 return 0;
		 }
	}
	
	public static class Solution3 {
		
		// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	    public int minDepth(TreeNode root) {
	    	if (root == null){
				 return 0;
			 }
			 
			 Queue<TreeNode> queue = new LinkedList<>();
			 queue.add(root);
			 int depth = 1;
			 int currentLevelCount  = 1; // 控制是否换树高度
			 int nextLevelCount  = 0;
			 // http://www.blogjava.net/menglee/archive/2013/12/21/407856.html
			 while(!queue.isEmpty()){
				 TreeNode node = queue.remove();
				 currentLevelCount --;
				 if (node.left == null && node.right == null){
//					 return depth;
				 }
				 
				 if (node.left != null){
					 queue.add(node.left);
					 nextLevelCount++;
				 }
				 
				 if (node.right != null){
					 queue.add(node.right);
					 nextLevelCount++;
				 }
				 
				 System.out.println(node.val + ", nextLevelCount:"+ nextLevelCount + ", currentLevelCount:" + currentLevelCount);
				 if (currentLevelCount == 0){ // 换level
					 if (nextLevelCount != 0){// 后面还有节点（这个逻辑要放在后面）
						 depth++;
					 }
					 currentLevelCount = nextLevelCount ;
					 nextLevelCount = 0;
				 }
				 
			 }
			 
			 return depth;
	    }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
//		root.left.right.left = new TreeNode(10);
//		root.left.right.right = new TreeNode(11);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);
		
		// [1,2,3,4,5] 2
		System.out.println(new Solution().minDepth(root));
		System.out.println(new Solution2().minDepth(root));
		System.out.println(new Solution3().minDepth(root));
	}
}
