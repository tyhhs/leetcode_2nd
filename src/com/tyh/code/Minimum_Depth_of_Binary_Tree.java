package com.tyh.code;

import com.tyh.structure.TreeNode;

public class Minimum_Depth_of_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? (left == 0 ? right + 1 : left + 1) : Math.min(left, right) + 1;
    }
}
