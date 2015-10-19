package com.tyh.code;

import java.util.Stack;

public class Longest_Valid_Parentheses {

	public static void main(String[] args) {
		String s = ")()())";
		System.out.println(new Longest_Valid_Parentheses().longestValidParentheses(s));

	}
/*	
	 * The workflow of the solution is as below.
	 * 
	 * 1. Scan the string from beginning to end. If current character is '(', push
	 * its index to the stack. 
	 * 2. If current character is ')' and the character at
	 * the index of the top of stack is '(', we just find a matching pair so pop
	 * from the stack. Otherwise, we push the index of ')' to the stack. 
	 * 3. After the scan is done, the stack will only contain the indices of characters
	 * which cannot be matched. Then let's use the opposite side - substring
	 * between adjacent indices should be valid parentheses. 
	 * 4. If the stack is empty, the whole input string is valid. Otherwise, we can scan the stack
	 * to get longest valid substring as described in step 3.
	 */
    public int longestValidParentheses(String s) {
    	Stack<Integer> stack = new Stack<>();
    	char[] chars = s.toCharArray();
    	for(int i = 0; i < chars.length; i++){
    		if (chars[i] == '(') {
				stack.push(i);
			}
    		else{
    			if (!stack.isEmpty() && chars[stack.peek()] == '(') {
					stack.pop();
				}
    			else{
    				stack.push(i);
    			}
    		}
    	}
    	if(stack.isEmpty()){
    		return s.length();    		
    	}
    	else{
    		int high = s.length();
    		int max = 0;
    		while(!stack.isEmpty()){
    			int low = stack.pop();
    			max = Math.max(max, high - (low + 1));
    			high = low;
    		}
    		max = Math.max(max, high -0);
    		return max;
    	}
    }
}
