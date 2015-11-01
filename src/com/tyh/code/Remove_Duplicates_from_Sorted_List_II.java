package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Remove_Duplicates_from_Sorted_List_II {

	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3,3,4};
		ListNode head = ListNodeTools.createList(nums);
		head = new Remove_Duplicates_from_Sorted_List_II().deleteDuplicates(head);
		ListNodeTools.printList(head);
	}

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
        	return head;
        }
        ListNode header = new ListNode(0);
        header.next = head;
        ListNode pre = header;
        ListNode cur = head;
        while(cur != null && cur.next != null){
        	if(cur.val != cur.next.val){
        		pre = cur;
        		cur = cur.next;
        	}
        	else{
        		int val = cur.val;
        		while(cur != null && cur.val == val){
        			cur = cur.next;
        		}
        		pre.next = cur;
        	}
        }
        return header.next;
    }
}
