package com.tyh.code;

import com.tyh.structure.ListNode;

public class Linked_List_Cycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean hasCycle(ListNode head) {
        //use two pointers, slow one forwards one step per move, the fast one forwards two steps per move
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow == fast){
    			return true;
    		}
    	}
    	return false;
    }
}
