package com.tyh.code;

import com.tyh.structure.ListNode;

public class Intersection_of_Two_Linked_Lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //check boundary conditions
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
