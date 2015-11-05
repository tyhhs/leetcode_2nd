package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.structure.TreeNode;

public class Path_Sum_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(root, sum, lists, new ArrayList<Integer>());
        return lists;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list){
    	if(root == null){
    		return;
    	}
    	if(root.left == null && root.right == null){
    		if(root.val == sum){
    			list.add(root.val);
    			lists.add(list);
    		}
    	}
    	if(root.left != null){
    		List<Integer> left = new ArrayList<Integer>(list);
    		left.add(root.val);
    		helper(root.left, sum - root.val, lists, left);
    	}
    	if(root.right != null){
    		List<Integer> right = new ArrayList<Integer>(list);
    		right.add(root.val);
    		helper(root.right, sum - root.val, lists, right);
    	}
    }
}
