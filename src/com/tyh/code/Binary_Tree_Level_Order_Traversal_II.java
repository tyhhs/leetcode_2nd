package com.tyh.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.tyh.structure.TreeNode;

public class Binary_Tree_Level_Order_Traversal_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root == null){
        	return lists;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> level = new ArrayList<Integer>();
        while(!queue.isEmpty()){
        	TreeNode temp = queue.poll();
        	if(temp != null){
        		level.add(temp.val);
        		if(temp.left != null) queue.offer(temp.left);
        		if(temp.right != null) queue.offer(temp.right);
        	}
        	else{
        		lists.add(0,level);
        		if(!queue.isEmpty()){
        			level = new ArrayList<Integer>();
        			queue.offer(null);
        		}
        	}
        }
        return lists;
    }
}
