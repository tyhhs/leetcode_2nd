package com.tyh.code;

import com.tyh.structure.TreeNode;
import com.tyh.util.TreeTools;

public class Validate_Binary_Search_Tree {

	public static void main(String[] args) {
		int[] nums = {4,2,6,1,3,5,7};
		TreeNode root = TreeTools.createTree(nums);
		System.out.println(new Validate_Binary_Search_Tree().isValidBST(root));
	}

    public boolean isValidBST(TreeNode root) {
    	return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long lower, long upper){
    	if(root == null) return true;
    	if(root.val <= lower || root.val >= upper) return false;
    	return (helper(root.left, lower, root.val) && helper(root.right, root.val, upper));
    }
}
