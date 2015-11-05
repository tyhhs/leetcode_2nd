package com.tyh.code;

import java.util.Arrays;

import com.tyh.structure.TreeNode;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length, postLen = postorder.length;
    	if(inLen != postLen || inLen == 0){
    		return null;
    	}
    	if(inLen == 1){//save memory, don't need to call the recursive function
    		return new TreeNode(inorder[0]);
    	}
    	TreeNode root = new TreeNode(postorder[postLen-1]);
    	for(int i = 0; i < inLen; i++){
    		if(root.val == inorder[i]){
    			root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
    			root.right = buildTree(Arrays.copyOfRange(inorder, i+1, inLen), Arrays.copyOfRange(postorder, i, postLen-1));
    			break;
    		}
    	}
    	return root;
    }
}
