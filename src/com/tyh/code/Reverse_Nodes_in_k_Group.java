package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Reverse_Nodes_in_k_Group {

	public static void main(String[] args) {
		ListNode list = ListNodeTools.createList(new int[]{1, 2, 3, 4, 5, 6, 7});
		ListNodeTools.printList(list);
		list = new Reverse_Nodes_in_k_Group().reverseKGroup(list, 3);
		ListNodeTools.printList(list);
	}
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode pointer = head;
		int count = 0;
		//to find the k+1 node, otherwise, return head without reverse
		while(pointer != null && count != k){
			pointer = pointer.next;
			count++;
		}
		if (count == k) {
			//reverse k+1 to k+k
			pointer = reverseKGroup(pointer, k);
			//reverse 1 to k
			ListNode current = head;
			while(count > 1){
				ListNode temp = current.next;
				current.next = temp.next;
				temp.next = head;
				head = temp;
				count--;
			}
			current.next = pointer;
		}
		return head;
	}
	
}
