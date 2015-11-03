package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.structure.TreeNode;
import com.tyh.util.TreeTools;

public class Binary_Tree_Inorder_Traversal {

	public static void main(String[] args) {
		int[] nums = {1,2,3,-1,-1,4,-1,-1,5};
		TreeNode root = TreeTools.createTree(nums);
		List<Integer> list = new Binary_Tree_Inorder_Traversal().inorderTraversal(root);
		for(int i : list){
			System.out.print(i);
		}
	}

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        return list;
    }
    public void helper(TreeNode root, List<Integer> list){
    	if(root == null){
    		return;
    	}
    	if(root.left != null){
    		helper(root.left, list);
    	}
    	list.add(root.val);
    	if(root.right != null){
    		helper(root.right, list);
    	}
    }
}
