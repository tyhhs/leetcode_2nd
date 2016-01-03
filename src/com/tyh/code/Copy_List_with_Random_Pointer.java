package com.tyh.code;

import com.tyh.structure.RandomListNode;

public class Copy_List_with_Random_Pointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null) return null;
    	RandomListNode curr = head;
    	RandomListNode temp = null;
    	//first loop, create copy of each node right after each node 
    	while(curr != null){
    		RandomListNode node = new RandomListNode(curr.label);
    		temp = curr.next;
    		curr.next = node;
    		node.next = temp;
    		curr = temp;
    	}
    	//second loop, make duplicate nodes' random pointers point to right nodes
    	curr = head;
    	while(curr != null){
    		if(curr.random != null)
    			curr.next.random = curr.random.next;
    		curr = curr.next.next;
    	}
    	//third loop, get the copy list
    	RandomListNode copy = head.next;
    	curr = copy;
    	while(curr.next != null){
    		head.next = curr.next;
    		curr.next = head.next.next;
    		head = head.next;
    		curr = curr.next;
    	}
    	head.next = null;
    	return copy;   	
    }
}
