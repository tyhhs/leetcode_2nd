package com.tyh.code;

import com.tyh.structure.TreeNode;

public class Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean hasPathSum(TreeNode root, int sum) {
    	if(root == null){
    		return false;
    	}
    	if(root.left == null && root.right == null){
    		if(root.val == sum) return true;
    	}
    	return (hasPathSum(root.left, sum-root.val)) || (hasPathSum(root.right, sum-root.val));
    }
}
