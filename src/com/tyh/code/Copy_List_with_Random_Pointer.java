package com.tyh.code;

import com.tyh.structure.RandomListNode;

public class Copy_List_with_Random_Pointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null){
        	return null;
        }
    	RandomListNode curr=head;
    	RandomListNode temp;
        while(curr!=null){
        	RandomListNode insert=new RandomListNode(curr.label);
        	temp=curr.next;
        	curr.next=insert;
        	insert.next=temp;
        	curr=temp;
        }
        curr=head;
        while(curr!=null){
        	temp=curr.next.next;
        	if(curr.random!=null){
        		curr.next.random=curr.random.next;
        	} 
        	curr=temp;
        }
        RandomListNode copy=head.next;
        curr=copy;
        while(curr.next!=null){
        	head.next=curr.next;
        	curr.next=head.next.next;
        	head=head.next;
        	curr=curr.next;
        }
        head.next=null;
        return copy;
    }
}
