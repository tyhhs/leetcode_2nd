package com.tyh.code;

import java.util.Stack;

import sun.net.www.content.text.plain;

public class Valid_Parentheses {

	public static void main(String[] args) {
		String s = "(";
		System.out.println(new Valid_Parentheses().isValid(s));

	}

    public boolean isValid(String s) {
        if (s.length()==0) {
			return false;
		}
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
        	if (isLeft(c)) {
				stack.push(c);
			}
        	else if (isRight(c)) {
				if (!stack.isEmpty()) {
					char left = stack.pop();
					if (!isMatch(left, c)) {
						return false;
					}
				}
				else{
					return false;
				}
			}
        }
        if (stack.isEmpty()) {
			return true;
		}
        return false;
    }
    public boolean isLeft(char c){
    	if (c == '(' || c == '{' || c == '[') {
    		return true;
		}
    	return false;
    }
    public boolean isRight(char c){
    	if (c == ')' || c == '}' || c == ']') {
			return true;
		}
    	return false;
    }
    public boolean isMatch(char left, char right){
    	if (left == '(') {
			if (right == ')') {
				return true;
			}
		}
    	else if (left == '[') {
			if (right == ']') {
				return true;
			}
		} 
    	else if(left == '{'){
    		if (right == '}') {
    			return true;
			}
		}
    	return false;
    }
}
