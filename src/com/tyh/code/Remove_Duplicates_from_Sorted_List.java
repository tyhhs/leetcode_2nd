package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Remove_Duplicates_from_Sorted_List {

	public static void main(String[] args) {
		int[] nums = {1,1};
		ListNode head = ListNodeTools.createList(nums);
		head = new Remove_Duplicates_from_Sorted_List().deleteDuplicates(head);
		ListNodeTools.printList(head);
	}

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
        	return head;
        }
        ListNode cur = head;
        ListNode nextNode = cur.next;
        while(nextNode != null){
        	if(cur.val != nextNode.val){
        		cur = nextNode;
        		nextNode = nextNode.next;
        	}
        	else{
        		int val = nextNode.val;
        		while(nextNode != null && nextNode.val == val){
        			nextNode = nextNode.next;
        		}
        		cur.next = nextNode;
        	}
        }
        return head;
    }
}
