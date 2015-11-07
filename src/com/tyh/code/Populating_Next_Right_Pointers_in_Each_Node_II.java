package com.tyh.code;

import com.tyh.structure.TreeLinkNode;

public class Populating_Next_Right_Pointers_in_Each_Node_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public void connect(TreeLinkNode root) {
    	TreeLinkNode head = root;//The left most node in the lower level
        TreeLinkNode pre = null;//The previous node in the lower level
        TreeLinkNode cur = null;//The current node in the upper level
        while(head != null){
        	cur = head;
        	head = null;
        	pre = null;
        	while(cur != null){
        		if(cur.left != null){
        			if(pre != null){//if pre is not null, pre is the previous node of current node
        				pre.next = cur.left;
        				pre = cur.left;
        			}
        			else{//if pre is null, that means cur.left is the left most node in this level
        				pre = cur.left;
        				head = cur.left;
        			}
        		}
        		if(cur.right != null){
        			if(pre != null){
        				pre.next = cur.right;
        				pre = cur.right;
        			}
        			else{
        				pre = cur.right;
        				head = cur.right;
        			}
        		}
        		cur = cur.next;
        	}
        }
    }
}
