package com.leetcode.en.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.TreeNodeUtil;

public class SymmetricTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 * 
	 * by level
	 */
	public static class Solution {
	    public boolean isSymmetric(TreeNode root) {
	    	if (root == null){
	    		return true;
	    	}
	    	List<TreeNode> row = new ArrayList<TreeNode>(2);
	    	if(isNodeEqual(root.left, root.right)){
	    		row.add(root.left);
	    		row.add(root.right);
	    		return isSymmetric(row);
	    	}else {
				return false;
			}
	    }

		private boolean isSymmetric(List<TreeNode> row) {
			if (row.isEmpty()){
				return true;
			}else if (row.size() % 2 != 0) {
				return false;
			}

			List<TreeNode> front = new ArrayList<TreeNode>(row.size());
			List<TreeNode> back = new ArrayList<TreeNode>(row.size());
			for (int i = 0, j = row.size() - 1; i < j; i++, j--) {
				TreeNode left = row.get(i);
				TreeNode right = row.get(j);
				if(isNodeEqual(left, right)){
					if (left != null){
						front.add(left.left);
						front.add(left.right);
						back.add(right.right);
						back.add(right.left);
					}
				}else {
					return false;
				}
			}
			
			List<TreeNode> next = new ArrayList<TreeNode>(front.size() + back.size()); 
			next.addAll(front);
			Collections.reverse(back);
			next.addAll(back);
			return isSymmetric(next);
		
		}

		private boolean isNodeEqual(TreeNode front, TreeNode end) {
			if (front == null && end == null){
				return true;
			}else if (front == null || end == null) {
				return false;
			}else {
				return front.val == end.val;
			}
		}
	}
	
	public static class Solution2 {
	    public boolean isSymmetric(TreeNode root) {
	    	if (root == null){
	    		return true;
	    	}
	    	List<String> values = new ArrayList<String>(200);
	    	visitInOrder(root, values);
	    	for (int i = 0, j = values.size() - 1; i < j; i++, j--) {
				if ( !values.get(i).equals(values.get(j))){
					return false;
				}
			}
	    	
	    	return true;
	    }

		private void visitInOrder(TreeNode root, List<String> values) {
			if (root == null){
				return;
			}
			
			if (root.left != null){
				visitInOrder(root.left, values);
			}
			
			if (root.left == null && root.right != null){
				values.add("#");
			}
			
			values.add(root.val+"");
			
			if (root.right != null){
				visitInOrder(root.right, values);
			}
			if (root.left != null && root.right == null){
				values.add("#");
			}
		}
	}
	
	public static class Solution3 {
		public boolean isSymmetric(TreeNode root) {
			if (root == null){
				return true;
			}
			
			return isSymmetric(root.left , root.right);
		}

		private boolean isSymmetric(TreeNode left, TreeNode right) {
			if (left == null && right == null){
				return true;
			}else if (left == null || right ==  null) {
				return false;
			}else {
				return left.val== right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
			}
		}
	}
	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		System.out.println(solution.isSymmetric(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{}))));
		System.out.println(solution.isSymmetric(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1}))));
		System.out.println(solution.isSymmetric(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2}))));
		System.out.println(solution.isSymmetric(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,2}))));
		System.out.println(solution.isSymmetric(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,2,3,3,3,3}))));
		System.out.println(solution.isSymmetric(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,2,3,3,null,3}))));
		// [1,2,3,3,null,2,null] falese
		System.out.println(solution.isSymmetric(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{1,2,3,3,null,2,null}))));
//		[5,4,1,null,1,null,4,2,null,2,null]
		System.out.println(solution.isSymmetric(TreeNodeUtil.toTree(Arrays.asList(new Integer[]{5,4,1,null,1,null,4}))));
	}
}
