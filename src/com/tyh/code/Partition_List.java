package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Partition_List {

	public static void main(String[] args) {
		int[] nums = {1,4,3,2,5,2};
		ListNode head = ListNodeTools.createList(nums);
		head = new Partition_List().partition(head, 3);
		ListNodeTools.printList(head);
	}

    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.next == null){
    		return head;
    	}
    	ListNode res = new ListNode(0);
    	res.next = head;
    	ListNode cur = res;
    	while(cur.next != null && cur.next.val < x){
    		cur = cur.next;
    	}
    	ListNode pointer = cur;
    	while(pointer.next != null){
    		if(pointer.next.val < x){
    			ListNode temp = cur.next;
    			cur.next = pointer.next;
    			cur = cur.next;
    			pointer.next = pointer.next.next;
    			cur.next = temp;
    		}
    		else{
    			pointer = pointer.next;
    		}
    	}
    	return res.next;
    }
}
