package com.leetcode.en.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.alphatok.domain.TreeNode;
import com.alphatok.util.CollectionUtil;

public class BinaryTreePaths {
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
	    public List<String> binaryTreePaths(TreeNode root) {
	        if (root == null){
	        	return Collections.emptyList();
	        }
	        
	        List<String> result = new ArrayList<>();
	        Deque<TreeNode> nodes = new LinkedList<TreeNode>();
	        nodes.add(root);
	        Map<TreeNode, Boolean> visited = new HashMap<>();
	        visited.put(root, Boolean.TRUE);
	        while (!nodes.isEmpty()) {
	        	TreeNode node = nodes.peekLast();
	        	
	        	if (node.left != null && !Boolean.TRUE.equals(visited.get(node.left))){
	        		nodes.addLast(node.left);
	        		visited.put(node.left, Boolean.TRUE);
	        		continue;
	        	}
	        	
	        	if (node.right != null && !Boolean.TRUE.equals(visited.get(node.right))){
	        		nodes.addLast(node.right);
	        		visited.put(node.right, Boolean.TRUE);
	        		continue;
	        	}
	        	
	        	if (node.left == null && node.right == null){
	        		result.add(concatQueue(nodes));
	        		nodes.removeLast();
	        		continue;
	        	} 
	        	
	        	if (visited.containsKey(node.right) && visited.containsKey(node.left) &&
	        			Boolean.TRUE.equals(visited.get(node.right) && Boolean.TRUE.equals(visited.get(node.left)))) {
	        		nodes.removeLast();
	        		continue;
				}else if (visited.containsKey(node.right) && Boolean.TRUE.equals(visited.get(node.right))) {
					nodes.removeLast();
					continue;
				}else if ( visited.containsKey(node.left) && Boolean.TRUE.equals(visited.get(node.left))) {
					nodes.removeLast();
					continue;
				}
			}
	        
	        return result;
	    }
	    
	    private String concatQueue(Queue<TreeNode> nodes){
	    	StringBuilder buffer = new StringBuilder();
	    	for (Iterator<TreeNode> iterator = nodes.iterator(); iterator.hasNext();) {
				TreeNode treeNode = (TreeNode) iterator.next();
				buffer.append(treeNode.val);
				if (iterator.hasNext()){
					buffer.append("->");
				}
			}
	    	
	    	return buffer.toString();
	    }
	}
	
	public static class Solution2{
		/**recursive visit dfs*/
		public List<String> binaryTreePaths(TreeNode root) {  
	        List<String> result = new ArrayList<>();  
	        if(root == null) {
	        	return result;  
	        }
	        StringBuilder path = new StringBuilder();   // cache from root(do reset length if returned from child)
	        recursiveVisit(root, result, path);  
	        
	        return result;  
	    }

		private void recursiveVisit(TreeNode root, List<String> result, StringBuilder path) {
			if(root.left == null && root.right == null){
				path.append(root.val);
				result.add(path.toString());
				return;
			}
			
			path.append(root.val).append("->");
			int fromPathLength = path.length();
			
			if (root.left != null){
				recursiveVisit(root.left, result, path);
			}
			
			path.setLength(fromPathLength);
			
			if (root.right != null){
				recursiveVisit(root.right, result, path);
			}
		}  
		
		public static class Solution3{

		    List<String> res = new ArrayList<String>();
		    
		    public List<String> binaryTreePaths(TreeNode root) {
		        if(root != null) findPaths(root,String.valueOf(root.val));
		        return res;
		    }
		    
		    private void findPaths(TreeNode n, String path){
		        if(n.left == null && n.right == null) res.add(path);
		        if(n.left != null) findPaths(n.left, path+"->"+n.left.val);
		        if(n.right != null) findPaths(n.right, path+"->"+n.right.val);
		    }


		}

	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
//		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
//		
//		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		CollectionUtil.print(solution.binaryTreePaths(root));
		
//		Deque<TreeNode> nodes = new LinkedList<>();
//		nodes.add(new TreeNode(1));
//		nodes.add(new TreeNode(3));
//		nodes.add(new TreeNode(5));
//		nodes.add(new TreeNode(2));
//		System.out.println(solution.concatQueue(nodes));
		
		CollectionUtil.print(new Solution2().binaryTreePaths(root));
	}
}
