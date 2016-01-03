package com.tyh.code;

import com.tyh.structure.ListNode;

public class Linked_List_Cycle_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode detectCycle(ListNode head) {
        //first check if there is a cycle
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast != null && fast.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    		if(slow == fast){
    			//these two pointers meet, there is a cycle
    			//the distance between the start point the the cycle beginning equals to the distance between meeting point to the beginning
    			ListNode helper = head;
    			while(helper != slow){
    				helper = helper.next;
    				slow = slow.next;
    			}
    			return slow;
    		}
    	}
    	//no cycle
    	return null;
    }
}
