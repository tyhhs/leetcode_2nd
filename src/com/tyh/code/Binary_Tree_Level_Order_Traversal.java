package com.tyh.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.tyh.structure.TreeNode;
import com.tyh.util.ListTools;
import com.tyh.util.TreeTools;

public class Binary_Tree_Level_Order_Traversal {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		TreeNode root = TreeTools.createTree(nums);
		List<List<Integer>> lists = new Binary_Tree_Level_Order_Traversal().levelOrder(root);
		ListTools.printListInList(lists);
	}

    public List<List<Integer>> levelOrder(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	if(root == null){
    		return lists;
    	}
    	queue.offer(root);
    	queue.offer(null);
    	List<Integer> list = new ArrayList<Integer>();
    	while(!queue.isEmpty()){
    		TreeNode temp = queue.poll();
    		if(temp == null){
    			lists.add(new ArrayList<Integer>(list));
    			list = new ArrayList<Integer>();
    			if(!queue.isEmpty()) queue.offer(null);
    		}
    		else{
    			list.add(temp.val);
    			if(temp.left != null) queue.offer(temp.left);
    			if(temp.right != null) queue.offer(temp.right);
    		}
    	}
    	return lists;
    }
}
