package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Remove_Nth_Node_From_End_of_List {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		ListNode list = ListNodeTools.createList(nums);
		int n = 2;
		ListNodeTools.printList(list);
		list = new Remove_Nth_Node_From_End_of_List().removeNthFromEnd(list, n);
		ListNodeTools.printList(list);
	}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode faster = head;
        int index = 0;
        while(index < n){
        	faster = faster.next;
        	index++;
        }
        if (faster == null) {//the node we want to remove is the head node 
			return head.next;
		}
        //otherwise, found the node before the node we want to remove
        ListNode slow = head;
        while(faster.next != null){
        	slow = slow.next;
        	faster = faster.next;
        }
        //the node slow is the previous node of our target node
        slow.next = slow.next.next;
        return head;
    }
}
