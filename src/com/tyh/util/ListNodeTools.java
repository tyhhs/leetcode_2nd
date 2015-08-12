package com.tyh.util;

import com.tyh.structure.ListNode;

public class ListNodeTools {
	/**
	 * build linked list based on the array order
	 * @param nums
	 * @return List
	 */
	public static ListNode createList(int[] nums){
		if(nums.length == 0){
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		for(int i : nums){
			ListNode temp = new ListNode(i);
			curr.next = temp;
			curr = temp;
		}
		return dummy.next;
	}
	
	public static void printList(ListNode list){
		if(list == null){
			System.out.println("null");
			return;
		}
		System.out.print(list.val+"->");
		printList(list.next);
	}
	
}
