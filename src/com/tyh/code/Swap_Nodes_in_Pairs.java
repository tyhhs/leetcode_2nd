package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Swap_Nodes_in_Pairs {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		ListNode head = ListNodeTools.createList(nums);
		ListNode list = new Swap_Nodes_in_Pairs().swapPairs(head);
		ListNodeTools.printList(list);
	}

    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null) {
			return head;
		}
    	ListNode list = new ListNode(0);
    	list.next = head;
    	ListNode previous = list;
    	while(previous.next != null && previous.next.next != null){
    		ListNode p1 = previous.next;
    		ListNode p2 = p1.next;
    		p1.next = p2.next;
    		p2.next = p1;
    		previous.next = p2;
    		previous = p1;
    	}
    	return list.next;
    }
}
