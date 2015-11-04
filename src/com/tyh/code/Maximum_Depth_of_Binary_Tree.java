package com.tyh.code;

import java.util.LinkedList;
import java.util.Queue;

import com.tyh.structure.TreeNode;

public class Maximum_Depth_of_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//use queue to imitate BFS, count level
    public int maxDepth(TreeNode root) {
        if(root == null){
        	return 0;
        }
        int level = 0; 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
        	TreeNode temp = queue.poll();
        	if(temp == null){
        		level++;
        		if(!queue.isEmpty()) queue.offer(null);
        	}
        	else{
        		if(temp.left != null) queue.offer(temp.left);
        		if(temp.right != null) queue.offer(temp.right);
        	}
        }
        return level;
    }
    
    //recursive solution
    public int maxDepth2(TreeNode root) {
    	if(root == null) return 0;
    	int leftDepth = maxDepth2(root.left);
    	int rightDepth = maxDepth2(root.right);
    	return Math.max(leftDepth, rightDepth)+1;
    }
}
