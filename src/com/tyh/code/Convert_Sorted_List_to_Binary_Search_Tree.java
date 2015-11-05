package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.structure.TreeNode;
import com.tyh.util.ListNodeTools;

public class Convert_Sorted_List_to_Binary_Search_Tree {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		ListNode head = ListNodeTools.createList(nums);
		TreeNode root = new Convert_Sorted_List_to_Binary_Search_Tree().sortedListToBST(head);
	}

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        //find the middle node
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        //slow is the node before the middle node
        TreeNode root = new TreeNode(slow.next.val);
        root.right = sortedListToBST(slow.next.next);
        slow.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
