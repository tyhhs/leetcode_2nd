 package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Merge_Two_Sorted_Lists {

	public static void main(String[] args) {
		ListNode l1 = ListNodeTools.createList(new int[]{1,3,5,7});
		ListNode l2 = ListNodeTools.createList(new int[]{2,4,6,8,10,12});
		ListNodeTools.printList(new Merge_Two_Sorted_Lists().mergeTwoLists(l1, l2));

	}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode list = new ListNode(0);
    	ListNode pointer = list;
    	while(l1 != null && l2 != null){
    		if (l1.val <= l2.val) {
				pointer.next = l1;
				pointer = pointer.next;
				l1 = l1.next;
			}
    		else{
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
    	return list.next;
    }
}
