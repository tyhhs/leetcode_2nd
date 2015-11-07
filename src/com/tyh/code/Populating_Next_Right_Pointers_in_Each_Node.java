package com.tyh.code;

import com.tyh.structure.TreeLinkNode;

public class Populating_Next_Right_Pointers_in_Each_Node {

	public static void main(String[] args) {
	}

    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) return;
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
