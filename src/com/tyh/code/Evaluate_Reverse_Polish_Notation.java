package com.tyh.code;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token : tokens){
            if(isOperator(token)){
                int n1 = stack.pop();
                int n2 = stack.pop();
                int res = operation(n1, n2, token);
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private int operation(int n1, int n2, String operator){
        char op = operator.toCharArray()[0];
        if(op == '+'){
            return n1 + n2;
        }
        else if(op == '-'){
            return n2 - n1;
        }
        else if(op == '*'){
            return n1 * n2;
        }
        else{
            return n2 / n1;
        }
    }
    
    private boolean isOperator(String token){
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
            return true;
        }
        return false;
    }
}
