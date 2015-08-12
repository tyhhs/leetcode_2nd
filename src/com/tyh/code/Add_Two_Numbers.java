package com.tyh.code;

import com.tyh.structure.ListNode;
import com.tyh.util.ListNodeTools;

public class Add_Two_Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {5};
		int[] nums2 = {5};
		ListNode l1 = ListNodeTools.createList(nums1);
		ListNode l2 = ListNodeTools.createList(nums2);
		ListNode res = new Add_Two_Numbers().addTwoNumbers(l1, l2);
		ListNodeTools.printList(res);
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //set a dummy head
    	ListNode dummy = new ListNode(0);
    	//set a pointer point to current node
    	ListNode pointer = dummy;
    	//set a number to record carry 
    	int carry = 0;
    	while(l1 != null || l2 != null){
    		int val1, val2;
    		if(l1 != null && l2 != null){
    			val1 = l1.val;
    			val2 = l2.val;
    			l1 = l1.next;
    			l2 = l2.next;
    		}else if(l1 == null){
    			val1 = 0;
    			val2 = l2.val;
    			l2 = l2.next;
    		}else{
    			val1 = l1.val;
    			val2 = 0;
    			l1 = l1.next;
    		}
    		int sum = val1 + val2 + carry;
    		carry = 0;
    		if(sum > 9){
    			sum -= 10;
    			carry = 1;
    		}
    		ListNode temp = new ListNode(sum);
    		pointer.next = temp;
    		pointer = temp;
    	}
    	//handle carry
    	if(carry == 1){
    		pointer.next = new ListNode(1);
    	}
    	return dummy.next;
    }
}
