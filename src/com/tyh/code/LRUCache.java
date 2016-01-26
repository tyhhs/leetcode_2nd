package com.tyh.code;

import java.util.Hashtable;

public class LRUCache {
	class DoubleLinkedNode{		
		int key;
		int value;
		DoubleLinkedNode pre;
		DoubleLinkedNode next;
		public DoubleLinkedNode(int key, int value){
			this.key = key;
			this.value = value;
		}
		public DoubleLinkedNode(){
			
		}
	}
	//pseudo head and tail
	private DoubleLinkedNode head;
	private DoubleLinkedNode tail;
	
	private Hashtable<Integer, DoubleLinkedNode> cache = new Hashtable<Integer, DoubleLinkedNode>();
	private int count;
	private int capacity;
	
	//always add the new node right after the head
	private void addNode (DoubleLinkedNode node){
		node.pre = head;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
	}
	
	//Remove the existing node from the double linked list
	private void removeNode(DoubleLinkedNode node){
		DoubleLinkedNode pre = node.pre;
		DoubleLinkedNode next = node.next;
		pre.next = next;
		next.pre = pre;
	}

	//move a certain node in between to the head
	private void moveNodeToHead(DoubleLinkedNode node){
		this.removeNode(node);
		this.addNode(node);
	}
	//pop the current tail
	private DoubleLinkedNode popTail(){
		DoubleLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}
    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        
        head = new DoubleLinkedNode();
        head.pre = null;
        
        tail = new DoubleLinkedNode();
        tail.next = null;
        
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null){
        	return -1;//should raise exception here
        }
        
        //move the assessed node to the head
        this.moveNodeToHead(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null){
        	node = new DoubleLinkedNode(key, value);
        	this.cache.put(key, node);
        	this.addNode(node);
        	
        	++count;
        	
        	if(count > capacity){
        		DoubleLinkedNode tail = this.popTail();
        		cache.remove(tail.key);
        		--count;
        	}
        }
        else{
        	node.value = value;//update value
        	this.moveNodeToHead(node);
        }
    }

}
