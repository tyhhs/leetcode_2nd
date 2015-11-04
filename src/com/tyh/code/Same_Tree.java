package com.tyh.code;

import com.tyh.structure.TreeNode;

public class Same_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// inorder 
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p == null && q == null) return true;
        if((p == null && q != null) || (q == null && p != null)){
        	return false;
        }
        if(!isSameTree(p.left, q.left)) return false;
        if(p.val != q.val) return false;
        if(!isSameTree(p.right, q.right)) return false;
        return true;
    }
    //preorder
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
