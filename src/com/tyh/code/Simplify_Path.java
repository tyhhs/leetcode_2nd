package com.tyh.code;

import java.util.Stack;

public class Simplify_Path {

	public static void main(String[] args) {
		String path = "/home/";
		System.out.println(new Simplify_Path().simplifyPath(path));
	}

    public String simplifyPath(String path) {
    	Stack<String> stack = new Stack<String>();
    	StringBuilder sb = new StringBuilder();
    	path = path + "/";
    	for(char c : path.toCharArray()){
    		if(c == '/'){
    			if(sb.toString().equals("..")){
    				if(!stack.isEmpty()){
    					stack.pop();
    				}
    			}
    			else if(!sb.toString().equals(".")){
    				if(sb.length() != 0){
    					stack.push(sb.toString());    					
    				}
    			}
    			sb = new StringBuilder();
    		}
    		else{
    			sb.append(c);
    		}
    	}
    	
    	if(stack.isEmpty()){
    		return "/";
    	}
    	sb = new StringBuilder();
    	while(!stack.isEmpty()){
    		sb.insert(0,"/"+stack.pop());
    	}
    	return sb.toString();
    }
}
