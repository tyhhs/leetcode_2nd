package com.tyh.util;

import java.util.LinkedList;
import java.util.Queue;

import com.tyh.structure.TreeNode;

public class TreeTools {
	public static TreeNode createTree(int[] nums){
		//-1 instead # in leetcode represent
		int length = nums.length;
		if(length < 1){
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int i = 0;//the current val going to insert into the tree
		//root
		TreeNode root = new TreeNode(nums[i++]);
		//add the root into the queue
		queue.offer(root);
		//construct the tree
		while(!queue.isEmpty() && i < length){
			TreeNode parent = queue.poll();
			if(nums[i] != -1){
				TreeNode left = new TreeNode(nums[i++]);
				parent.left = left;
				queue.offer(left);
			}
			else{
				i++;
			}
			if(i < length){
				if(nums[i] != -1){
					TreeNode right = new TreeNode(nums[i++]);
					parent.right = right;
					queue.offer(right);
				}
				else{
					i++;
				}
			}
		}
		return root;
	}
	
	public static void printTree(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			System.out.print(temp.val+" ");
			if(temp.val != -1){
				if(temp.left == null){
					queue.add(new TreeNode(-1));
				}
				else{
					queue.add(temp.left);
				}
				if(temp.right == null){
					queue.add(new TreeNode(-1));
				}
				else{
					queue.add(temp.right);
				}
			}
		}
	}
}
