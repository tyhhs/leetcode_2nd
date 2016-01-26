package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Insertion_Sort_List {

	public static void main(String[] args){
		int[] nums = {1, 3, 5, 2, 4};
		ListNode head = ListNodeTools.createList(nums);
		ListNodeTools.printList(head);
		head = new Insertion_Sort_List().insertionSortList(head);
		ListNodeTools.printList(head);
	}
	
	public ListNode insertionSortList(ListNode head){
		if(head == null) return head;
		ListNode pseudoHead = new ListNode(0);
		pseudoHead.next = head;
		ListNode cur = head.next;
		ListNode pre = head;
		boolean insert;
		while(cur != null){
			insert = false;
			ListNode pointer = pseudoHead;
			while(pointer.next != cur){
				if(cur.val < pointer.next.val){
					pre.next = cur.next;
					cur.next = pointer.next;
					pointer.next = cur;
					cur = pre.next;
					insert =true;
					break;
				}
				pointer = pointer.next;
			}
			if(!insert){
				pre = pre.next;
				cur = cur.next; 
			}
		}
		return pseudoHead.next;
	}
}
