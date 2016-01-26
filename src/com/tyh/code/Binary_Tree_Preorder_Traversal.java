package com.tyh.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.tyh.structure.TreeNode;

public class Binary_Tree_Preorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//first method, recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        helper(root, list);
        return list;
    }
    
    private void helper(TreeNode root, List<Integer> list){
		list.add(root.val);
    	if(root.left != null){
    		helper(root.left, list);
    	}
    	if(root.right != null){
    		helper(root.right, list);
    	}
    }
    //second method, iteration
    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(root != null){
    		list.add(root.val);
    		if(root.right != null) stack.push(root.right);
    		root = root.left;
    		if(root != null && !stack.isEmpty()){
    			root = stack.pop();
    		}
    	}
    	return list;
    }
}
