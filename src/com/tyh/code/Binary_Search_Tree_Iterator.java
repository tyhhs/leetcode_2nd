package com.tyh.code;

import java.util.Stack;

import com.tyh.structure.TreeNode;
import com.tyh.util.TreeTools;

public class Binary_Search_Tree_Iterator {
	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root); 
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	public static void main(String[] args) {
		int[] nums = {4,2,6,1,3,5,7};
		TreeNode root = TreeTools.createTree(nums);
		Binary_Search_Tree_Iterator iter = new Binary_Search_Tree_Iterator(root);
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	private Stack<TreeNode> stack = new Stack<TreeNode>();
	
    public Binary_Search_Tree_Iterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }
    
    private void pushAll(TreeNode root){
    	if(root == null){
    		return;
    	}
    	else{
    		stack.push(root);
    	}
    	while(root.left != null){
    		stack.push(root.left);
    		root = root.left;
    	}
    }
}
