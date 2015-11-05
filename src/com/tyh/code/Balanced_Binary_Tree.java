package com.tyh.code;

import com.tyh.structure.TreeNode;

public class Balanced_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isBalanced(TreeNode root) {
    	if(root == null) return true;
    	if(Math.abs(helper(root.left) - helper(root.right)) > 1){
    		return false;
    	}
    	if (!isBalanced(root.left) || !isBalanced(root.right)){
    		return false;
    	}
    	return true;
    }
    
    public int helper(TreeNode root){
    	if(root == null) return 0;
    	int left = helper(root.left);
    	int right = helper(root.right);
    	return Math.max(left, right) + 1;
    }
}
