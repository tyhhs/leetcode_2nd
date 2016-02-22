package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Remove_Linked_List_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,6,3,4,5,6};
		ListNode head = ListNodeTools.createList(nums);
		head = new Remove_Linked_List_Elements().removeElements(head, 6);
		ListNodeTools.printList(head);
	}
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null){
            if(pre.next.val != val){
                pre = pre.next;
            }
            else{
                pre.next = pre.next.next;
            }
        }
        return dummy.next;
    }
}
