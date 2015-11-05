package com.tyh.code;

import java.util.Stack;

import com.tyh.structure.TreeNode;
import com.tyh.util.TreeTools;

public class Flatten_Binary_Tree_to_Linked_List {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		TreeNode root = TreeTools.createTree(nums);
		new Flatten_Binary_Tree_to_Linked_List().flatten2(root);
	}

	//post order traversal solution, very neat
	public void flatten(TreeNode root) {
	    flatten(root,null);
	}
	private TreeNode flatten(TreeNode root, TreeNode pre) {
	    if(root==null) return pre;
	    pre=flatten(root.right,pre);    
	    pre=flatten(root.left,pre);
	    root.right=pre;
	    root.left=null;
	    pre=root;
	    return pre;
	}
	
	//use a stack to solve this problem
	public void flatten2(TreeNode root) {
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root.right != null) stack.push(root.right);
		if(root.left != null) stack.push(root.left);
		TreeNode pre = root;
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			if(temp.right != null) stack.push(temp.right);
			if(temp.left != null) stack.push(temp.left);
			pre.right = temp;
			pre.left = null;
			pre = pre.right;
		}
	}
}
