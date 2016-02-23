package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Reverse_Linked_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6};
		ListNode head = ListNodeTools.createList(nums);
		head = new Reverse_Linked_List().reverseList1(head);
		ListNodeTools.printList(head);
	}

	//iteratively
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode first = null;
        ListNode second = head;
        while(second != null){
            dummy.next = second;
            second = second.next;
            dummy.next.next = first;
            first = dummy.next;
        }
        return dummy.next;
    }
    
    //recursively
    public ListNode reverseList1(ListNode head) {
    	ListNode dummy = new ListNode(0);
    	helper(dummy, head);
    	return dummy.next;
    }
    
    private void helper(ListNode dummy, ListNode second){
    	if(second == null) return;
    	ListNode temp = dummy.next;
    	dummy.next = second;
    	second = second.next;
    	dummy.next.next = temp;
    	helper(dummy, second);
    }
}