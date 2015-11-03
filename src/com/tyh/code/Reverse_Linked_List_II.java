package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Reverse_Linked_List_II {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		ListNode head = ListNodeTools.createList(nums);
		head = new Reverse_Linked_List_II().reverseBetween(head,1,5);
		ListNodeTools.printList(head);
	}

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m >= n){
        	return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        //pre is the node before the reverse part, find the pre node
        int i = 1;
        while(i < m){
        	pre = pre.next;
        	i++;
        }
        ListNode reverseTail = pre.next;//reverseHead keeps pointing to the head of reverse part
        ListNode pointer = reverseTail.next;//pointer points to the current node which is going to be the new reverse head
        while(i < n){
        	ListNode temp = pointer.next;
        	pointer.next = pre.next; 
        	pre.next = pointer;
        	reverseTail.next = temp;
        	pointer = temp;
        	i++;
        }
        return res.next;
    }
}
