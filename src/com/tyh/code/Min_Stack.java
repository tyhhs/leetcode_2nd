package com.tyh.code;

import java.util.Stack;

public class Min_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Stack<Integer> minStack = new Stack<Integer>();
    private Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
