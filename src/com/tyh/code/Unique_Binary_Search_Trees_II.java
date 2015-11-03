package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.structure.TreeNode;

public class Unique_Binary_Search_Trees_II {

	public static void main(String[] args) {
		List<TreeNode> list = new Unique_Binary_Search_Trees_II().generateTrees(3);
		System.out.println(list.size());
	}
	
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    public List<TreeNode> helper(int low, int high){
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	if(low == high){
    		list.add(new TreeNode(low));
    		return list;
    	}
    	if(low > high){
    		list.add(null);
    		return list;
    	}
    	for(int i = low; i <= high; i++){   		
    		List<TreeNode> leftList = helper(low, i-1);
    		List<TreeNode> rightList = helper(i+1, high);
    		for(TreeNode left : leftList){
    			for(TreeNode right : rightList){
    				TreeNode root = new TreeNode(i);
    				root.left = left;
    				root.right = right;
    				list.add(root);
    			}
    		}
    	}
    	return list;
    }
}
