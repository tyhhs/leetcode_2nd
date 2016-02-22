package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

import com.tyh.structure.TreeNode;

public class Binary_Tree_Right_Side_View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(res, 0, root);
        return res;
    }
    private void helper(List<Integer> res, int depth, TreeNode root){
        if(root == null) return;
        if(depth == res.size()){//the right most node
            res.add(root.val);
        }
        helper(res, depth + 1, root.right);
        helper(res, depth + 1, root.left);
    }
}
