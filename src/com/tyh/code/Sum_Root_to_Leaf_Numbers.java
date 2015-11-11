package com.tyh.code;

import com.tyh.structure.TreeNode;

public class Sum_Root_to_Leaf_Numbers {
	int sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, new StringBuilder());
        return sum;
    }
    private void helper(TreeNode root, StringBuilder sb){
    	if(root == null) return;
    	sb.append(root.val);
    	if(root.left == null && root.right == null){
    		sum += Integer.parseInt(sb.toString());
    	}
    	helper(root.left, new StringBuilder(sb));
    	helper(root.right, new StringBuilder(sb));
    }
    
    public int sumNumbers2(TreeNode root) {
    	return helper2(root, 0);
    }
    public int helper2(TreeNode root,int path) {
        if(root==null){
        	return 0;
        }
        path=10*path+root.val;
        
        if(root.left==null&&root.right==null){
        	return path;
        }
        
        return helper2(root.left,path)+helper2(root.right,path);
    }
}
