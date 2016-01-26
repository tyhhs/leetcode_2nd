package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Sort_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,4,1};
		ListNode head = ListNodeTools.createList(nums);
		ListNodeTools.printList(new Sort_List().sortList(head));
	}

	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		//split the list
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		head = sortList(head);
		head2 = sortList(head2);
		return merge(head, head2); 
    }
	
	private ListNode merge(ListNode h1, ListNode h2){
		ListNode pseudoHead = new ListNode(0);
		ListNode cur = pseudoHead;
		while(h1 != null && h2 != null){
			if(h1.val <= h2.val){
				cur.next = h1;
				h1 = h1.next;
			}
			else{
				cur.next = h2;
				h2 = h2.next;
			}
			cur = cur.next;
		}
		if(h1 != null){
			cur.next = h1;
		}
		else{
			cur.next = h2;
		}
		return pseudoHead.next;
	}
}
