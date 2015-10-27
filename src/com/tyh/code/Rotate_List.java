package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Rotate_List {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		ListNode list = ListNodeTools.createList(nums);
		ListNode res = new Rotate_List().rotateRight(list, 7);
		ListNodeTools.printList(res);
	}

    public ListNode rotateRight(ListNode head, int k) {
    	if(head == null){
    		return head;
    	}
    	//get the length of the list
    	ListNode counter = head;
    	int count = 0;
    	while(counter != null){
    		counter = counter.next;
    		count++;
    	}
    	k = k % count;
    	if(k == 0){
    		return head;
    	}
    	//use two points to find to kth element to the right
    	ListNode slow = head, fast = head;
    	int i = 0;
    	while(i < k){
    		fast = fast.next;
    		i++;
    	}
    	while(fast.next != null){
    		slow = slow.next;
    		fast = fast.next;
    	}
    	fast.next = head;
    	head = slow.next;
    	slow.next = null;
    	return head;
    }
}
