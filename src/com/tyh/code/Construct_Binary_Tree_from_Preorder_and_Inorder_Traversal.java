package com.tyh.code;

import java.util.Arrays;

import com.tyh.structure.TreeNode;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	public static void main(String[] args) {
		int[] preorder = {2,4,5};
		int[] inorder = {4,2,5};
		TreeNode root = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal().buildTree(preorder, inorder);
	}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length || preorder.length == 0){
        	return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1){
        	return root;
        }
        for(int i = 0; i < inorder.length; i++){
        	if(preorder[0] == inorder[i]){
        		root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1+i), Arrays.copyOfRange(inorder, 0, i));
        		root.right = buildTree(Arrays.copyOfRange(preorder, 1+i, preorder.length), Arrays.copyOfRange(inorder, i+1, inorder.length));
        		break;
        	}
        }
        return root;
    }
}
