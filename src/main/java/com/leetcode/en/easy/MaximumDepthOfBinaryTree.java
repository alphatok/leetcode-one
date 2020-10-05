package com.leetcode.en.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.TreeNodeUtil;

public class MaximumDepthOfBinaryTree {
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
	    public int maxDepth(TreeNode root) {// better
	        if (root == null){
	        	return 0;
	        }
	        
	        if (root.left == null && root.right == null){
	        	return 1;
	        }
	        
	        int leftDepth = maxDepth(root.left);
	        int rightDepth = maxDepth(root.right);
	        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
	    }
	}
	public static class Solution2 {
		public int maxDepth(TreeNode root) {
			if (root == null){
				return 0;
			}
			
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int count = 1;
			int currentLevelCount = 1;
			int nextLevelCount = 0;
			while(!queue.isEmpty()){
				TreeNode node = queue.poll();
				currentLevelCount--;
				
				if (node.left != null){
					queue.add(node.left);
					nextLevelCount++;
				}
				if (node.right != null){
					queue.add(node.right);
					nextLevelCount++;
				}
				
				if (currentLevelCount == 0){
					if (nextLevelCount > 0){
						currentLevelCount = nextLevelCount;
						nextLevelCount = 0;
						count++;
					}
				}
			}
			
			return count;
		}
	}
	
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(solution.maxDepth(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}))));;
		System.out.println(solution.maxDepth(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1}))));;
		System.out.println(solution.maxDepth(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{}))));;
	}
}
