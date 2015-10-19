package com.tyh.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Merge_k_Sorted_Lists {

	public static void main(String[] args) {
		ListNode l1 = ListNodeTools.createList(new int[]{1,4,7,10});
		ListNode l2 = ListNodeTools.createList(new int[]{2,5,8,11});
		ListNode l3 = ListNodeTools.createList(new int[]{3,6,9,12,13});
		ListNode[] lists = new ListNode[]{l1,l2,l3};
		ListNode list = new Merge_k_Sorted_Lists().mergeKLists(lists);
		ListNodeTools.printList(list);
	}

	//time limit exceeded
/*    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i < lists.length; i++) {
			head = mergeTwoSortedLists(head, lists[i]);
		}
        return head;
    }*/
	
	//!!!!use a queue to always sort short lists at first
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> queue = new LinkedList<ListNode>();
		for(ListNode list : lists){
			queue.offer(list);
		}
		while(queue.size() > 1){
			ListNode l1 = queue.poll();
			ListNode l2 = queue.poll();
			ListNode list = mergeTwoSortedLists(l1, l2);
			queue.offer(list);
		}
		return queue.poll();
	}
    
    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
    	ListNode head = new ListNode(0);
    	ListNode pointer = head;
    	while(l1 != null && l2 != null){
    		if (l1.val <= l2.val) {
				pointer.next = l1;
				pointer = pointer.next;
				l1 = l1.next;
			}
    		else {
				pointer.next = l2;
				pointer = pointer.next;
				l2 = l2.next;
			}
    	}
    	if (l1 != null) {
			pointer.next = l1;
		}
    	else{
    		pointer.next = l2;
    	}
    	return head.next;
    }
}
