package com.leetcode.bruceyang.easy;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.TreeNodeUtil;

public class SameTree {
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
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        if (p == null && q == null){
	        	return true;
	        }else if (q != null && p != null && q.val != p.val){
	        	return false;
			}else if ((p == null && q != null) || (p != null && q == null)) {
				return false;
			}
	        
	        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
	    }
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode p = TreeNodeUtil.toTree(new Integer[]{1, null, 3});
		TreeNode q = TreeNodeUtil.toTree(new Integer[]{1, null, 3});
		System.out.println(solution.isSameTree(p, q));
	}
}
