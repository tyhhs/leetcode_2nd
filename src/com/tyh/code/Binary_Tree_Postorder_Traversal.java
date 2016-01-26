package com.tyh.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.tyh.structure.TreeNode;

public class Binary_Tree_Postorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//first method, recursion 
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        helper(root, list);
        return list;
    }
    private void helper(TreeNode root, List<Integer> list){
    	if(root.left != null) helper(root.left, list);
    	if(root.right != null) helper(root.right, list);
    	list.add(root.val);
    }
    
    //second method, iteration, using stack
    public List<Integer> postorderTraversal2(TreeNode root){
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null) return list;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	TreeNode temp;
    	while(!stack.isEmpty()){
    		temp = stack.pop();
    		list.add(temp.val);
    		if(temp.left != null) stack.push(temp.left);
    		if(temp.right != null) stack.push(temp.right);
    	}
    	List<Integer> res = new ArrayList<Integer>();
    	for(int i : list){
    		res.add(0, i);
    	}
    	return res;
    }
}
