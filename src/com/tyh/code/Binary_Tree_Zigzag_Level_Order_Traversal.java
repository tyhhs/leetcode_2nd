package com.tyh.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.tyh.structure.TreeNode;

public class Binary_Tree_Zigzag_Level_Order_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	if(root == null) return lists;
    	Stack<TreeNode> s1 = new Stack<TreeNode>();
    	Stack<TreeNode> s2 = new Stack<TreeNode>();
    	s1.push(root);
    	while(!s1.isEmpty() || !s2.isEmpty()){
    		if(!s1.isEmpty()){
    			List<Integer> list = new ArrayList<Integer>();
    			while(!s1.isEmpty()){
    				TreeNode temp = s1.pop();
    				list.add(temp.val);
    				if(temp.left != null) s2.push(temp.left);
    				if(temp.right != null) s2.push(temp.right);
    			}
    			lists.add(list);
    		}
    		else{
    			List<Integer> list = new ArrayList<Integer>();
    			while(!s2.isEmpty()){
    				TreeNode temp = s2.pop();
    				list.add(temp.val);
    				if(temp.right != null) s1.push(temp.right);
    				if(temp.left != null) s1.push(temp.left);
    			}
    			lists.add(list);
    		}
    	}
    	return lists;
    }
}
