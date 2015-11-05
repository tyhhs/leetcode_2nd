package com.tyh.code;

import java.util.Arrays;

import com.tyh.structure.TreeNode;

public class Convert_Sorted_Array_to_Binary_Search_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if(len == 0) return null;
        if(len == 1) return new TreeNode(nums[0]);
        int mid = len/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, len));
        return root;
    }
}
